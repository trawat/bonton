package com.desia.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bonton.utility.artifacts.BTNCancelRQ;
import com.bonton.utility.artifacts.BTNCancelRS;
import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNConfirmResponse;
import com.bonton.utility.artifacts.BTNFinalBookingRQ;
import com.bonton.utility.artifacts.BTNFinalBookingRS;
import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.bonton.utility.artifacts.BTNRepriceResponse;
import com.bonton.utility.artifacts.BTNSearchRequest;
import com.bonton.utility.artifacts.BTNSearchResponse;
import com.bonton.utility.processor.XmlProcessor;
import com.desia.artifacts.booking.OTACancelRQ;
import com.desia.artifacts.booking.OTACancelRS;
import com.desia.artifacts.booking.OTAHotelResRQ;
import com.desia.artifacts.booking.OTAHotelResRS;
import com.desia.artifacts.search.OTAHotelAvailRQ;
import com.desia.artifacts.search.OTAHotelAvailRS;

/**
 * Entry point into Desia API.
 * Contains methods for each operation possible/ provided by Desia Service API.
 * @author Tirath
 * @see DesiaSearchServiceHelper
 */
public class DesiaService {
	private static Logger logger = LoggerFactory.getLogger(DesiaService.class);
	
	/** Holds unique uuid and generated common response object as key-value */
	private static final Map<String, BTNSearchResponse> rqRsMap = new HashMap<>();
	
	/**
	 * Used to trigger Desia search operation. This operation is handled
	 * diffently from other available operation as returned response will  
	 * contain hotel suggestions from other service providers also.
	 * @param btnSearchRQ Bonton search request bean
	 * @param uuid unique identifier for this search operation
	 * @throws Exception
	 * @author Tirath
	 */
	public void search(BTNSearchRequest btnSearchRQ, String uuid) throws Exception {
		logger.info("desia search operation started ---->");
		OTAHotelAvailRQ otaHotelAvailRQ = DesiaSearchServiceHelper.searchBeanRQMapper(btnSearchRQ);
		
		OTAHotelAvailRS otaHotelAvailRS = DesiaSearchServiceHelper.sendSearchRQ(otaHotelAvailRQ);
		
		BTNSearchResponse btnSearchResponse = DesiaSearchServiceHelper.searchBeanRSMapper(otaHotelAvailRS);
		logger.info("desia search operation done ---->");
		rqRsMap.put(uuid, btnSearchResponse);
	}
	
	/**
	 * Used to trigger Desia PROVISIONAL booking operation.
	 * @param btnConfirmRQ Bonton confirm request bean
	 * @return XML representation of Bonton confirm response
	 * @throws Exception
	 * @author Tirath
	 */
	public String confirmBooking(BTNConfirmRequest btnConfirmRQ, String uuid) throws Exception {
		logger.info("desia confirm booking operation started ---->");
		OTAHotelResRQ otaHotelResRQ = DesiaBookingServiceHelper.provisionalBeanRQMapper(btnConfirmRQ);
		
		OTAHotelResRS otaHotelResRS = DesiaBookingServiceHelper.sendProvisionalBookingRQ(otaHotelResRQ);
		
		BTNConfirmResponse btnConfirmResponse = DesiaBookingServiceHelper.provisionalBeanRSMapper(otaHotelResRS);
		logger.info("desia confirm booking operation done ---->");
		return XmlProcessor.getBeanInXml(btnConfirmResponse);
	}
	
	/**
	 * Used to trigger Desia cancel booking operation.
	 * @param btnCancelRQ Bonton cancel request bean
	 * @return XML representation of Bonton cancel response
	 * @throws Exception
	 * @author Tirath
	 */
	public String cancelBooking(BTNCancelRQ btnCancelRQ, String uuid) throws Exception {
		logger.info("desia cancel booking operation started ---->");
		OTACancelRQ otaCancelRQ = DesiaBookingServiceHelper.cancelBeanRQMapper(btnCancelRQ);

		OTACancelRS otaCancelRS = DesiaBookingServiceHelper.sendCancelRQ(otaCancelRQ);

		BTNCancelRS btnCancelRS = DesiaBookingServiceHelper.cancelBeanRSMapper(otaCancelRS);
		logger.info("desia cancel booking operation done ---->");
		return XmlProcessor.getBeanInXml(btnCancelRS);
	}
	
	/**
	 * Returns a dummy response as there is no concept of repricing in Desia API.
	 * @param btnRepriceRQ Bonton reprice request bean.
	 * @return XML representation of Bonton reprice response
	 * @throws Exception
	 * @author Tirath
	 */
	public String repricing(BTNRepriceRequest btnRepriceRQ, String uuid) throws Exception {
		logger.info("desia reprice operation started ---->");

		BTNRepriceResponse btnRepriceResponse = new BTNRepriceResponse();
		logger.info("desia reprice operation done ---->");
		return XmlProcessor.getBeanInXml(btnRepriceResponse);
	}

	/**
	 * Used to trigger Desia final booking operation.
	 * @param btnFinalBookingRQ Bonton final booking request bean.
	 * @return XML representation of Bonton final booking response
	 * @throws Exception
	 * @author Tirath
	 */
	public String finalBooking(BTNFinalBookingRQ btnFinalBookingRQ, String uuid) throws Exception {
		logger.info("desia reprice operation started ---->");
		OTAHotelResRQ otaHotelResRQ = DesiaBookingServiceHelper.finalBookingRQMapper(btnFinalBookingRQ);

		OTAHotelResRS otaHotelResRS = DesiaBookingServiceHelper.sendFinalBookingRQ(otaHotelResRQ);

		BTNFinalBookingRS btnFinalBookingRS = DesiaBookingServiceHelper.finalBookingRSMapper(otaHotelResRS);
		logger.info("desia reprice operation done ---->");
		return XmlProcessor.getBeanInXml(btnFinalBookingRS);
	}

	
	
	/**
	 * This method exist to help solely to help in the search result aggregation logic.
	 * @param uuid unique identifier for this repricing operation
	 * @return Bonton search response object from Desia supplier
	 * @author Tirath
	 */
	public BTNSearchResponse getAvailabilityRS(String uuid) {
		return rqRsMap.get(uuid);
	}
}
