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

import com.bonton.service.ServiceActuator;
import com.bonton.service.ServiceProxy;
import com.bonton.service.adapter.DesiaServiceProxyAdapter;
import com.bonton.service.adapter.ExpediaServiceProxyAdapter;
import com.bonton.service.adapter.HBServiceProxyAdapter;
import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.bonton.utility.artifacts.BTNSearchResponse;
import com.bonton.utility.processor.XmlProcessor;

public class ServiceActuatorImpl implements ServiceActuator {
	private static final ExecutorService es = Executors.newCachedThreadPool();
	
	@Override
	public String search(List<? extends ServiceProxy> serviceList, final InputStream is) throws Exception {
		final String uuid = UUID.randomUUID().toString();
		final boolean manySp = serviceList.size() > 1;
		
		List<Future<Boolean>> taskLst = new LinkedList<Future<Boolean>>();
		
		/* Trigger task threads */
		for (final ServiceProxy sp : serviceList) {
			Future<Boolean> submtedTask = es.submit(new Runnable() {
				@Override
				public void run() {
					try {
						sp.search(is, uuid, manySp);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}}, true);
			taskLst.add(submtedTask);
		}
		
		/* Wait for all the submitted tasks to complete */
		for (Future<Boolean> task : taskLst) {
			task.get();
		}
		
		/* Start result aggregation process. Done by the initial thread. */
		
		/* For one SP, return the result as it is.*/
		if (!manySp) {
			if (serviceList.get(0) instanceof HBServiceProxyAdapter) {
				return XmlProcessor.getBeanInXml(serviceList.get(0).getHBServiceInstance().getAvailabilityRS(uuid));
			} else if (serviceList.get(0) instanceof DesiaServiceProxyAdapter) {
				//return XmlProcessor.getBeanInXml(serviceList.get(0).getDesiaServiceInstance().getAvailabilityRS(uuid));
			} else if (serviceList.get(0) instanceof ExpediaServiceProxyAdapter) {
				//return XmlProcessor.getBeanInXml(serviceList.get(0).getHBServiceInstance().getAvailabilityRS(uuid));
			} else {
				//TODO: put in a check for the case none of the services are available
			}
			
//			Class<?> serviceType = (Class<?>) serviceList.get(0).getServiceInstance().getClass().get;
//			 ((serviceType) serviceList.get(0).getServiceInstance())
		}
		/**
		 * Concurrency level equals to the no. of service provider threads.
		 * Bonton hotel code and associated rooms represents Key-Value pair. 
		 */
		final Map<String, List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room>> indxedHtlRoom = new ConcurrentHashMap<>(16, .75f, 3);
		
		for (final ServiceProxy sp : serviceList) {
			final BTNSearchResponse btnSearchResponse = sp.getHBServiceInstance().getAvailabilityRS(uuid);
			Future<Boolean> submtedTask = es.submit(new Runnable() {
				@Override
				public void run() {
					try {
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
								roomLst.addAll(hotel.getRoomOptions().getRoom());
							}
							
						}
					} catch (Exception e) {
						e.printStackTrace();
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
		List<BTNSearchResponse.HotelOptions.Hotel> hotelLst = btnSearchResponse.getHotelOptions().getHotel();
		
		Iterator<Entry<String, List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room>>> itr = indxedHtlRoom.entrySet().iterator();
		
		int index = 0;
		Entry<String, List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room>> entry = null;
		while (itr.hasNext()) {
			entry = itr.next();
			hotelLst.get(index).setHotelCode(entry.getKey());
			hotelLst.get(index).getRoomOptions().getRoom().addAll(entry.getValue());
		}
		
		String responseXml = XmlProcessor.getBeanInXml(btnSearchResponse);
		
		//TODO: Get rid of the indexes before returning
			
		return responseXml;
	}
	
	@Override
	public String confirm(InputStream is) throws Exception {
		BTNConfirmRequest confirmBean = XmlProcessor.getBTNConfirmRQBean(is);
		String supplier = confirmBean.getSupplier();
		
		if ("HotelBeds".equalsIgnoreCase(supplier)) {
			return new HBServiceProxyAdapter().confirmBooking(supplier, confirmBean);
		}
		
		return null;
	}

	@Override
	public String cancel(InputStream is) throws Exception {
		return null;
	}

	@Override
	public String repricing(InputStream is) throws Exception {
		BTNRepriceRequest repriceBean = XmlProcessor.getBTNRepriceRQBean(is);
		String supplier = repriceBean.getSupplier();
		
		if ("HotelBeds".equalsIgnoreCase(supplier)) {
			return new HBServiceProxyAdapter().repricing(supplier, repriceBean);
		}
		return null;
	}
	
}
