package com.bonton.utility.processor;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

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
import com.bonton.utility.hotelbeds.AvailabilityRS;
import com.bonton.utility.hotelbeds.BookingCancellationRS;
import com.bonton.utility.hotelbeds.BookingRS;
import com.bonton.utility.hotelbeds.CheckRateRS;

/**
 * Contains marshalling and unmarshalling logic for all the JAXB generated artifacts
 * marshalled or unmarshalled from any dependent project.
 * @author Tirath
 */
public final class XmlProcessor {
	private static final Logger logger = LoggerFactory.getLogger(XmlProcessor.class);
	
	private static final String BTN_SCHEMA_FILE_NM = "Bonton.xsd";
	private static final String ERROR_CD = "Unmarshalling Error";
	private static SchemaFactory btnSsf = null;
	private static Schema btnSchema = null;
	
	/** To avoid JAXB context creation for every mashaling or unmarshalling request */
	private static final Map<String, JAXBContext> ctxMap = new HashMap<>();
	
	static {
		/** Setting schema for xml validation besides default well formedness check */
		btnSsf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		try {
			btnSchema = btnSsf.newSchema(Thread.currentThread().getContextClassLoader().getResource(BTN_SCHEMA_FILE_NM));
		} catch (SAXException exception) {
			logger.error("{} occured while initializing BTN schema", exception);
		}
	}
	
	private XmlProcessor() {}
	
	/**
	 * Returns Bonton search request object using the passed input stream.
	 * @param is Servlet input stream
	 * @return Bonton search request object
	 * @throws Exception In case, unmarshalling input stream to request object fails.
	 * @author Tirath
	 */
	public static BTNSearchRequest getBTNSearchRQBean(InputStream is) throws Exception {
		return unmarshall(is, BTNSearchRequest.class);
	}
	
	/**
	 * Returns Bonton confirm request object using the passed input stream.
	 * @param is Servlet input stream
	 * @return Bonton confirm request object
	 * @throws Exception In case, unmarshalling input stream to request object fails.
	 * @author Tirath
	 */
	public static BTNConfirmRequest getBTNConfirmRQBean(InputStream is) throws Exception {
		return unmarshall(is, BTNConfirmRequest.class);
	}
	
	/**
	 * Returns Bonton cancel request object using the passed input stream.
	 * @param is Servlet input stream
	 * @return Bonton cancel request object
	 * @throws Exception In case, unmarshalling input stream to request object fails.
	 * @author Tirath
	 */
	public static BTNCancelRQ getBTNCancelRQBean(InputStream is) throws Exception {
		return unmarshall(is, BTNCancelRQ.class);
	}

	/**
	 * Returns Bonton reprice request object using the passed input stream.
	 * @param is Servlet input stream
	 * @return Bonton reprice request object
	 * @throws Exception In case, unmarshalling input stream to request object fails.
	 * @author Tirath
	 */
	public static BTNRepriceRequest getBTNRepriceRQBean(InputStream is) throws Exception {
		return unmarshall(is, BTNRepriceRequest.class);
	}
	
	/**
	 * Returns Bonton final booking request object using the passed input stream.
	 * @param is Servlet input stream
	 * @return Bonton final booking request object used by Desia API 
	 * @throws Exception In case, unmarshalling input stream to request object fails.
	 */
	public static BTNFinalBookingRQ getBTNFinalBookingRQBean(InputStream is) throws Exception {
		return unmarshall(is, BTNFinalBookingRQ.class);
	}
	
	/**
	 * Used to return string representation of any bean artifact passed to this method.
	 * @param beanType Type of the bean to be converted to string
	 * @return Marshalled representation of passed beanType
	 * @throws Exception In case, any exception occurs during marshalling process.
	 * @author Tirath
	 */
	public static <T> String getBeanInXml(T beanType) throws Exception {
		return marshall(beanType);
	}
	
	/**
	 * Used to get hotel beds availability response object from XML string passed to it.
	 * @param hbSearchResXml XML string response returned by HotelBeds API
	 * @return HotelBeds hotel availability response object prepared using passed XML string.
	 * @throws Exception In case, any exception occurs during unmarshalling process.
	 * @author Tirath
	 */
	public static AvailabilityRS getHBSearchRSBean(String hbSearchResXml) throws Exception {
		return unmarshall(new ByteArrayInputStream(hbSearchResXml.getBytes("UTF-8")), AvailabilityRS.class);
	}
	
	/**
	 * Used to get hotel beds confirm response object from XML string passed to it.
	 * @param hbConfirmResXml XML string response returned by HotelBeds API
	 * @return HotelBeds hotel confirm response object prepared using passed XML string.
	 * @throws Exception In case, any exception occurs during unmarshalling process.
	 * @author Tirath
	 */
	public static BookingRS getHBConfirmRSBean(String hbConfirmResXml) throws Exception {
		return unmarshall(new ByteArrayInputStream(hbConfirmResXml.getBytes("UTF-8")), BookingRS.class);
	}
	
	/**
	 * Used to get hotel beds cancel response object from XML string passed to it.
	 * @param hbCancelResXml XML string response returned by HotelBeds API
	 * @return HotelBeds hotel cancel response object prepared using passed XML string.
	 * @throws Exception In case, any exception occurs during unmarshalling process.
	 * @author Tirath
	 */
	public static BookingCancellationRS getHBCancelRSBean(String hbCancelResXml) throws Exception {
		return unmarshall(new ByteArrayInputStream(hbCancelResXml.getBytes("UTF-8")), BookingCancellationRS.class);
	}
	
	/**
	 * Used to get hotel beds reprice response object from XML string passed to it.
	 * @param hbRepriceResXml XML string response returned by HotelBeds API
	 * @return HotelBeds hotel reprice response object prepared using passed XML string.
	 * @throws Exception In case, any exception occurs during unmarshalling process.
	 * @author Tirath
	 */
	public static CheckRateRS getHBRepriceRSBean(String hbRepriceResXml) throws Exception {
		return unmarshall(new ByteArrayInputStream(hbRepriceResXml.getBytes("UTF-8")), CheckRateRS.class);
	}
	
	private static <T> T unmarshall(InputStream is, Class<T> beanClass) throws Exception {
		String packageName = beanClass.getPackage().getName();;
		JAXBContext jaxbCtx = ctxMap.get(packageName);
		Unmarshaller unmarshaller = null;
		
		try {
			if (null == jaxbCtx) {
				jaxbCtx = JAXBContext.newInstance(beanClass.getPackage().getName());
				ctxMap.put(packageName, jaxbCtx);
			}
			unmarshaller = jaxbCtx.createUnmarshaller();
			
			/** Setting schema for validation */
			unmarshaller.setSchema(btnSchema);
			
			T element = (T) unmarshaller.unmarshal(is);
			return element;
		} catch (JAXBException exception) {
			logger.debug("Exception while initializing JAXBContext {}", exception);
			throw exception;
		}
	}
	
	private static <T> String marshall(T beanType) throws Exception {
		Class<T> beanClass = (Class<T>) beanType.getClass();
		String packageName = beanClass.getPackage().getName();;
		JAXBContext jaxbCtx = ctxMap.get(packageName);
		Marshaller marshaller = null;
		
		try {
			if (null == jaxbCtx) {
				jaxbCtx = JAXBContext.newInstance(beanClass.getPackage().getName());
				ctxMap.put(packageName, jaxbCtx);
			}
			marshaller = jaxbCtx.createMarshaller();
			
			StringWriter tempBuffer = new StringWriter();
			marshaller.marshal(beanType, tempBuffer);
			
			return tempBuffer.toString();
		} catch (Exception exception) {
			logger.error("{} while initializing JAXBContext", exception);
			throw exception;
		}
	}
	
	/**
	 * Helper method to return Bonton error response in case the submitted
	 * request cannot be unmarshalled properly.
	 * @param exception Unmarshalling exception
	 * @return Bonton search response which contains error code and message.
	 * @author Tirath
	 */
	public static BTNSearchResponse getBTNSearchErrorRS(Exception exception) {
		return getUnmarshallErrorResponse(BTNSearchResponse.class, exception);
	}
	
	/**
	 * Helper method to return Bonton error response in case the submitted
	 * request cannot be unmarshalled properly.
	 * @param exception Unmarshalling exception
	 * @return Bonton confirm response which contains error code and message.
	 * @author Tirath
	 */
	public static BTNConfirmResponse getBTNConfirmErrorRS(Exception exception) {
		return getUnmarshallErrorResponse(BTNConfirmResponse.class, exception);
	}
	
	/**
	 * Helper method to return Bonton error response in case the submitted
	 * request cannot be unmarshalled properly.
	 * @param exception Unmarshalling exception
	 * @return Bonton cancel response which contains error code and message.
	 * @author Tirath
	 */
	public static BTNCancelRS getBTNCancelErrorRS(Exception exception) {
		return getUnmarshallErrorResponse(BTNCancelRS.class, exception);
	}
	
	/**
	 * Helper method to return Bonton error response in case the submitted
	 * request cannot be unmarshalled properly.
	 * @param exception Unmarshalling exception
	 * @return Bonton reprice response which contains error code and message.
	 * @author Tirath
	 */
	public static BTNRepriceResponse getBTNRepriceErrorRS(Exception exception) {
		return getUnmarshallErrorResponse(BTNRepriceResponse.class, exception);
	}
	
	/**
	 * Helper method to return Bonton error response in case the submitted
	 * request cannot be unmarshalled properly.
	 * @param exception Unmarshalling exception
	 * @return Bonton final booking response which contains error code and message.
	 * @author Tirath
	 */
	public static BTNFinalBookingRS getBTNFinalBookingErrorRS(Exception exception) {
		return getUnmarshallErrorResponse(BTNFinalBookingRS.class, exception);
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
			errElmnt.setCode(ERROR_CD);
			errElmnt.setMessage(exception.getCause().toString());

			BTNSearchResponse btnSearchRS = new BTNSearchResponse();
			btnSearchRS.setBTNError(errElmnt);
			
			return (T) btnSearchRS;
		} else if (reqType.equals(BTNConfirmResponse.class)) {
			BTNConfirmResponse.BTNError errElmnt = new BTNConfirmResponse.BTNError();
			errElmnt.setCode(ERROR_CD);
			errElmnt.setMessage(exception.getCause().toString());

			BTNConfirmResponse btnConfirmRS = new BTNConfirmResponse();
			btnConfirmRS.setBTNError(errElmnt);
			
			return (T) btnConfirmRS;
		} else if (reqType.equals(BTNRepriceResponse.class)) {
			BTNRepriceResponse.BTNError errElmnt = new BTNRepriceResponse.BTNError();
			errElmnt.setCode(ERROR_CD);
			errElmnt.setMessage(exception.getCause().toString());

			BTNRepriceResponse btnRepriceRS = new BTNRepriceResponse();
			btnRepriceRS.setBTNError(errElmnt);
			
			return (T) btnRepriceRS;

		} else if (reqType.equals(BTNCancelRS.class)) {
			BTNCancelRS.BTNError errElmnt = new BTNCancelRS.BTNError();
			errElmnt.setCode(ERROR_CD);
			errElmnt.setMessage(exception.getCause().toString());

			BTNCancelRS btnCancelRS = new BTNCancelRS();
			btnCancelRS.setBTNError(errElmnt);
			
			return (T) btnCancelRS;
		} else if (reqType.equals(BTNFinalBookingRS.class)) {
			BTNFinalBookingRS.BTNError errElmnt = new BTNFinalBookingRS.BTNError();
			errElmnt.setCode(ERROR_CD);
			errElmnt.setMessage(exception.getCause().toString());

			BTNFinalBookingRS btnFinalBookingRS = new BTNFinalBookingRS();
			btnFinalBookingRS.setBTNError(errElmnt);
			
			return (T) btnFinalBookingRS;
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
