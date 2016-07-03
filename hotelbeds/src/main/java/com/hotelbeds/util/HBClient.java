package com.hotelbeds.util;

import java.util.Locale;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bonton.utility.artifacts.BTNCancelRQ;
import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.bonton.utility.hotelbeds.AvailabilityRS;
import com.bonton.utility.hotelbeds.BookingCancellationRS;
import com.bonton.utility.hotelbeds.BookingRS;
import com.bonton.utility.hotelbeds.CheckRateRS;

public class HBClient {
	private static Logger logger = LoggerFactory.getLogger(HBClient.class);
	private static Client hbRsClient = null;
	private static MultivaluedMap<String, ? super Object> headers = new MultivaluedHashMap<>();
	
	private HBClient() {}
	
	static {
		try {
			hbRsClient = ClientBuilder.newClient();
			
			/* Request headers */
			headers.putSingle(HBProperties.API_KEY_HEADER_NAME, HBProperties.API_KEY);
			headers.putSingle(HttpHeaders.USER_AGENT, HBProperties.USER_AGENT);
			headers.putSingle(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML);
			headers.putSingle(MediaType.CHARSET_PARAMETER, HBProperties.UTF8);
			/* Response headers */
			headers.putSingle(HttpHeaders.ACCEPT, MediaType.APPLICATION_XML);
			headers.putSingle(HttpHeaders.ACCEPT_CHARSET, HBProperties.UTF8);
		} catch (Exception exception) {
			/* try closing the client */
			if (hbRsClient != null) {
				hbRsClient.close();
			}
			throw exception;
		}
	}
	
	private static <T> Object post(T rqObj, WebTarget target, Class<?> clazz) throws Exception {
		Invocation.Builder builder = target.request()
		.accept(MediaType.APPLICATION_XML)
		.acceptLanguage(Locale.ENGLISH)
		.headers(getHeaders());
		
		Entity<T> entity = Entity.entity(rqObj, MediaType.APPLICATION_XML);
		Invocation invoker = builder.buildPost(entity);

		Response response = invoker.invoke();
		
		return response.readEntity(clazz);
	}
	
	public static <T> AvailabilityRS postSearch(T bean) throws Exception {
		WebTarget target = hbRsClient.target(HBProperties.HB_SEARCH_HOTELS_END_POINT);
		return (AvailabilityRS) post(bean, target, AvailabilityRS.class);
	}
	
	public static <T> BookingRS postConfirmBooking(T bean) throws Exception {
		WebTarget target = hbRsClient.target(HBProperties.HB_CONFIRM_BOOKING_END_POINT);
		return (BookingRS) post(bean, target, BookingRS.class);
	}
	
	/**
	 * Post the Bonton cancellation request bean to HotelBeds and 
	 * return HotelBeds cancellation response.
	 * @param bean Bonton cancellation bean
	 * @return HotelBeds cancellation response bean
	 * @throws Exception
	 */
	public static <T> BookingCancellationRS postCancelBooking(T bean) throws Exception {
		logger.info("cancel request posting to HotelBeds started ---->");
		
		WebTarget target = hbRsClient.target(HBProperties.HB_CANCEL_BOOKING_END_POINT)
				.resolveTemplate(HBProperties.REF_ID, ((BTNCancelRQ) bean).getCancelDetails().getReferenceId())
				.resolveTemplate(HBProperties.CNCL_FLG, ((BTNCancelRQ) bean).getCancelDetails().getCancelFlag());
		
		/* done differently from other methods */
		Invocation.Builder builder = target.request()
				.accept(MediaType.APPLICATION_XML)
				.acceptLanguage(Locale.ENGLISH)
				.headers(getHeaders());
		
		Invocation invoker = builder.buildDelete();
		Response response = invoker.invoke();
		
		logger.info("cancel request posting done ---->");
		return response.readEntity(BookingCancellationRS.class);
	}
	
	public static <T> CheckRateRS postRepricing(T bean) throws Exception {
		logger.info("reprice request posting to HotelBeds started ---->");
		WebTarget target = hbRsClient.target(HBProperties.HB_REPRICE_POST_END_POINT);
		
		logger.info("reprice request posting done ---->");
		return (CheckRateRS) post(bean, target, CheckRateRS.class);
	}
	
	private static MultivaluedMap<String, Object> getHeaders() {
		headers.putSingle(HBProperties.SIGNATURE_HEADER_NAME, 
				DigestUtils.sha256Hex(HBProperties.API_KEY + HBProperties.SHARED_SECRET + System.currentTimeMillis() / 1000));
		return headers;
	}
}
