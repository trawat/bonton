package com.hotelbeds.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bonton.utility.artifacts.BTNCancelRQ;
import com.bonton.utility.artifacts.BTNCancelRS;
import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNConfirmResponse;
import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.bonton.utility.artifacts.BTNRepriceResponse;
import com.bonton.utility.artifacts.BTNSearchRequest;
import com.bonton.utility.artifacts.BTNSearchResponse;
import com.bonton.utility.hotelbeds.AvailabilityRQ;
import com.bonton.utility.hotelbeds.AvailabilityRS;
import com.bonton.utility.hotelbeds.BookingCancellationRS;
import com.bonton.utility.hotelbeds.BookingRQ;
import com.bonton.utility.hotelbeds.BookingRS;
import com.bonton.utility.hotelbeds.CheckRateRS;
import com.bonton.utility.processor.XmlProcessor;
import com.hotelbeds.util.HBClient;
import com.hotelbeds.util.HBProperties;

/**
 * Entry point into HotelBeds API. Contains a methods for every operation
 * which can be triggered against HotelBeds. 
 * @author Tirath
 */
public class HBService {
	private static Logger logger = LoggerFactory.getLogger(HBService.class);
	
	/** Holds unique uuid and generated common response object as key-value */
	private static final Map<String, BTNSearchResponse> rqRsMap = new HashMap<>();
	
	/**
	 * Used to trigger HotelBeds search operation. This operation is handled
	 * diffently from other available operation as returned response will  
	 * contain hotel suggestions from other service providers also. 
	 * @param btnSearchRQ search request bean
	 * @param uuid unique identifier for this search operation
	 * @throws Exception
	 */
	public void search(BTNSearchRequest btnSearchRQ, String uuid) throws Exception {
		logger.info("hotelbeds search operation started ---->");
		AvailabilityRQ availabilityRQ = HBServiceHelper.searchBeanRQMapper(btnSearchRQ, uuid);
		AvailabilityRS availabilityRS = HBClient.postSearch(availabilityRQ);
		
		BTNSearchResponse btnSearchRS = HBServiceHelper.searchBeanRSMapper(availabilityRS, uuid);
		
		rqRsMap.put(uuid, btnSearchRS);
		HBServiceHelper.logReqRes(uuid, "Search", HBProperties.HB);
		logger.info("hotelbeds search operation done ---->");
	}
	
	/**
	 * Used to trigger HotelBeds booking operation.
	 * @param btnConfirmRQ confirm request bean
	 * @param uuid unique identifier for this confirm operation
	 * @return XML representation of Bonton confirm response
	 * @throws Exception
	 */
	public String confirmBooking(BTNConfirmRequest btnConfirmRQ, String uuid) throws Exception {
		logger.info("hotelbeds confirm operation started ---->");
		BookingRQ bookingRQ = HBServiceHelper.confirmBeanRQMapper(btnConfirmRQ, uuid);
		BookingRS bookingRS = HBClient.postConfirmBooking(bookingRQ);
		
		BTNConfirmResponse btnConfirmRS = HBServiceHelper.confirmBeanRSMapper(bookingRS, uuid);
		
		HBServiceHelper.logReqRes(uuid, "Confirm", HBProperties.HB);
		
		logger.info("hotelbeds confirm operation done ---->");
		return XmlProcessor.getBeanInXml(btnConfirmRS);
	}
	
	/**
	 * Used to trigger HotelBeds booking cancellation operation.
	 * @param btnCancelRQ cancel request bean
	 * @param uuid unique identifier for this cancel operation
	 * @return XML representation of Bonton cancel response
	 * @throws Exception
	 */
	public String cancelBooking(BTNCancelRQ btnCancelRQ, String uuid) throws Exception {
		logger.info("hotelbeds cancel booking operation started ---->");
		BookingCancellationRS cancelRS = HBServiceHelper.cancelBeanRQMapper(btnCancelRQ, uuid);

		BTNCancelRS btnCancelRS = HBServiceHelper.cancelBeanRSMapper(cancelRS, uuid);
		
		HBServiceHelper.logReqRes(uuid, "Cancel", HBProperties.HB);
		logger.info("hotelbeds search operation done ---->");
		return XmlProcessor.getBeanInXml(btnCancelRS);
	}
	
	/**
	 * Used to trigger HotelBeds repricing operation.
	 * @param btnRepriceRQ repricing request bean
	 * @param uuid unique identifier for this repricing operation
	 * @return XML representation of Bonton reprice response
	 * @throws Exception
	 */
	public String repricing(BTNRepriceRequest btnRepriceRQ, String uuid) throws Exception {
		logger.info("hotelbeds repricing operation started ---->");
		CheckRateRS repriceRS = HBServiceHelper.repriceBeanRQMapper(btnRepriceRQ, uuid);
		
		BTNRepriceResponse btnRepriceRS = HBServiceHelper.repriceBeanRSMapper(repriceRS, uuid);
		
		HBServiceHelper.logReqRes(uuid, "Reprice", HBProperties.HB);
		logger.info("hotelbeds search operation done ---->");
		return XmlProcessor.getBeanInXml(btnRepriceRS);
	}
	
	/**
	 * This method exist to help solely to help in the search result aggregation logic.
	 * @param uuid unique identifier for this repricing operation
	 * @return Bonton search response object from HotelBeds supplier
	 */
	public BTNSearchResponse getAvailabilityRS(String uuid) {
		return rqRsMap.get(uuid);
	}
}
