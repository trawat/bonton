package com.hotelbeds.util;

import java.util.List;

import com.google.gson.Gson;
import com.hotelbeds.beans.repricing.CancellationPolicies;
import com.hotelbeds.beans.repricing.HBRepriceJsonDataContainer;
import com.hotelbeds.beans.repricing.Rooms;
import com.hotelbeds.beans.repricing.json.Rates;

public class RepricingUtil {
	
	public static String getRepricingXml(String responseJson) {
		String dataString = null;
		Gson g = new Gson();
		HBRepriceJsonDataContainer hBRepriceJsonDataContainer = g.fromJson(responseJson, HBRepriceJsonDataContainer.class);
	    
	    if(hBRepriceJsonDataContainer != null) {
	    	if(hBRepriceJsonDataContainer.getAuditData() != null && hBRepriceJsonDataContainer.getHotel() != null) {
	    		dataString  = getRepricingResponseXml(hBRepriceJsonDataContainer);
	    		FileProcessor.writeStringToFile(dataString, "D:/repricingxml.txt");
	    	}
	    }
		return dataString;
	}
	
	private static String getRepricingResponseXml(HBRepriceJsonDataContainer ctn) {
		StringBuilder sb = new StringBuilder("");
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		sb.append("<RepriceResponse>");
		sb.append("<Hotel checkIn=\""+ctn.getHotel().getCheckIn()+"\" checkOut=\""+ctn.getHotel().getCheckOut()+"\" "
				+ "code=\""+ctn.getHotel().getCode()+"\" name=\""+ctn.getHotel().getName()+"\" "
				+ "categoryCode=\""+ctn.getHotel().getCategoryCode()+"\" "
				+ "categoryName=\""+ctn.getHotel().getCategoryName()+"\" destinationCode=\""+ctn.getHotel().getDestinationCode()+"\" "
				+ "destinationName=\""+ctn.getHotel().getDestinationName()+"\">");
		
		/* handle list of rooms */
		List<Rooms> roomLst = ctn.getHotel().getRooms();
		sb.append("<Rooms>");
		for (Rooms rooms : roomLst) {
			sb.append("<Room code=\""+rooms.getCode()+"\" name=\""+rooms.getName()+"\">");
			
			List<Rates> ratesLst = rooms.getRates();
			sb.append("<Rates>");
			for (Rates rates : ratesLst) {
				sb.append("<Rate uniqueKey=\""+rates.getRateKey()+"\">");
				sb.append("<NetRate>"+rates.getNet()+"</NetRate>");
				sb.append("<Packaging>"+false+"</Packaging>");
				sb.append("<RateType>"+rates.getRateType()+"</RateType>");
				sb.append("<Category>"+rates.getRateClass()+"</Category>");
				sb.append("<RoomCount>"+rates.getRooms()+"</RoomCount>");
				sb.append("<AdultCount>"+rates.getAdults()+"</AdultCount>");
				sb.append("<ChildCount>"+rates.getChildren()+"</ChildCount>");
				//sb.append("<ChildrenAges>"+rates.getChildren()+"</ChildrenAges>");
				sb.append("<CancellationPolicies>");
				List<CancellationPolicies> cancellationPoliciesLst = rates.getCancellationPolicies();
				for (CancellationPolicies cancPlcy : cancellationPoliciesLst) {
					sb.append("<CancellationPolicy amount=\""+cancPlcy.getAmount()+"\" from=\""+cancPlcy.getFrom()+"\"/>");
				}
				sb.append("</CancellationPolicies>");
				sb.append("</Rate>");
			}
			sb.append("</Rates>");
			sb.append("</Room>");
		}
		sb.append("</Rooms>");
//		sb.append("<CreditCards>");
//		sb.append("<CreditCard code=\"\" name=\"\" paymentType=\"\"/>");
//		sb.append("</CreditCards>");
//		sb.append("<Supplier></Supplier>");
		sb.append("</Hotel>");
		sb.append("</RepriceResponse>");
		
	
		return sb.toString();
	}

}