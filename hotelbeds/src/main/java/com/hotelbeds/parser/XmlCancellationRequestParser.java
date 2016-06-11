package com.hotelbeds.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.hotelbeds.beans.CancellationBean;

public class XmlCancellationRequestParser extends DefaultHandler  {
	
	boolean isActive = false;
	private StringBuffer buffer = new StringBuffer();

	CancellationBean bontonXmlCancellationRequest = new CancellationBean();

	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {

		buffer.setLength(0);

		if (qName.equalsIgnoreCase("RequestorID")) {

			bontonXmlCancellationRequest.setClient(atts.getValue("Client"));
			bontonXmlCancellationRequest.seteMailAddress(atts.getValue("EMailAddress"));
			bontonXmlCancellationRequest.setPassword(atts.getValue("Password"));

		}
		

	/*	else if (qName.equalsIgnoreCase("RequestorPreferences")) {

			bontonXmlCancellationRequest.setRequestMode(atts.getValue("RequestMode"));			
			
		}*/
		
		
		else if (qName.equalsIgnoreCase("BookingReference")) {

			bontonXmlCancellationRequest.setReferenceSource(atts.getValue("ReferenceSource"));
			bontonXmlCancellationRequest.setText(atts.getValue("text"));
			
		}	

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		 if (qName.equalsIgnoreCase("RequestMode")) {

			bontonXmlCancellationRequest.setRequestMode(buffer.toString());			
			
		}	

	}

	@Override
	public void characters(char[] ch, int start, int length) {
		buffer.append(ch, start, length);
	}

	public CancellationBean getObject() {
		return bontonXmlCancellationRequest;
	}

}
