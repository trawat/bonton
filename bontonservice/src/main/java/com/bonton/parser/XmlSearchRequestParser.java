package com.bonton.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.bonton.beans.hb.SearchBean;

public class XmlSearchRequestParser extends DefaultHandler {

	boolean isActive = false;
	private StringBuffer buffer = new StringBuffer();

	SearchBean bontonXmlRequest = new SearchBean();

	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {

		buffer.setLength(0);

		if (qName.equalsIgnoreCase("RequestorID")) {

			bontonXmlRequest.setClient(atts.getValue("Client"));
			bontonXmlRequest.seteMailAddress(atts.getValue("EMailAddress"));
			bontonXmlRequest.setPassword(atts.getValue("Password"));

		}
		

		else if (qName.equalsIgnoreCase("ItemDestination")) {

			bontonXmlRequest.setDestinationCode(atts.getValue("DestinationCode"));
			bontonXmlRequest.setDestinationType(atts.getValue("DestinationType"));
			bontonXmlRequest.setDestinationZone(atts.getValue("DestinationZone"));
			
		}
		
		
		else if (qName.equalsIgnoreCase("Room")) {

			bontonXmlRequest.setCode(atts.getValue("Code"));
			bontonXmlRequest.setNumberOfCots(atts.getValue("NumberOfCots"));
			bontonXmlRequest.setNumberOfRooms(atts.getValue("NumberOfRooms"));

		}	

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (qName.equalsIgnoreCase("CheckInDate")) {
			
			bontonXmlRequest.setCheckInDate(buffer.toString());

		}
		
		else if(qName.equalsIgnoreCase("Duration")){
			
			bontonXmlRequest.setDuration(buffer.toString());
		}				

	}

	@Override
	public void characters(char[] ch, int start, int length) {
		buffer.append(ch, start, length);
	}

	public SearchBean getObject() {
		return bontonXmlRequest;
	}

}
