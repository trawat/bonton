package com.bonton.utility.processor;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

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
import com.bonton.utility.hotelbeds.AvailabilityRS;
import com.bonton.utility.hotelbeds.BookingCancellationRS;
import com.bonton.utility.hotelbeds.BookingRS;
import com.bonton.utility.hotelbeds.CheckRateRS;

@SuppressWarnings("unchecked")
public class XmlProcessor {
	private static final Logger log = LoggerFactory.getLogger(XmlProcessor.class);
	
	private XmlProcessor() {}
	
	public static BTNSearchRequest getBTNSearchRQBean(InputStream is) throws Exception {
		return unmarshall(is, BTNSearchRequest.class);
	}
	
	public static BTNConfirmRequest getBTNConfirmRQBean(InputStream is) throws Exception {
		return unmarshall(is, BTNConfirmRequest.class);
	}
	
	public static BTNCancelRQ getBTNCancelRQBean(InputStream is) throws Exception {
		return unmarshall(is, BTNCancelRQ.class);
	}

	public static BTNRepriceRequest getBTNRepriceRQBean(InputStream is) throws Exception {
		return unmarshall(is, BTNRepriceRequest.class);
	}
	
	public static <T> String getBeanInXml(T beanType) throws Exception {
		return marshall(beanType);
	}
	
	public static AvailabilityRS getHBSearchRSBean(String hbSearchResXml) throws Exception {
		return unmarshall(new ByteArrayInputStream(hbSearchResXml.getBytes("UTF-8")), AvailabilityRS.class);
	}
	
	public static BookingRS getHBConfirmRSBean(String hbConfirmResXml) throws Exception {
		return unmarshall(new ByteArrayInputStream(hbConfirmResXml.getBytes("UTF-8")), BookingRS.class);
	}
	
	public static BookingCancellationRS getHBCancelRSBean(String hbCancelResXml) throws Exception {
		return unmarshall(new ByteArrayInputStream(hbCancelResXml.getBytes("UTF-8")), BookingCancellationRS.class);
	}
	
	public static CheckRateRS getHBRepriceRSBean(String hbRepriceResXml) throws Exception {
		return unmarshall(new ByteArrayInputStream(hbRepriceResXml.getBytes("UTF-8")), CheckRateRS.class);
	}
	
	private static <T> T unmarshall(InputStream is, Class<T> beanClass) throws Exception {
		JAXBContext jaxbCtx = null;
		Unmarshaller unmarshaller = null;
		
		try {
			jaxbCtx = JAXBContext.newInstance(beanClass.getPackage().getName());
			unmarshaller = jaxbCtx.createUnmarshaller();
			
			T element = (T) unmarshaller.unmarshal(is);
			return element;
		} catch (JAXBException exception) {
			log.debug("Exception while initializing JAXBContext {}", exception);
			throw exception;
		}
	}
	
	private static <T> String marshall(T beanType) throws Exception {
		JAXBContext jaxbCtx = null;
		Marshaller marshaller = null;
		
		try {
			Class<T> beanClass = (Class<T>) beanType.getClass();

			jaxbCtx = JAXBContext.newInstance(beanClass.getPackage().getName());
			marshaller = jaxbCtx.createMarshaller();
			
			StringWriter tempBuffer = new StringWriter();
			marshaller.marshal(beanType, tempBuffer);
			
			return tempBuffer.toString();
		} catch (Exception exception) {
			//log.debug("Exception while initializing JAXBContext {}", exception.getCause());
			throw exception;
		}
	}
	
	public static BTNSearchResponse getBTNSearchErrorRS(Exception exception) {
		return getUnmarshallErrorResponse(BTNSearchResponse.class, exception);
	}
	
	public static BTNConfirmResponse getBTNConfirmErrorRS(Exception exception) {
		return getUnmarshallErrorResponse(BTNConfirmResponse.class, exception);
	}
	
	public static BTNCancelRS getBTNCancelErrorRS(Exception exception) {
		return getUnmarshallErrorResponse(BTNCancelRS.class, exception);
	}
	
	public static BTNRepriceResponse getBTNRepriceErrorRS(Exception exception) {
		return getUnmarshallErrorResponse(BTNRepriceResponse.class, exception);
	}
	
	/** Displaying useful information in case of bad request.
	 * Assuming bad request with unmarshalling error will only appear 
	 * during testing/ integration phase. 
	 * Returning related useful information should help in recovering
	 * from the error
	 **/
	private static <T> T getUnmarshallErrorResponse(Class<T> reqType, Exception exception) {
		if (reqType.equals(BTNSearchResponse.class)) {
			BTNSearchResponse.BTNError errElmnt = new BTNSearchResponse.BTNError();
			errElmnt.setCode("Unmarshalling Error");
			errElmnt.setMessage(exception.getCause().toString());

			BTNSearchResponse btnSearchRS = new BTNSearchResponse();
			btnSearchRS.setBTNError(errElmnt);
			
			return (T) btnSearchRS;
		} else if (reqType.equals(BTNConfirmResponse.class)) {
			BTNConfirmResponse.BTNError errElmnt = new BTNConfirmResponse.BTNError();
			errElmnt.setCode("Unmarshalling Error");
			errElmnt.setMessage(exception.getCause().toString());

			BTNConfirmResponse btnConfirmRS = new BTNConfirmResponse();
			btnConfirmRS.setBTNError(errElmnt);
			
			return (T) btnConfirmRS;
		} else if (reqType.equals(BTNRepriceResponse.class)) {
			BTNRepriceResponse.BTNError errElmnt = new BTNRepriceResponse.BTNError();
			errElmnt.setCode("Unmarshalling Error");
			errElmnt.setMessage(exception.getCause().toString());

			BTNRepriceResponse btnRepriceRS = new BTNRepriceResponse();
			btnRepriceRS.setBTNError(errElmnt);
			
			return (T) btnRepriceRS;

		} else if (reqType.equals(BTNCancelRS.class)) {
			BTNCancelRS.BTNError errElmnt = new BTNCancelRS.BTNError();
			errElmnt.setCode("Unmarshalling Error");
			errElmnt.setMessage(exception.getCause().toString());

			BTNCancelRS btnCancelRS = new BTNCancelRS();
			btnCancelRS.setBTNError(errElmnt);
			
			return (T) btnCancelRS;
		}
		/** Should never reach this point */
		return null;
	}
	
	@SuppressWarnings("unused")
	private static BTNSearchRequest get(InputStream is) {
		JAXBContext jaxbCtx = null;
		Unmarshaller unmarshaller = null;
		
		try {
			jaxbCtx = JAXBContext.newInstance(BTNSearchRequest.class);
			unmarshaller = jaxbCtx.createUnmarshaller();
			//JAXBElement<T> element = new JAXBElement<T>();
			//is = new FileInputStream(new File("SearchRequest.xml"));
			if (is == null) {
				System.out.println("null stream");
			}
			BTNSearchRequest element = (BTNSearchRequest) unmarshaller.unmarshal(is);
			
			Marshaller marshaller = jaxbCtx.createMarshaller();
			marshaller.marshal(element, System.out);
			return element;
		} catch (Exception exception) {
			exception.printStackTrace(System.out);
			//log.debug("Exception while initializing JAXBContext {}", exception.getCause());
		}
		return null;
	}
	
	@SuppressWarnings("unused")
	private static <T> T getBean(InputStream is, Class<T> bean) {
		JAXBContext jaxbCtx = null;
		Unmarshaller unmarshaller = null;
		
		try {
			jaxbCtx = JAXBContext.newInstance(bean.getClass());
			unmarshaller = jaxbCtx.createUnmarshaller();
			//JAXBElement<T> element = new JAXBElement<T>();
			is = new FileInputStream(new File("3rs.xml"));
			if (is != null) {
				System.out.println("not null");
			}
			JAXBElement<T> element = (JAXBElement<T>) unmarshaller.unmarshal(is);
			
			return element.getValue();
		} catch (Exception exception) {
			//log.debug("Exception while initializing JAXBContext {}", exception.getCause());
		}
		return null;
	}
	
	/* Use this for local testing. Change name test to main */
	public static void test(String...a) throws Exception {
//		Scanner is = new Scanner(new FileInputStream(new File("3rs.xml")), "UTF-8");
//		StringBuilder sb = new StringBuilder();
//		while (is.hasNextLine()) {
//			sb.append(is.nextLine());
//		}
//		AvailabilityRS ars = getHBSearchRSBean(sb.toString());
//		BTNSearchResponse res = searchBeanResponseMapper(ars);
//		
//		String s = getBeanInXml(res);
//		FileOutputStream fos = new FileOutputStream(new File("btnrs.xml"));
//		fos.write(s.getBytes());
//		fos.close();
	}
	
}
