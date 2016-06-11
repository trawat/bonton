package com.hotelbeds.util;

import java.io.StringReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.hotelbeds.beans.CancellationBean;
import com.hotelbeds.beans.ConfirmBean;
import com.hotelbeds.beans.SearchBean;
import com.hotelbeds.parser.XmlCancellationRequestParser;
import com.hotelbeds.parser.XmlConfirmRequstParser;
import com.hotelbeds.parser.XmlSearchRequestParser;

public class BeanUtil {
	private static final Logger logger = LoggerFactory.getLogger(BeanUtil.class);
	
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
