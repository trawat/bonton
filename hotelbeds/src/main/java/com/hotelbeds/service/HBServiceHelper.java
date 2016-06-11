package com.hotelbeds.service;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNConfirmRequest.Rooms.Room;
import com.bonton.utility.artifacts.BTNConfirmRequest.Rooms.Room.Paxes.Pax;
import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.bonton.utility.artifacts.BTNSearchRequest;
import com.bonton.utility.artifacts.BTNSearchResponse;
import com.bonton.utility.hotelbeds.AvailabilityRQ;
import com.bonton.utility.hotelbeds.AvailabilityRS;
import com.bonton.utility.processor.XmlProcessor;
import com.google.gson.Gson;
import com.hotelbeds.beans.CancellationBean;
import com.hotelbeds.beans.HBJsonDataContainer;
import com.hotelbeds.util.BontonConfigImpl;
import com.hotelbeds.util.FileProcessor;
import com.hotelbeds.util.HBProperties;
import com.hotelbeds.util.RepricingUtil;

public class HBServiceHelper {
	
	private static Logger logger = LoggerFactory.getLogger(HBServiceHelper.class); 
	
	public HBServiceHelper() {}
	
	public AvailabilityRQ searchBeanRequestMapper(BTNSearchRequest searchBean) {
		AvailabilityRQ availabilityRQ = new AvailabilityRQ();
		
		return availabilityRQ;
	}
	
	public BTNSearchResponse searchBeanResponseMapper(String hbSearchResXml) throws Exception {
		AvailabilityRS availabilityRS = XmlProcessor.getHBSearchRSBean(hbSearchResXml);
		BTNSearchResponse btnSearchResponse = new BTNSearchResponse();
		
		/** do the appropriate mapping*/
		
		return btnSearchResponse;
	}
	
	public <T> String sendRequest(T rqObj) throws Exception {
		BontonConfigImpl.init();//get rid of this later
		
		String requestXML = XmlProcessor.getBeanInXml(rqObj);
		
		/* should be modified later **/
		
		logger.debug("Sending Request to get HB Htel Data");
        Request.Builder requestBuilder = new Request.Builder().headers(getHeaders("POST")).url(HBProperties.HB_GET_HOTELS_END_POINT);
        requestBuilder.post(RequestBody.create(HBProperties.JSON, requestXML));
        
      //@TODO: this should be moved to HB. Copying temporarily to HB
        //Also check the response code in order to verify status
        Response response = BontonConfigImpl.getRestTemplate().newCall(requestBuilder.build()).execute();
        logger.debug("HB Hotel Data Response Code : "+response.code()+" : Response Message : "+response.message());
        
        
        try (ResponseBody body = response.body()) {
            BufferedSource source = body.source();
            source.request(Long.MAX_VALUE);
            Buffer buffer = source.buffer();
            Charset charset = HBProperties.UTF8;
            if (body.contentType() != null) {
                try {
                    charset = body.contentType().charset(HBProperties.UTF8);
                } catch (UnsupportedCharsetException e) {
                    logger.error("Response body could not be decoded {}", e.getMessage());
                }
            }
            return buffer.readString(charset);
        } catch (Exception e) {
        	logger.debug("Error {}", e);
        	throw e;
        }
	}
	
	public boolean writeResponseDataInAggregationFormat(String responseJson, String requestId) {
	
		boolean success = false;
		Gson g = new Gson();
	    HBJsonDataContainer hbJaonDataCOntainer = g.fromJson(responseJson, HBJsonDataContainer.class);
	    String fileNameWithPath = HBProperties.FILE_WRITE_DIRECTORY + requestId + ".txt";
	    if(hbJaonDataCOntainer != null) {
	    	if(hbJaonDataCOntainer.getAuditData() != null && hbJaonDataCOntainer.getHotels() != null) {
	    		HBDataProcessor hbDataProcessor = new HBDataProcessor();
	    		String dataString  = hbDataProcessor.getHBDataReponseInAggregationFormat(hbJaonDataCOntainer);
	    		
	    		
	    		//@TODO this should be moved to bonton ************************************
	    		FileProcessor.writeStringToFile(dataString, fileNameWithPath);
	    		success = true;
	    	}
	    }
		return success;
	}
	
	public String getHotelsDataJson(BTNSearchRequest xmlRequestObj, String requestId) throws Exception {
			
			String requestJsonString = getSearchHotelsJsonRequestString(xmlRequestObj);
			StringBuilder stringBuilder = new StringBuilder();
			String result = "";
			BontonConfigImpl.init();
				//if (;) {
		            try {
		            	logger.debug("Sending Request to get HB Htel Data");
		                Request.Builder requestBuilder = new Request.Builder().headers(getHeaders("POST")).url(HBProperties.HB_GET_HOTELS_END_POINT);
		                requestBuilder.post(RequestBody.create(HBProperties.JSON, requestJsonString));
		                
		                
		                //@TODO: this should be moved to HB. Copying temporarily to HB
		                Response response = BontonConfigImpl.getRestTemplate().newCall(requestBuilder.build()).execute();
		                logger.debug("HB Hotel Data Response Code : "+response.code()+" : Response Message : "+response.message());
		                try (ResponseBody body = response.body()) {
		                    BufferedSource source = body.source();
		                    source.request(Long.MAX_VALUE);
		                    Buffer buffer = source.buffer();
		                    Charset charset = HBProperties.UTF8;
		                    if (body.contentType() != null) {
		                        try {
		                            charset = body.contentType().charset(HBProperties.UTF8);
		                        } catch (UnsupportedCharsetException e) {
		                            logger.error("Response body could not be decoded {}", e.getMessage());
		                        }
		                    }
		                    result = buffer.readString(charset);
		                    if (response.headers().get(HBProperties.CONTENT_TYPE_HEADER).toLowerCase().startsWith(HBProperties.APPLICATION_JSON_HEADER)) {
		                         return result;
		                    } else {
		                    	logger.error("Invalid response Wrong content type" + response.headers().get(HBProperties.CONTENT_TYPE_HEADER));
		                    }
		                }
		            } catch (IOException e) {
		                if (e.getCause() != null && e.getCause() instanceof SocketTimeoutException) {
		                	logger.error("Timeout {}", e);
		                	
		                } else {
		                	logger.error("Error accessing API", e.getMessage());
		                }
		                return HBProperties.SERVICE_TEMPORARILY_DOWN;
		            } catch (Exception e) {
		            	e.printStackTrace(System.out);
		            	throw e;
		            }
				//}
			return result;
	}
	
	public String sendBookingConfirmationAndGetResult(BTNConfirmRequest confirmBean) {
		String responseStr = "";
		String requestXmlString = getHotelBedsBookingConfirmationRequestXml(confirmBean);
		
		//if (BontonConfigImpl.isInitialised()) {
            try {
            	logger.debug("Sending Request to Booking Confirmation");
                Request.Builder requestBuilder = new Request.Builder().headers(getHeadersForBookingOrCancellation("POST")).url(HBProperties.HB_CONFIRM_BOOKING_POST_URL);
                requestBuilder.post(RequestBody.create(HBProperties.XML,requestXmlString));
                Response response = BontonConfigImpl.getRestTemplate().newCall(requestBuilder.build()).execute();
                logger.debug("HB Send Booking Confirmation Response Code : "+response.code()+" : Response Message : "+response.message());
                try (ResponseBody body = response.body()) {
                    BufferedSource source = body.source();
                    source.request(Long.MAX_VALUE);
                    Buffer buffer = source.buffer();
                    Charset charset = HBProperties.UTF8;
                    if (body.contentType() != null) {
                        try {
                            charset = body.contentType().charset(HBProperties.UTF8);
                        } catch (UnsupportedCharsetException e) {
                            logger.error("Response body could not be decoded {}", e.getMessage());
                        }
                    }
                    responseStr = buffer.readString(charset);
                    if (response.headers().get(HBProperties.CONTENT_TYPE_HEADER).toLowerCase().startsWith(HBProperties.APPLICATION_XML_HEADER)) {
                         return responseStr;
                    } else {
                    	logger.error("Invalid response Wrong content type" + response.headers().get(HBProperties.CONTENT_TYPE_HEADER));
                    }
                }
            } catch (IOException e) {
                if (e.getCause() != null && e.getCause() instanceof SocketTimeoutException) {
                	logger.error("Timeout", e.getCause().getMessage());
                	
                } else {
                	logger.error("Error accessing API", e.getMessage());
                }
                return HBProperties.SERVICE_TEMPORARILY_DOWN;
            } catch (Exception e) {
            	logger.error(e.getClass().getName(), e.getMessage(), e);
            	return HBProperties.SERVICE_TEMPORARILY_DOWN;
            }
		//}
		
		
		return responseStr;
	}
	
	public String sendCancelBookingRequestAndGetResult(CancellationBean xmlRequestObj) {
		
		// getHotelsDataJson methodology
		String requestJsonString = getHotelBedsCancellationBookingRequestXml(xmlRequestObj);
		StringBuilder stringBuilder = new StringBuilder();
		String result = "";
		
			//if (BontonConfigImpl.isInitialised()) {
	            try {
	            	logger.debug("Sending Request to get HB Htel Data");
	                Request.Builder requestBuilder = new Request.Builder().headers(getHeaders("DELETE")).url(HBProperties.HB_GET_HOTELS_END_POINT);
	                requestBuilder.post(RequestBody.create(HBProperties.XML,requestJsonString));
	                
	                
	                Response response = BontonConfigImpl.getRestTemplate().newCall(requestBuilder.build()).execute();
	                logger.debug("HB Hotel Data Response Code : "+response.code()+" : Response Message : "+response.message());
	                try (ResponseBody body = response.body()) {
	                    BufferedSource source = body.source();
	                    source.request(Long.MAX_VALUE);
	                    Buffer buffer = source.buffer();
	                    Charset charset = HBProperties.UTF8;
	                    if (body.contentType() != null) {
	                        try {
	                            charset = body.contentType().charset(HBProperties.UTF8);
	                        } catch (UnsupportedCharsetException e) {
	                            logger.error("Response body could not be decoded {}", e.getMessage());
	                        }
	                    }
	                    result = buffer.readString(charset);
	                    if (response.headers().get(HBProperties.CONTENT_TYPE_HEADER).toLowerCase().startsWith(HBProperties.APPLICATION_JSON_HEADER)) {
	                         return result;
	                    } else {
	                    	logger.error("Invalid response Wrong content type" + response.headers().get(HBProperties.CONTENT_TYPE_HEADER));
	                    }
	                }
	            } catch (IOException e) {
	                if (e.getCause() != null && e.getCause() instanceof SocketTimeoutException) {
	                	logger.error("Timeout", e.getCause().getMessage());
	                	
	                } else {
	                	logger.error("Error accessing API", e.getMessage());
	                }
	                return HBProperties.SERVICE_TEMPORARILY_DOWN;
	            } catch (Exception e) {
	            	logger.error(e.getClass().getName(), e.getMessage(), e);
	            	return HBProperties.SERVICE_TEMPORARILY_DOWN;
	            }
			//}
		return result;			
		
		
		
	}												
	
	public String recheckHotelPricingAndGetResult(BTNRepriceRequest repricingBean) {
		String result = "";
		String rateKey = repricingBean.getRooms().getRoom().getUniqueKey();

		try {
			Request.Builder requestBuilder = new Request.Builder().headers(getHeaders("GET")).url(HBProperties.HB_REPRICING_RATE_KEY_GET_URL+"?rateKey="+rateKey);

			Response response = BontonConfigImpl.getRestTemplate().newCall(requestBuilder.build()).execute();
			try (ResponseBody body = response.body()) {
				BufferedSource source = body.source();
				source.request(Long.MAX_VALUE);
				Buffer buffer = source.buffer();
				Charset charset = HBProperties.UTF8;
				if (body.contentType() != null) {
					try {
						charset = body.contentType().charset(HBProperties.UTF8);
					} catch (UnsupportedCharsetException e) {
						// logger.log("Response body could not be decoded {}", e.getMessage());
					}
				}
				result = buffer.readString(charset);
				result = RepricingUtil.getRepricingXml(result);
				logger.debug("Response body could not be decoded recheckHotelPricingAndGetResult {}", result);
				if (response.headers().get(HBProperties.CONTENT_TYPE_HEADER).toLowerCase().startsWith(HBProperties.APPLICATION_JSON_HEADER)) {
					return result;
				} else {
					//throw new HotelBedsConnectorException("Invalid response", "Wrong content type" + response.headers().get(HotelBedsProperties.CONTENT_TYPE_HEADER));
				}
			} catch (IOException e) {
				if (e.getCause() != null && e.getCause() instanceof SocketTimeoutException) {
					//throw new HotelBedsConnectorException("Timeout", e.getCause().getMessage());
				} else {
					//throw new HotelBedsConnectorException("Error accessing API", e.getMessage());
				}
			}
		} catch (Exception e) {
			//throw new HotelBedsConnectorException(e.getClass().getName(), e.getMessage(), e);
		}
		return result;
	}
	
	//TODO: modify this to throw exception and use loggers appropriately
	private String getSearchHotelsJsonRequestString(BTNSearchRequest bean) {
		String resultStr = "";
		if(bean != null) {
			String checkin = bean.getRequestDetails().getSearchHotelPriceRequest().getPeriodOfStay().getCheckInDate();
			String checkout = bean.getRequestDetails().getSearchHotelPriceRequest().getPeriodOfStay().getCheckOutDate();

			try {
				Date date1;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				date1 = sdf.parse(checkin);

				Date date2;
				date2 = sdf.parse(checkout);    

				if(date1.after(date2)){
					logger.error("checkIn must be prior to checkOut date");
				}

				else if(date2.before(date1)){
					logger.error("checkIn must be prior to checkOut date");
				}

				else if(date1.equals(date2)){
					logger.error("Dates can't have same values");
				}

				int numberOfRooms = bean.getRequestDetails().getSearchHotelPriceRequest().getRooms().getRoom().getNumberOfRooms();
				String minStarRating = bean.getRequestDetails().getSearchHotelPriceRequest().getMinStarRating();
				String maxStarRating = bean.getRequestDetails().getSearchHotelPriceRequest().getMaxStarRating();
				String destination = bean.getRequestDetails().getSearchHotelPriceRequest().getItemDestination().getDestinationCode();

				resultStr = "{\"occupancies\":[{\"rooms\":"+numberOfRooms+",\"children\":0,\"adults\":1,\"paxes\":[]}],\"stay\":{\"checkIn\":\""+checkin+"\",\"checkOut\":\""+checkout+"\"},\"destination\": {\"code\": \""+destination+"\"},\"filter\": {\"minCategory\": "+minStarRating+",\"maxCategory\": "+maxStarRating+"}}";
				logger.debug("json string {}", resultStr);
			}catch(Exception e) {
				logger.error("Error Parsing Data", e);
				e.printStackTrace();
			}
		}
		return resultStr;

	}
	
	private Headers getHeaders(String httpMethod) {
        Headers.Builder headersBuilder = new Headers.Builder();
        headersBuilder.add(HBProperties.API_KEY_HEADER_NAME, HBProperties.API_KEY);
        headersBuilder.add("User-Agent", "hotel-api-sdk-java, " + getClass().getPackage().getImplementationVersion());
        // Hash the Api Key + Shared Secret + Current timestamp in seconds
        headersBuilder.add(HBProperties.SIGNATURE_HEADER_NAME, DigestUtils.sha256Hex(HBProperties.API_KEY + HBProperties.SHARED_SECRET + System.currentTimeMillis() / 1000));
        headersBuilder.add("Accept", "application/json");
        headersBuilder.add("Content-Type", "application/json; charset=UTF-8");
        switch (httpMethod) {
            case "GET":
            case "POST":
                headersBuilder.add("Content-Type", HBProperties.APPLICATION_JSON_HEADER);
                break;
            default:
                break;
        }
        return headersBuilder.build();
    }
	
	private Headers getHeadersForBookingOrCancellation(String httpMethod) {
        Headers.Builder headersBuilder = new Headers.Builder();
        headersBuilder.add(HBProperties.API_KEY_HEADER_NAME, HBProperties.API_KEY);
        headersBuilder.add("User-Agent", "hotel-api-sdk-java, " + getClass().getPackage().getImplementationVersion());
        // Hash the Api Key + Shared Secret + Current timestamp in seconds
        headersBuilder.add(HBProperties.SIGNATURE_HEADER_NAME, DigestUtils.sha256Hex(HBProperties.API_KEY + HBProperties.SHARED_SECRET + System.currentTimeMillis() / 1000));
        headersBuilder.add("Accept", "application/xml");
        headersBuilder.add("Content-Type", "application/xml; charset=UTF-8");
        switch (httpMethod) {
            case "GET":
            case "POST":
                headersBuilder.add("Content-Type", HBProperties.APPLICATION_XML_HEADER);
                break;
            case "DELETE":
                headersBuilder.add("Content-Type", HBProperties.APPLICATION_XML_HEADER);
                break;
            default:
                break;
        }
        return headersBuilder.build();
    }
	
	/**
	 * @param confirmBookingRequestObj
	 * @return request xml that will be sent to HotelBeds API for booking Confirmation
	 */
	public static String getHotelBedsBookingConfirmationRequestXml(BTNConfirmRequest confirmBean) {
		
		StringBuilder xmlString = new StringBuilder("");
		
		xmlString.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		xmlString.append("<bookingRQ xmlns=\"http://www.hotelbeds.com/schemas/messages\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">");
		xmlString.append("<holder name=\""+confirmBean.getPrinciplePax().getName()+"\" surname=\""+confirmBean.getPrinciplePax().getSurname()+"\"/>");
		xmlString.append("<clientReference>"+confirmBean.getClientReference()+"</clientReference>");
		xmlString.append("<rooms>");
		
		List<Room> roomLst = confirmBean.getRooms().getRoom();
		int rooms = roomLst.size();
		for (Room room : roomLst) {
			xmlString.append("<room rateKey=\""+room.getUniqueKey()+"\">");
			xmlString.append("<paxes>");
			List<Pax> paxLst = room.getPaxes().getPax();
			for (Pax p : paxLst) {
				xmlString.append("<pax roomId=\""+p.getRoomId()+"\""+" type=\""+p.getType()+"\" age=\""+p.getAge()+"\" name=\""+p.getName()+"\" surname=\""+p.getSurname()+"\"/>");
			}
			xmlString.append("</paxes>");
			xmlString.append("</room>");
		}
		
		xmlString.append("</rooms>");
		/*xmlString.append("<paymentData>");
		xmlString.append("<paymentCard>");
		xmlString.append("<cardType>"+cardType+"</cardType>");
		xmlString.append("<cardNumber>"+cardNumber+"</cardNumber>");
		xmlString.append("<expiryDate>"+expiryDate+"</expiryDate>");
		xmlString.append("<cardCVC>"+cardCVC+"</cardCVC>");
		xmlString.append(" </paymentCard>");
		xmlString.append("<contactData>");
		xmlString.append("<email>"+email+"</email>");
		xmlString.append("<phoneNumber>"+phoneNum+"</phoneNumber>");
		xmlString.append(" </contactData>");
		xmlString.append("</paymentData>");*/
		xmlString.append("</bookingRQ>");
		
		logger.debug(xmlString.toString());
		return xmlString.toString();
		
	}
	
public static String getHotelBedsCancellationBookingRequestXml(CancellationBean xmlRequestObj) {
		
		StringBuilder xmlString = new StringBuilder("");
		
		String email = "chawlaritesh@presidency.com";
		String password = "test123";
		String clientReference = "4444333322221111";
		//String rateKey = "20160615|20160616|W|270|105996|DBT.DX|ID_B2B_7|RO|FITA|1~1~0||N@-739835568";
		
		
		xmlString.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
		xmlString.append("<Request>");
		xmlString.append("<Source>");
		xmlString.append("<RequestorID Client=\"1819\" EMailAddress=\"XML.TRIYASOFT@BONTONTOURS.COM\" Password=\"PASS\"/>");
		xmlString.append("<RequestorPreferences>");
		xmlString.append("<RequestMode>SYNCHRONOUS</RequestMode>");
		xmlString.append("</RequestorPreferences>");
		xmlString.append("</Source>");
		xmlString.append("<RequestDetails>");
		xmlString.append("<CancelBookingRequest>");
		xmlString.append("<BookingReference ReferenceSource=\"client\">1463480809646</BookingReference> ");
		xmlString.append("</CancelBookingRequest>");
		xmlString.append("</RequestDetails>");
		xmlString.append("</Request>");
		
		logger.debug(xmlString.toString());
		return xmlString.toString();
		
	}									
	
}
