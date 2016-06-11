package com.bonton.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.bonton.beans.hb.CancellationBean;
import com.bonton.beans.hb.ConfirmBean;
import com.bonton.beans.hb.SearchBean;
import com.bonton.parser.XmlCancellationRequestParser;
import com.bonton.parser.XmlConfirmRequstParser;
import com.bonton.parser.XmlSearchRequestParser;
import com.bonton.service.impl.BontonService;

public class BeanUtil {
	private static final Logger logger = LoggerFactory.getLogger(BontonService.class);
	
	private static final int BUFFER_SIZE = 128;
	private static SAXParserFactory spf;
	private static SAXParser sp;
	private static XMLReader xmlReader;
	
	private static final XmlSearchRequestParser searchRequestParser = new XmlSearchRequestParser();
	private static final XmlConfirmRequstParser confirmRequstParser = new XmlConfirmRequstParser();
	private static final XmlCancellationRequestParser cancellationRequestParser = new XmlCancellationRequestParser();
	
	static {
		try {
			spf = SAXParserFactory.newInstance();
			sp = spf.newSAXParser();
			xmlReader = sp.getXMLReader();
		} catch (Exception exception) {
			logger.error("Exception occured {}", exception);
		}
	}
	
	private BeanUtil() {}
	
	/**
	 * @param requestObj
	 * @return the String of request body from HttpServletRequest
	 * 
	 */
	public static String getRequestBody(HttpServletRequest requestObj) throws Exception {
		 String body = null;
	     StringBuilder stringBuilder = new StringBuilder("");

	     try (InputStream inputStream = requestObj.getInputStream()) {
	         if (inputStream != null) {
	             try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
	            	 char[] charBuffer = new char[BUFFER_SIZE];
	            	 int bytesRead = -1;
	            	 while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
	            		 stringBuilder.append(charBuffer, 0, bytesRead);
	            	 }
	             }
	         }
	     } catch (IOException exception) {
	         logger.error("Exception occured {}", exception);
	         throw exception;
	     }
	     body = stringBuilder.toString();
	     logger.debug("Request body {}", body);
	     
	     return body;
	 }
	
	/**
	 * @param requestString
	 * @return The XMLRequestBean for search Hotel from the web service xml request
	 */
	public static SearchBean getHotelSearchBean(String requestString) throws  Exception {
		SearchBean searchBean;
		
	  	try {
			xmlReader.setContentHandler(searchRequestParser);
			xmlReader.parse(new InputSource(new StringReader(requestString)));
			searchBean = searchRequestParser.getObject();
						
	  	}catch(Exception exception) {
	  		logger.error("Exception occured {}", exception);
	        throw exception;
	  	}
		
	  	return searchBean;
	}
	
	/**
	 * @param requestString
	 * @return The XMLRequestBean for confirm booking from the web service xml request
	 */
	public static ConfirmBean getHotelConfirmBean(String requestString) throws Exception {
		ConfirmBean confirmBean;
		
	  	try {
	  		xmlReader.setContentHandler(confirmRequstParser);
	  		xmlReader.parse(new InputSource(new StringReader(requestString)));
	  		confirmBean = confirmRequstParser.getObject();
						
	  	}catch(Exception exception) {
	  		logger.error("Exception occured {}", exception);
	        throw exception;
	  	}
		
	  	return confirmBean;
	}	
	
	/**
	 * @param requestString
	 * @return The XMLRequestBean for cancel booking from the web service xml request
	 */
	public static CancellationBean getHotelCancellationBean(String requestString) throws Exception {
		CancellationBean cancellationBean;
		
	  	try {
	  		xmlReader.setContentHandler(cancellationRequestParser);
	  		xmlReader.parse(new InputSource(new StringReader(requestString)));
	  		cancellationBean = cancellationRequestParser.getObject();
						
	  	}catch(Exception exception) {
	  		logger.error("Exception occured {}", exception);
	        throw exception;
	  	}
		
	  	return cancellationBean;
	}
}
