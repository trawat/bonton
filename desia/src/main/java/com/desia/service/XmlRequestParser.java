package com.desia.service;



import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class XmlRequestParser extends DefaultHandler {

 boolean isActive = false;
 private StringBuffer buffer = new StringBuffer();

 GetHotelXmlRequest bontonXmlRequest = new GetHotelXmlRequest();

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
   
   
  }
  
  
  else if (qName.equalsIgnoreCase("Room")) {

   bontonXmlRequest.setRoomcode(atts.getValue("Code"));
   bontonXmlRequest.setNumberOfCots(atts.getValue("NumberOfCots"));
   bontonXmlRequest.setNumberOfRooms(atts.getValue("NumberOfRooms"));

  } 

 }

 @Override
 public void endElement(String uri, String localName, String qName) throws SAXException {

  if (qName.equalsIgnoreCase("CheckInDate")) {
   
   bontonXmlRequest.setCheckInDate(buffer.toString());

  }
  
  else if(qName.equalsIgnoreCase("CheckOutDate")){
   
    bontonXmlRequest.setCheckOutDate(buffer.toString());
   }
  
  else if(qName.equalsIgnoreCase("Duration")){
   
   bontonXmlRequest.setDuration(buffer.toString());
  } 
  
  else if(qName.equalsIgnoreCase("MinStarRating")){
   
    bontonXmlRequest.setMinStarRating(buffer.toString());
   }
  
  else if(qName.equalsIgnoreCase("MaxStarRating")){
 
   bontonXmlRequest.setMaxStarRating(buffer.toString());
  }

 }

 @Override
 public void characters(char[] ch, int start, int length) {
  buffer.append(ch, start, length);
 }

 public GetHotelXmlRequest getObject() {
  return bontonXmlRequest;
 }

}