package com.bonton.utility.processor;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.bonton.utility.artifacts.BTNSearchRequest;
import com.bonton.utility.hotelbeds.AvailabilityRS;
import com.bonton.utility.hotelbeds.BookingRS;

public class XmlProcessor {
	private static final Logger log = LoggerFactory.getLogger(XmlProcessor.class);
	
	private XmlProcessor() {}
	
	public static BTNSearchRequest getBTNSearchRQBean(InputStream is) throws Exception {
		return unmarshall(is, BTNSearchRequest.class);
	}
	
	public static BTNConfirmRequest getBTNConfirmRQBean(InputStream is) throws Exception {
		return unmarshall(is, BTNConfirmRequest.class);
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
	
	private static <T> T unmarshall(InputStream is, Class<T> beanClass) throws Exception {
		JAXBContext jaxbCtx = null;
		Unmarshaller unmarshaller = null;
		
		try {
			jaxbCtx = JAXBContext.newInstance(beanClass.getPackage().getName());
			unmarshaller = jaxbCtx.createUnmarshaller();
			
			//JAXBElement<T> element = (JAXBElement<T>) unmarshaller.unmarshal(is);
			T element = (T) unmarshaller.unmarshal(is);
			return element;
		} catch (Exception exception) {
			log.debug("Exception while initializing JAXBContext {}", exception.getCause());
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
	
	private static <T> T getBean(InputStream is, Class<T> bean) {
		JAXBContext jaxbCtx = null;
		Unmarshaller unmarshaller = null;
		
		try {
			jaxbCtx = JAXBContext.newInstance(bean.getClass());
			unmarshaller = jaxbCtx.createUnmarshaller();
			//JAXBElement<T> element = new JAXBElement<T>();
			is = new FileInputStream(new File("SearchRequest.xml"));
			JAXBElement<T> element = (JAXBElement<T>) unmarshaller.unmarshal(is);
			
			return element.getValue();
		} catch (Exception exception) {
			//log.debug("Exception while initializing JAXBContext {}", exception.getCause());
		}
		return null;
	}
}
