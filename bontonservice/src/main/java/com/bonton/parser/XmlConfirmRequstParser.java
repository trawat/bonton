package com.bonton.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.bonton.beans.hb.ConfirmBean;

public class XmlConfirmRequstParser extends DefaultHandler {
	
	boolean isActive = false;
	private StringBuffer buffer = new StringBuffer();

	ConfirmBean bontonXmlBooking = new ConfirmBean();

	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {

		buffer.setLength(0);

		if (qName.equalsIgnoreCase("RequestorID")) {

			bontonXmlBooking.setClient(atts.getValue("Client"));
			bontonXmlBooking.seteMailAddress(atts.getValue("EMailAddress"));
			bontonXmlBooking.setPassword(atts.getValue("Password"));

		}
		

		else if (qName.equalsIgnoreCase("AddBookingRequest")) {

			bontonXmlBooking.setCurrency(atts.getValue("Currency"));			
			
		}
		
		
		else if (qName.equalsIgnoreCase("PaxName")) {

			bontonXmlBooking.setPaxId(atts.getValue("PaxId"));
			
		}	
		
		else if (qName.equalsIgnoreCase("BookingItem")) {

			bontonXmlBooking.setItemType(atts.getValue("ItemType"));			
			
		}
		
		else if (qName.equalsIgnoreCase("ItemCity")) {

			bontonXmlBooking.setItemCityCode(atts.getValue("Code"));			
			
		}
		
		else if (qName.equalsIgnoreCase("Item")) {

			bontonXmlBooking.setItemCode(atts.getValue("Code"));			
			
		}
		
		else if (qName.equalsIgnoreCase("HotelRoom")) {

			bontonXmlBooking.setHotelRoomCode(atts.getValue("Code"));
			bontonXmlBooking.setExtraBed(atts.getValue("ExtraBed"));
			bontonXmlBooking.setHotelRoomId(atts.getValue("Id"));
			bontonXmlBooking.setNumberOfCots(atts.getValue("NumberOfCots"));

		}
		

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (qName.equalsIgnoreCase("CheckInDate")) {
			
			bontonXmlBooking.setRequestMode(buffer.toString());

		}
		
		else if(qName.equalsIgnoreCase("BookingName")){
			
			bontonXmlBooking.setBookingName(buffer.toString());
		}
		
		else if(qName.equalsIgnoreCase("BookingReference")){
			
			bontonXmlBooking.setBookingReference(buffer.toString());
		}
		
		else if(qName.equalsIgnoreCase("BookingDepartureDate")){
			
			bontonXmlBooking.setBookingDepartureDate(buffer.toString());
		}

		else if(qName.equalsIgnoreCase("ItemReference")){
			
			bontonXmlBooking.setItemReference(buffer.toString());
		}
		
		else if(qName.equalsIgnoreCase("CheckInDate")){
			
			bontonXmlBooking.setCheckInDate(buffer.toString());
		}

		else if(qName.equalsIgnoreCase("CheckOutDate")){
			
			bontonXmlBooking.setCheckOutDate(buffer.toString());
		}
		else if(qName.equalsIgnoreCase("PaxId")){
			
			bontonXmlBooking.setPaxId(buffer.toString());
		}
		else if(qName.equalsIgnoreCase("PaxName")){
			
			bontonXmlBooking.setBookingName(buffer.toString());
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) {
		buffer.append(ch, start, length);
	}

	public ConfirmBean getObject() {
		return bontonXmlBooking;
	}


}
