package com.desia.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.desia.artifacts.booking.OTACancelRQ;
import com.desia.artifacts.booking.OTACancelRS;
import com.desia.artifacts.booking.OTAHotelResRQ;
import com.desia.artifacts.booking.OTAHotelResRS;
import com.desia.artifacts.booking.TGBookingServiceEndPoint;
import com.desia.artifacts.booking.TGBookingServiceEndPointImplService;
import com.desia.artifacts.search.OTAHotelAvailRQ;
import com.desia.artifacts.search.OTAHotelAvailRS;
import com.desia.artifacts.search.TGServiceEndPoint;
import com.desia.artifacts.search.TGServiceEndPointImplService;

/**
 * Act as a client for Desia SOAP based web service. Contains methods 
 * which are used to send/ receive soap request and response respectively. 
 * @author Tirath
 * @see DesiaService
 */
public class DesiaClient {
	private static Logger logger = LoggerFactory.getLogger(DesiaClient.class);
	
	/** For search service. */
	private static final TGServiceEndPointImplService searchSIB = new TGServiceEndPointImplService();
	private static TGServiceEndPoint searchSEI = null;
	
	/** For booking service. */
	private static final TGBookingServiceEndPointImplService bookingSIB = new TGBookingServiceEndPointImplService();
	private static TGBookingServiceEndPoint bookingSEI = null;
	
	static {
		/** 
		 * Uncomment, if request and responses are supposed to be printed 
		 * on the console for manual testing.
		 */
		/*
		HandlerResolver handlerResolver = new HandlerResolver() {
			@Override
			public List<Handler> getHandlerChain(PortInfo portInfo) {
				List<Handler> handler = new LinkedList<>();
				handler.add(new MessageHandler());
				return handler;
			}
		};
		searchSIB.setHandlerResolver(handlerResolver);
		bookingSIB.setHandlerResolver(handlerResolver);
		*/
	}
	
	static {
		try {
			searchSEI = (TGServiceEndPoint) searchSIB.getTGServiceEndPointImplPort();
		} catch(ExceptionInInitializerError staticInitializationErr) {
			searchSEI = null;
		}
		try {
			bookingSEI = (TGBookingServiceEndPoint) bookingSIB.getTGBookingServiceEndPointImplPort();
		} catch(ExceptionInInitializerError staticInitializationErr) {
			bookingSEI = null;
		}
	}
	
	public static OTAHotelAvailRS sendSearchRQ(OTAHotelAvailRQ otaHotelAvailRQ) throws Exception {
		if (searchSEI == null) {
			logger.info("reinitializing desia search service endpoint");
			searchSEI = (TGServiceEndPoint) searchSIB.getTGServiceEndPointImplPort();
		}
		return searchSEI.fetchResponse(otaHotelAvailRQ);
	}
	
	public static OTAHotelResRS sendFinalBookingRQ(OTAHotelResRQ otaHotelResRQ) throws Exception {
		return getBookingSEI().createBooking(otaHotelResRQ);
	}
	
	public static OTAHotelResRS sendProvisionalBookingRQ(OTAHotelResRQ otaHotelResRQ) throws Exception {
		return getBookingSEI().createBooking(otaHotelResRQ);
	}
	
	public static OTACancelRS sendCancelRQ(OTACancelRQ otaCancelRQ) throws Exception {
		return getBookingSEI().cancelBooking(otaCancelRQ);
	}
	
	private static TGBookingServiceEndPoint getBookingSEI() {
		if (bookingSEI == null) {
			logger.info("reinitializing desia booking service endpoint");
			bookingSEI = (TGBookingServiceEndPoint) bookingSIB.getTGBookingServiceEndPointImplPort();
		}
		return bookingSEI;
	}
}
