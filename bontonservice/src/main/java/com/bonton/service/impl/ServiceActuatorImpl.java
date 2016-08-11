package com.bonton.service.impl;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.xml.bind.UnmarshalException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bonton.service.ServiceActuator;
import com.bonton.service.ServiceProxy;
import com.bonton.service.adapter.DesiaServiceProxyAdapter;
import com.bonton.service.adapter.HBServiceProxyAdapter;
import com.bonton.util.BTNProperties;
import com.bonton.util.BTNUtility;
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
	
	@Override
	public String search(final InputStream is) throws Exception {
		final BTNSearchRequest btnSearchRQ = XmlProcessor.getBTNSearchRQBean(is);
		
		List<? extends ServiceProxy> serviceList = BTNUtility.getEnabledEndPointsList(btnSearchRQ.getSupplier());
		int availableSPCount = serviceList.size();
		
		/** Case, when no service provider is active or in case of socket exception */
		if (availableSPCount == 0) {
			logger.info(BTNProperties.APIErrorMSG);
			BTNSearchResponse.BTNError errElmnt = new BTNSearchResponse.BTNError();
			errElmnt.setCode(BTNProperties.APIError);
			errElmnt.setMessage(BTNProperties.APIErrorMSG);

			BTNSearchResponse btnSearchRS = new BTNSearchResponse();
			btnSearchRS.setBTNError(errElmnt);

			return XmlProcessor.getBeanInXml(btnSearchRS);
		}
		
		final String uuid = getRandonUUID();
		final boolean manySp = availableSPCount > 1;
		
		List<Future<Boolean>> taskLst = new LinkedList<Future<Boolean>>();
		try {
			/* Trigger task threads */
			for (final ServiceProxy sp : serviceList) {
				Future<Boolean> submtedTask = es.submit(new Runnable() {
					@Override
					public void run() {
						try {
							sp.search(btnSearchRQ, uuid, manySp);
						} catch (Exception exception) {
							logger.error("{} occured while triggering search operation", exception);
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
			}
		}
		
		final List<BTNSearchResponse.HotelOptions.Hotel> hotelLst = new LinkedList<>();
		
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
						List<BTNSearchResponse.HotelOptions.Hotel> tmpHotelLst = tmpHotelOptions.getHotel();
						
						if (!tmpHotelLst.isEmpty()) {
							hotelLst.addAll(tmpHotelLst);
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
		
		BTNSearchResponse btnSearchRS = new BTNSearchResponse();
		btnSearchRS.setOptionsCount(hotelLst.size());
		
		btnSearchRS.setCity(new BTNSearchResponse.City());
		btnSearchRS.getCity().setCityCode(btnSearchRQ.getRequestDetails().getSearchHotelPriceRequest()
				.getItemDestination().getDestinationCode());
		
		
		if (!hotelLst.isEmpty()) {
			btnSearchRS.setHotelOptions(new BTNSearchResponse.HotelOptions());
			btnSearchRS.getHotelOptions().getHotel().addAll(hotelLst);
		}

		String responseXml = XmlProcessor.getBeanInXml(btnSearchRS);
		
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
		
		return BTNUtility.getProxyItem(btnConfirmRQ.getSupplier()).confirmBooking(btnConfirmRQ, getRandonUUID());
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
		
		return BTNUtility.getProxyItem(btnCancelRQ.getSupplier()).cancelBooking(btnCancelRQ, getRandonUUID());
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
		
		return BTNUtility.getProxyItem(btnRepriceRQ.getSupplier()).repricing(btnRepriceRQ, getRandonUUID());
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
		return BTNUtility.getProxyItem(btnFinalBookingRQ.getSupplier()).finalBooking(btnFinalBookingRQ, getRandonUUID());
	}
	
	private static String getRandonUUID() {
		return UUID.randomUUID().toString();
	}

	@Override
	public String provisionalBooking(InputStream is) throws Exception {
		BTNConfirmRequest btnConfirmRQ = null;
		
		try {
			btnConfirmRQ = XmlProcessor.getBTNConfirmRQBean(is);
		} catch (Exception exception) {
			/** Return informative error message in case the submitted request is not proper */
			return XmlProcessor.getBeanInXml(XmlProcessor.getBTNConfirmErrorRS(exception));
		}
			
		return BTNUtility.getProxyItem(btnConfirmRQ.getSupplier()).provisionalBooking(btnConfirmRQ, getRandonUUID());
	}
}
