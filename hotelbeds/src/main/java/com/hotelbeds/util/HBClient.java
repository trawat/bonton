package com.hotelbeds.util;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.commons.codec.digest.DigestUtils;
import org.glassfish.jersey.client.filter.EncodingFilter;
import org.glassfish.jersey.message.GZipEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bonton.utility.artifacts.BTNCancelRQ;
import com.bonton.utility.hotelbeds.AvailabilityRS;
import com.bonton.utility.hotelbeds.BookingCancellationRS;
import com.bonton.utility.hotelbeds.BookingRS;
import com.bonton.utility.hotelbeds.CheckRateRS;

/**
 * Helper class contains logic to post HotelBeds specific RQ 
 * objects to HotelBeds API and retrieve expected RS's. 
 * @author Tirath
 */
public class HBClient {
	private static Logger logger = LoggerFactory.getLogger(HBClient.class);
	private static Client hbRsClient = null;
	private static MultivaluedMap<String, Object> headers = new MultivaluedHashMap<String, Object>();
	private static final String HEADER_SEPARATOR = "----->";
	private static final String COMMA = ", ";
	
	private HBClient() {/**Shouldn't be instantiated*/ }
	
	static {
		hbRsClient = getOrInitializeHBClient();
	}
	
	/**
	 * Used to post RQ object to HotelBeds API.
	 * @param rqObj Object which will be posted to HotelBeds API
	 * @param target Contains the URI information
	 * @param clazz Specifies expected returned type in the RS of this posting
	 * @return Object instance which is later cast back to specific type
	 * @throws Exception In case any thing goes wrong during posting of this RQ.
	 * @author Tirath
	 */ 
	private static <T> Object post(T rqObj, WebTarget target, Class<?> clazz) throws Exception {
		Invocation.Builder builder = target.request()
		.headers(getHeaders());
		
		Entity<T> entity = Entity.entity(rqObj, MediaType.APPLICATION_XML);
		Invocation invoker = builder.buildPost(entity);

		Response response = invoker.invoke();
		printRQRSHeaders(response);
		
		return response.readEntity(clazz);
	}
	
	/**
	 * Used to post hotel availability RQ object to HotelBeds API
	 * @param bean HotelBeds specific availability RQ object
	 * @return HotelBeds specific availability RS object.
	 * @throws Exception In case the posting fails or the returned RS
	 * could not be unmarshalled to the expected RS object.
	 * @author Tirath
	 */
	public static <T> AvailabilityRS postSearch(T bean) throws Exception {
		logger.info("search request posting to HotelBeds started ---->");
		WebTarget target = getOrInitializeHBClient().target(HBUtility.getProperty(HBProperties.HB_SEARCH_HOTELS_END_POINT));
		logger.info("search request posting to HotelBeds done ---->");
		return (AvailabilityRS) post(bean, target, AvailabilityRS.class);
	}
	
	/**
	 * Used to post hotel booking confirmation RQ object to HotelBeds API
	 * @param bean HotelBeds specific booking confirmation RQ object
	 * @return HotelBeds specific booking confirmation RS object.
	 * @throws Exception In case the posting fails or the returned RS
	 * could not be unmarshalled to the expected RS object.
	 * @author Tirath
	 */
	public static <T> BookingRS postConfirmBooking(T bean) throws Exception {
		logger.info("booking confirmation request posting to HotelBeds started ---->");
		WebTarget target = getOrInitializeHBClient().target(HBUtility.getProperty(HBProperties.HB_CONFIRM_BOOKING_END_POINT));
		logger.info("booking confirmation request posting to HotelBeds done ---->");
		return (BookingRS) post(bean, target, BookingRS.class);
	}
	
	/**
	 * Used to post hotel booking cancellation RQ object to HotelBeds API 
	 * @param bean HotelBeds specific booking cancellation RQ object
	 * @return HotelBeds specific booking cancellation RS object.
	 * @throws Exception In case the posting fails or the returned RS
	 * could not be unmarshalled to the expected RS object.
	 * @author Tirath
	 */
	public static <T> BookingCancellationRS postCancelBooking(T bean) throws Exception {
		logger.info("cancel request posting to HotelBeds started ---->");
		
		WebTarget target = getOrInitializeHBClient().target(HBUtility.getProperty(HBProperties.HB_CANCEL_BOOKING_END_POINT))
				.resolveTemplate(HBProperties.REF_ID, ((BTNCancelRQ) bean).getCancelDetails().getReferenceId())
				.resolveTemplate(HBProperties.CNCL_FLG, ((BTNCancelRQ) bean).getCancelDetails().getCancelFlag());
		
		/* done differently from other methods */
		Invocation.Builder builder = target.request()
				.accept(MediaType.APPLICATION_XML)
				.acceptLanguage(Locale.ENGLISH)
				.headers(getHeaders());
		
		Invocation invoker = builder.buildDelete();
		Response response = invoker.invoke();
		
		logger.info("cancel request posting to HotelBeds done ---->");
		return response.readEntity(BookingCancellationRS.class);
	}
	
	/**
	 * Post the Bonton cancellation request bean to HotelBeds and
	 * @param bean HotelBeds specific reprice RQ object
	 * @return HotelBeds specific reprice RS object.
	 * @throws Exception In case the posting fails or the returned RS
	 * could not be unmarshalled to the expected RS object.
	 * @author Tirath
	 */
	public static <T> CheckRateRS postRepricing(T bean) throws Exception {
		logger.info("reprice request posting to HotelBeds started ---->");
		WebTarget target = getOrInitializeHBClient().target(HBUtility.getProperty(HBProperties.HB_REPRICE_POST_END_POINT));
		
		logger.info("reprice request posting to HotelBeds done ---->");
		return (CheckRateRS) post(bean, target, CheckRateRS.class);
	}
	
	/**
	 * Helper method to generate digest for every request posted
	 * to HotelBeds API.
	 * @return
	 */
	private static MultivaluedMap<String, Object> getHeaders() {
		headers.putSingle(HBProperties.SIGNATURE_HEADER_NAME, 
				DigestUtils.sha256Hex(HBUtility.getProperty(HBProperties.API_KEY) 
						+ HBUtility.getProperty(HBProperties.SHARED_SECRET) + System.currentTimeMillis() / 1000));
		return headers;
	}
	
	private static final void printRQRSHeaders(Response response) {
		MultivaluedMap<String, Object> responseHeaders = response.getHeaders();
		Set<Map.Entry<String, List<Object>>> headerEntries = responseHeaders.entrySet();
		
		for (Map.Entry<String, List<Object>> entry : headerEntries) {
			StringBuilder temp = new StringBuilder();
			temp.append(entry.getKey());
			List<Object> tempHeaderObjLst = entry.getValue();
			
			if (null != tempHeaderObjLst && tempHeaderObjLst.size() != 0) {
				temp.append(HEADER_SEPARATOR);
				for (Object headerObj : tempHeaderObjLst) {
					temp.append(headerObj);
					temp.append(COMMA);
				}
			}
			String headerStr = temp.toString();
			headerStr = headerStr.substring(0, headerStr.lastIndexOf(COMMA));
			logger.debug(headerStr);
		}
	}
	
	private static final Client getOrInitializeHBClient() {
		if (hbRsClient == null) {
			try {
				hbRsClient = ClientBuilder.newClient();
				hbRsClient.register(GZipEncoder.class);
				hbRsClient.register(EncodingFilter.class);
				/* Request headers */
				headers.putSingle(HBProperties.API_KEY_HEADER_NAME, HBUtility.getProperty(HBProperties.API_KEY));
				headers.putSingle(HttpHeaders.USER_AGENT, HBProperties.USER_AGENT);
				headers.putSingle(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML);
				
				/* Response headers */
				headers.putSingle(HttpHeaders.ACCEPT, MediaType.APPLICATION_XML);
				headers.putSingle(HttpHeaders.ACCEPT_ENCODING, HBProperties.ENCODING);
				headers.putSingle(HttpHeaders.CONTENT_ENCODING, HBProperties.ENCODING);
			} catch (Exception exception) {
				/* try closing the client */
				if (hbRsClient != null) {
					hbRsClient.close();
				}
				throw exception;
			}
			return hbRsClient;
		}
		return hbRsClient;
	}
	
}
