package com.desia.service;

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
 * @see DesiaServiceHelper
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
		OTAHotelAvailRQ otaHotelAvailRQ = DesiaServiceHelper.searchBeanRequestMapper(btnSearchRQ);
		
		OTAHotelAvailRS otaHotelAvailRS = DesiaServiceHelper.sendSearchRequest(otaHotelAvailRQ);
		
		BTNSearchResponse btnSearchResponse = DesiaServiceHelper.searchBeanResponseMapper(otaHotelAvailRS);
		logger.info("desia search operation done ---->");
		rqRsMap.put(uuid, btnSearchResponse);
	}
	
	/**
	 * Used to trigger Desia confirm booking operation.
	 * @param btnConfirmRQ Bonton confirm request bean
	 * @return XML representation of Bonton confirm response
	 * @throws Exception
	 * @author Tirath
	 */
	public String confirmBooking(BTNConfirmRequest btnConfirmRQ) throws Exception {
		logger.info("desia confirm booking operation started ---->");
		OTAHotelResRQ otaHotelResRQ = DesiaServiceHelper.confirmBeanRequestMapper(btnConfirmRQ);
		
		OTAHotelResRS otaHotelResRS = DesiaServiceHelper.sendConfirmRequest(otaHotelResRQ);
		
		BTNConfirmResponse btnConfirmResponse = DesiaServiceHelper.confirmBeanResponseMapper(otaHotelResRS);
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
	public String cancelBooking(BTNCancelRQ btnCancelRQ) throws Exception {
		logger.info("desia cancel booking operation started ---->");
		OTACancelRQ otaCancelRQ = DesiaServiceHelper.cancelBeanRequestMapper(btnCancelRQ);

		OTACancelRS otaCancelRS = DesiaServiceHelper.sendCancelRequest(otaCancelRQ);

		BTNCancelRS btnCancelRS = DesiaServiceHelper.cancelBeanResponseMapper(otaCancelRS);
		logger.info("desia cancel booking operation done ---->");
		return XmlProcessor.getBeanInXml(btnCancelRS);
	}
	
	/**
	 * Used to trigger Desia repricing operation.
	 * @param btnRepriceRQ Bonton reprice request bean.
	 * @return XML representation of Bonton reprice response
	 * @throws Exception
	 * @author Tirath
	 */
	public String repricing(BTNRepriceRequest btnRepriceRQ) throws Exception {
		logger.info("desia reprice operation started ---->");
		OTAHotelResRQ otaHotelResRQ = DesiaServiceHelper.repriceBeanRequestMapper(btnRepriceRQ);

		OTAHotelResRS otaHotelResRS = DesiaServiceHelper.sendRepriceRequest(otaHotelResRQ);

		BTNRepriceResponse btnRepriceResponse = DesiaServiceHelper.repriceBeanResponseMapper(otaHotelResRS);
		logger.info("desia reprice operation done ---->");
		return XmlProcessor.getBeanInXml(btnRepriceResponse);
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
