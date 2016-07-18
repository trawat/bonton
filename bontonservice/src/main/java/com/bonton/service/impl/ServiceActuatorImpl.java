package com.bonton.service.impl;

import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.xml.bind.UnmarshalException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bonton.service.ServiceActuator;
import com.bonton.service.ServiceProxy;
import com.bonton.service.adapter.DesiaServiceProxyAdapter;
import com.bonton.service.adapter.ExpediaServiceProxyAdapter;
import com.bonton.service.adapter.HBServiceProxyAdapter;
import com.bonton.util.BTNProperties;
import com.bonton.utility.artifacts.BTNCancelRQ;
import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNFinalBookingRQ;
import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.bonton.utility.artifacts.BTNSearchRequest;
import com.bonton.utility.artifacts.BTNSearchResponse;
import com.bonton.utility.processor.XmlProcessor;

/**
 * Holds the logic to trigger available operations to the request 
 * specific service provider based on the available service provider
 * (in case of search) or the value of <Supplier> node for the other
 * operations. 
 * @author Tirath
 * @see ServiceActuator
 */
public class ServiceActuatorImpl implements ServiceActuator {
	private static final Logger logger = LoggerFactory.getLogger(ServiceActuatorImpl.class);
	private static final ExecutorService es = Executors.newCachedThreadPool();
	
	private final HBServiceProxyAdapter hbServicePxyAdpter = new HBServiceProxyAdapter();
	private final DesiaServiceProxyAdapter desiaServicePxyAdpter = new DesiaServiceProxyAdapter();
	
	@Override
	public String search(List<? extends ServiceProxy> serviceList, final InputStream is) throws Exception {
		final String uuid = UUID.randomUUID().toString();
		
		int availableSPCount = serviceList.size();
		
		/** Case, when no service provider is active or in case of socket exception */
		if (availableSPCount == 0) {
			BTNSearchResponse.BTNError errElmnt = new BTNSearchResponse.BTNError();
			errElmnt.setCode(BTNProperties.APIError);
			errElmnt.setMessage("No active service provider is available to serve the request.");

			BTNSearchResponse btnSearchRS = new BTNSearchResponse();
			btnSearchRS.setBTNError(errElmnt);

			return XmlProcessor.getBeanInXml(btnSearchRS);
		}
		
		final boolean manySp = availableSPCount > 1;
		
		List<Future<Boolean>> taskLst = new LinkedList<Future<Boolean>>();
		try {
			final BTNSearchRequest requestBean = XmlProcessor.getBTNSearchRQBean(is);
			
			/* Trigger task threads */
			for (final ServiceProxy sp : serviceList) {
				Future<Boolean> submtedTask = es.submit(new Runnable() {
					@Override
					public void run() {
						try {
							sp.search(requestBean, uuid, manySp);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}}, true);
				taskLst.add(submtedTask);
			}
		} catch (Exception exception) {
			logger.error("{} occured while triggering search operation", exception);
			if (exception instanceof UnmarshalException) {
				/** Return informative error message in case the submitted request is not proper */
				return XmlProcessor.getBeanInXml(XmlProcessor.getBTNSearchErrorRS(exception));
			} else {
				throw exception;
			}
		}
		
		/* Wait for all the submitted tasks to complete */
		for (Future<Boolean> task : taskLst) {
			task.get();
		}
		
		/* Start result aggregation process. Done by the initial thread. */
		
		/* For one SP, return the result as it is.*/
		if (!manySp) {
			if (serviceList.get(0) instanceof HBServiceProxyAdapter) {
				return XmlProcessor.getBeanInXml(((HBServiceProxyAdapter) serviceList.get(0)).getServiceInstance().getAvailabilityRS(uuid));
			} else if (serviceList.get(0) instanceof DesiaServiceProxyAdapter) {
				return XmlProcessor.getBeanInXml(((DesiaServiceProxyAdapter) serviceList.get(0)).getServiceInstance().getAvailabilityRS(uuid));
			} else if (serviceList.get(0) instanceof ExpediaServiceProxyAdapter) {
				//return XmlProcessor.getBeanInXml(serviceList.get(0).getHBServiceInstance().getAvailabilityRS(uuid));
			} else {
				//TODO: put in a check for the case none of the services are available
			}
		}
		
		/**
		 * Concurrency level equals to the no. of service provider threads.
		 * Bonton hotel code and associated rooms represents Key-Value pair. 
		 */
		final Map<String, List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room>> indxedHtlRoom = new ConcurrentHashMap<>(16, .75f, 3);
		
		for (final ServiceProxy sp : serviceList) {
			Future<Boolean> submtedTask = es.submit(new Runnable() {
				@Override
				public void run() {
					try {
						BTNSearchResponse btnSearchResponse = null;
						if (sp instanceof HBServiceProxyAdapter) {
							btnSearchResponse = ((HBServiceProxyAdapter) sp).getServiceInstance().getAvailabilityRS(uuid);
						} else if (sp instanceof DesiaServiceProxyAdapter) {
							btnSearchResponse = ((DesiaServiceProxyAdapter) sp).getServiceInstance().getAvailabilityRS(uuid);
						}
						
						BTNSearchResponse.HotelOptions tmpHotelOptions = btnSearchResponse.getHotelOptions();
						
						/** In case, of erred response - HotelOptions will be null */
						if (tmpHotelOptions == null) {
							/** simply return as there is nothing in the returned response to process */
							return;
						}
						List<BTNSearchResponse.HotelOptions.Hotel> hotelLst = btnSearchResponse.getHotelOptions().getHotel();
						
						for (BTNSearchResponse.HotelOptions.Hotel hotel : hotelLst) {
							/* hotel code also needs to be mapped with bonton hotel code*/
							String hotelCode = hotel.getHotelCode();
							
							//TODO: get the bonton code here
							
							List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room> roomLst = indxedHtlRoom.get(hotelCode);
							if (roomLst == null) {
								roomLst = new LinkedList<>();
								roomLst.addAll(hotel.getRoomOptions().getRoom());
								indxedHtlRoom.put(hotelCode, roomLst);
							} else {
								indxedHtlRoom.get(hotelCode).addAll(hotel.getRoomOptions().getRoom());
							}
							
						}
					} catch (Exception e) {
						logger.error("{} occured", e);
					}
				}}, true);
			taskLst.add(submtedTask);
		}
		
		/* Wait for hotel and room list to get prepared */
		for (Future<Boolean> task : taskLst) {
			task.get();
		}
		
		/* Aggregation all set at this point. Prepare final response. */
		BTNSearchResponse btnSearchResponse = new BTNSearchResponse();
		BTNSearchResponse.HotelOptions resHotels = new BTNSearchResponse.HotelOptions();
		List<BTNSearchResponse.HotelOptions.Hotel> hotelLst = resHotels.getHotel();
		
		Iterator<Entry<String, List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room>>> itr = indxedHtlRoom.entrySet().iterator();
		
		Entry<String, List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room>> entry = null;
		while (itr.hasNext()) {
			entry = itr.next();
			
			BTNSearchResponse.HotelOptions.Hotel resHotel = new BTNSearchResponse.HotelOptions.Hotel();
			BTNSearchResponse.HotelOptions.Hotel.RoomOptions resRooms = new BTNSearchResponse.HotelOptions.Hotel.RoomOptions();
			resHotel.setRoomOptions(resRooms);
			
			resHotel.setHotelCode(entry.getKey());
			resHotel.getRoomOptions().getRoom().addAll(entry.getValue());
			
			hotelLst.add(resHotel);
		}
		
		btnSearchResponse.setHotelOptions(resHotels);
		String responseXml = XmlProcessor.getBeanInXml(btnSearchResponse);
		
		//TODO: Get rid of the indexes before returning
			
		return responseXml;
	}
	
	@Override
	public String confirm(InputStream is) throws Exception {
		BTNConfirmRequest btnConfirmRQ = null;
		
		try {
			btnConfirmRQ = XmlProcessor.getBTNConfirmRQBean(is);
		} catch (Exception exception) {
			/** Return informative error message in case the submitted request is not proper */
			return XmlProcessor.getBeanInXml(XmlProcessor.getBTNConfirmErrorRS(exception));
		}
		String supplier = btnConfirmRQ.getSupplier();
		
		if (BTNProperties.HB.equalsIgnoreCase(supplier)) {
			return hbServicePxyAdpter.confirmBooking(btnConfirmRQ, getRandonUUID());
		} else if (BTNProperties.DESIA.equalsIgnoreCase(supplier)) {
			return desiaServicePxyAdpter.confirmBooking(btnConfirmRQ, getRandonUUID());
		}
		
		return null;
	}

	@Override
	public String cancel(InputStream is) throws Exception {
		BTNCancelRQ btnCancelRQ = null;
		
		try {
			btnCancelRQ = XmlProcessor.getBTNCancelRQBean(is);
		} catch (Exception exception) {
			/** Return informative error message in case the submitted request is not proper */
			return XmlProcessor.getBeanInXml(XmlProcessor.getBTNCancelErrorRS(exception));
		}
		String supplier = btnCancelRQ.getSupplier();
		
		if (BTNProperties.HB.equalsIgnoreCase(supplier)) {
			return hbServicePxyAdpter.cancelBooking(btnCancelRQ, getRandonUUID());
		} else if (BTNProperties.DESIA.equalsIgnoreCase(supplier)) {
			return desiaServicePxyAdpter.cancelBooking(btnCancelRQ, getRandonUUID());
		}
		return null;
	}

	@Override
	public String repricing(InputStream is) throws Exception {
		BTNRepriceRequest btnRepriceRQ = null;
		
		try {
			btnRepriceRQ = XmlProcessor.getBTNRepriceRQBean(is);
		} catch (Exception exception) {
			/** Return informative error message in case the submitted request is not proper */
			return XmlProcessor.getBeanInXml(XmlProcessor.getBTNRepriceErrorRS(exception));
		}
		String supplier = btnRepriceRQ.getSupplier();
		
		if (BTNProperties.HB.equalsIgnoreCase(supplier)) {
			return hbServicePxyAdpter.repricing(btnRepriceRQ, getRandonUUID());
		} else if (BTNProperties.DESIA.equalsIgnoreCase(supplier)) {
			return desiaServicePxyAdpter.repricing(btnRepriceRQ, getRandonUUID());
		}
		return null;
	}
	
	@Override
	public String finalBooking(InputStream is) throws Exception {
		BTNFinalBookingRQ btnFinalBookingRQ = null;
		
		try {
			btnFinalBookingRQ = XmlProcessor.getBTNFinalBookingRQBean(is);
		} catch (Exception exception) {
			/** Return informative error message in case the submitted request is not proper */
			return XmlProcessor.getBeanInXml(XmlProcessor.getBTNFinalBookingErrorRS(exception));
		}
		
		/** As final bookong is designed for Desia API only */
		return desiaServicePxyAdpter.finalBooking(btnFinalBookingRQ, getRandonUUID());
	}
	
	private static String getRandonUUID() {
		return UUID.randomUUID().toString();
	}

	@Override
	public String provisionalFinalBooking(InputStream is) throws Exception {
		BTNConfirmRequest btnConfirmRQ = null;
		
		try {
			btnConfirmRQ = XmlProcessor.getBTNConfirmRQBean(is);
		} catch (Exception exception) {
			/** Return informative error message in case the submitted request is not proper */
			return XmlProcessor.getBeanInXml(XmlProcessor.getBTNFinalBookingErrorRS(exception));
		}
			
		return desiaServicePxyAdpter.provisionalFinalBooking(btnConfirmRQ, getRandonUUID());
	}
}
