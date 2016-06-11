package com.hotelbeds.service;

import java.util.List;

import com.hotelbeds.beans.AuditData;
import com.hotelbeds.beans.CancellationPolicies;
import com.hotelbeds.beans.HBJsonDataContainer;
import com.hotelbeds.beans.Offers;
import com.hotelbeds.beans.Rates;
import com.hotelbeds.beans.Rooms;
import com.hotelbeds.beans.ShiftRates;

public class HBDataProcessor {
	
	public String getHBDataReponseInAggregationFormat(HBJsonDataContainer hbDataContObj) {
		StringBuilder resultString = new StringBuilder("");
		String supplier = "HotelBeds";
		if(hbDataContObj != null) {

			com.hotelbeds.jsonbeans.Hotels hotelsObj = hbDataContObj.getHotels();
			if(hotelsObj != null) {
				List<com.hotelbeds.beans.Hotels> hotels = hotelsObj.getHotels();
				if(hotels != null && !hotels.isEmpty()) {
					List<CancellationPolicies> cp = null;
					List<Offers> offers = null;
					List<Rates> rates = null;
					List<Rooms> rooms = null;
					List<ShiftRates> shiftRates = null;
					for (com.hotelbeds.beans.Hotels hotelsDataObj : hotels){
						resultString.append("h#");
						resultString.append("\t");
						resultString.append(supplier);
						resultString.append("\t");
						resultString.append(hotelsDataObj.getDestinationCode());
						resultString.append("\t");
						resultString.append(hotelsDataObj.getDestinationName());
						resultString.append("\t");
						
						//Supplier Hotel Code Here
						if(hotelsDataObj.getCode() != 0) {
							resultString.append(hotelsDataObj.getCode());
						}else {
							resultString.append("");
						}
						
						resultString.append("\t");
						resultString.append(hotelsDataObj.getName().replaceAll("'", "").replaceAll(".", ""));
						resultString.append("\t");
						resultString.append(hotelsDataObj.getCategoryName());
						resultString.append("\t");
						if(hotelsDataObj.getZoneName() != null) {
							resultString.append(hotelsDataObj.getZoneName());
							
						}else {
							resultString.append("");
						}
						resultString.append("\t");
						String mainImage = "";
						resultString.append(mainImage);
						resultString.append("\t");
						String description = "";
						resultString.append(description);
						resultString.append("\t");
						String remarks = "";
						// yet to be decide
						resultString.append(remarks);
						resultString.append("\t");
						resultString.append("");
						resultString.append("\t");
						if(hotelsDataObj.getCode() != 0) {
							resultString.append(hotelsDataObj.getCode());
						}else {
							resultString.append("");
						}
						resultString.append("\t");
						rooms = hotelsDataObj.getRooms();
						if(rooms != null && !rooms.isEmpty()) {
							
							for(Rooms roomsObj : rooms) {
								
								if(roomsObj != null) {
									
									List<Rates> ratesList = roomsObj.getRates();
									if(ratesList != null && !ratesList.isEmpty()) {
										for(Rates rateObj : ratesList) {
											
											if(rateObj != null) {
												List<ShiftRates> shiftRateList = rateObj.getShiftRates();
												if(shiftRateList != null && !shiftRateList.isEmpty()) {
													resultString.append("#");
													resultString.append(roomsObj.getCode());
													
													//??????
													resultString.append(": ");
													resultString.append(rooms.size());
													
													
													resultString.append(": ");
													resultString.append(roomsObj.getName());
													resultString.append(": ");	
													resultString.append(rateObj.getRateClass());
													resultString.append(": ");
													String availaility = rateObj.getRateType();
													if(availaility != null && "BOOKABLE".equals(availaility)) {
														resultString.append("AVAILABLE");
													}else if(availaility != null && !"".equals(availaility)) {
														resultString.append(availaility);
													}else {
														resultString.append("On Request");
													}
													
													resultString.append(": ");
													
													//Meal
													
													resultString.append(rateObj.getBoardName());
													resultString.append(": ");
													
													boolean isOffer = false;
													offers = rateObj.getOffers();
													if(offers != null && !offers.isEmpty()) {
														isOffer = true;
													}
													resultString.append(isOffer);
													resultString.append(": ");
													String commissionPercentage = "0";
													String grossWithoutDiscount = "0";
													String iIncludedOfferDiscount = "0";
													String offerCode = "";
													String offerFinalPrice = "";
													int supplierOfferAmount = 0;
													if(isOffer) {
														Offers offer = offers.get(0);
														if(offer != null) {
															offerCode = offer.getCode();
															iIncludedOfferDiscount = offer.getAmount();
														}
														 
													}
													
													String calcSerFee = "0";
													String calcDiscount = "0";
													resultString.append(iIncludedOfferDiscount);
													resultString.append(": ");
													resultString.append(commissionPercentage);
													resultString.append(": ");
													resultString.append(offerFinalPrice);
													resultString.append(": ");
													resultString.append(grossWithoutDiscount);
													resultString.append(": ");
													resultString.append(offerCode);
													resultString.append(": ");
													resultString.append(rateObj.getNet());
													resultString.append(": ");
													resultString.append(calcSerFee);
													resultString.append(": ");
													resultString.append(calcDiscount);
													resultString.append(": ");
													resultString.append(rateObj.getNet());
													
													resultString.append(": ");
													resultString.append(hotelsDataObj.getCurrency());
													resultString.append(": ");
													resultString.append(hotelsDataObj.getCode());
													resultString.append(": ");
													resultString.append(rateObj.getRateKey());
													resultString.append(": ");
													resultString.append("false");
													resultString.append(": ");
											//		resultString.append("Cancellation Ramrks");
													resultString.append("");
													resultString.append(": ");
											//		resultString.append("Supplier Code");
													resultString.append("");
													resultString.append(": ");
													// Supplier Hotel Code here
													
													/*if (mhSupplierHotelCode != null)
													{
													    _objTextInnerResponse.Append(mhSupplierHotelCode.MHHotelCode);
													}
													else
													{
													    _objTextInnerResponse.Append(string.Empty);
													}*/
													resultString.append(hotelsDataObj.getCode());
													resultString.append(": ");
													resultString.append(rateObj.getRateClass());
													resultString.append(": ");
											//		resultString.append("Supplier Type");
													resultString.append("");
													resultString.append(": ");
											//		resultString.append("Bed Type Ids");
													resultString.append("");
													resultString.append(": ");
											//		resultString.append("Total");
													resultString.append("");
													resultString.append(": ");
													resultString.append(hotelsDataObj.getCurrency());
													resultString.append(": ");
											//		resultString.append("Smoking Preferences");
													resultString.append("");
													resultString.append(": ");
													resultString.append(supplier);
													resultString.append(": ");
													
												}else {
													resultString.append("#");
													resultString.append(roomsObj.getCode());
													resultString.append(": ");
													resultString.append(rooms.size());
													resultString.append(": ");
													resultString.append(roomsObj.getName());
													resultString.append(": ");	
													resultString.append(rateObj.getRateClass());
													resultString.append(": ");
													String availaility = rateObj.getRateType();
													if(availaility != null && "BOOKABLE".equals(availaility)) {
														resultString.append("AVAILABLE");
													}else if(availaility != null && !"".equals(availaility)) {
														resultString.append(availaility);
													}else {
														resultString.append("On Request");
													}
													
													resultString.append(": ");
													
													//Meal
													
													resultString.append(rateObj.getBoardName());
													resultString.append(": ");
													
													boolean isOffer = false;
													offers = rateObj.getOffers();
													if(offers != null && !offers.isEmpty()) {
														isOffer = true;
													}
													resultString.append(isOffer);
													resultString.append(": ");
													String commissionPercentage = "0";
													String grossWithoutDiscount = "0";
													String iIncludedOfferDiscount = "0";
													String offerCode = "";
													String offerFinalPrice = "";
													int supplierOfferAmount = 0;
													if(isOffer) {
														Offers offer = offers.get(0);
														if(offer != null) {
															offerCode = offer.getCode();
															iIncludedOfferDiscount = offer.getAmount();
														}
														 
													}
													
													String calcSerFee = "0";
													String calcDiscount = "0";
													resultString.append(iIncludedOfferDiscount);
													resultString.append(": ");
													resultString.append(commissionPercentage);
													resultString.append(": ");
													resultString.append(offerFinalPrice);
													resultString.append(": ");
													resultString.append(grossWithoutDiscount);
													resultString.append(": ");
													resultString.append(offerCode);
													resultString.append(": ");
													resultString.append(rateObj.getNet());
													resultString.append(": ");
													resultString.append(calcSerFee);
													resultString.append(": ");
													resultString.append(calcDiscount);
													resultString.append(": ");
													resultString.append(rateObj.getNet());
													
													resultString.append(": ");
													resultString.append(hotelsDataObj.getCurrency());
													resultString.append(": ");
													resultString.append(hotelsDataObj.getCode());
													resultString.append(": ");
													resultString.append(rateObj.getRateKey());
													resultString.append(": ");
													resultString.append("false");
													resultString.append(": ");
											//		resultString.append("Cancellation Ramrks");
													resultString.append("");
													resultString.append(": ");
											//		resultString.append("Supplier Code");
													resultString.append("");
													resultString.append(": ");
													// Supplier Hotel Code here
													
													/*if (mhSupplierHotelCode != null)
													{
													    _objTextInnerResponse.Append(mhSupplierHotelCode.MHHotelCode);
													}
													else
													{
													    _objTextInnerResponse.Append(string.Empty);
													}*/
													resultString.append(hotelsDataObj.getCode());
													resultString.append(": ");
													resultString.append(rateObj.getRateClass());
													resultString.append(": ");
											//		resultString.append("Supplier Type");
													resultString.append("");
													resultString.append(": ");
											//		resultString.append("Bed Type Ids");
													resultString.append("");
													resultString.append(": ");
											//		resultString.append("Total");
													resultString.append("");
													resultString.append(": ");
													resultString.append(hotelsDataObj.getCurrency());
													resultString.append(": ");
											//		resultString.append("Smoking Preferences");
													resultString.append("");
													resultString.append(": ");
													resultString.append(supplier);
													resultString.append(": ");
												}
											}
										}
									}
								}
							}
							resultString.append("\r\n");
						}
					}
				}
			}
		}
		
		return resultString.toString();
	}
	
	
	
}
