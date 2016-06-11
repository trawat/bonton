package com.hotelbeds.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileProcessor {
	
	public static String writeStringToFile(String dataString, String fileNameWithPath) {
		File resultFile = null;
		if(fileNameWithPath != null && !fileNameWithPath.equals("")) {
			resultFile = new File(fileNameWithPath);
			try {
				
				
				if (!resultFile.exists()) {
					resultFile.createNewFile();
				}
				FileOutputStream fop = new FileOutputStream(resultFile);
				// get the content in bytes
				byte[] contentInBytes = dataString.getBytes();

				fop.write(contentInBytes);
				fop.flush();
				fop.close();
			
			}catch(IOException ioe){
				ioe.printStackTrace();
				return null;
			}
		}
		return fileNameWithPath;
	}
	
	public static String parseHBDataFileAndGetXMLResponse(String fileNameWithPath) {
		StringBuilder dataString = new StringBuilder("");
		File file = null;
		if(fileNameWithPath != null && !fileNameWithPath.equals("")) {
			file = new File(fileNameWithPath);
			try {
				
				FileInputStream fis = new FileInputStream(file);
				if (fis != null) {
					
					BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		             char[] charBuffer = new char[128];
		             int bytesRead = -1;
		             while ((bytesRead = br.read(charBuffer)) > 0) {
		            	 dataString.append(charBuffer, 0, bytesRead);
		             }
		         } else {
		             dataString.append("");
		         }
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
			
			
		}
		String str = dataString.toString();
		Map<String,List<String>> resultMap = new HashMap<String,List<String>>();
		String[] dataArrayNew = null;
		String[] dataArrayNewA = null;
		StringBuilder xmlString = new StringBuilder("<HotelResponse><TravelRequestID></TravelRequestID><ServiceRequestID></ServiceRequestID>");
		if(str.length() > 0) {
			int f = 0;
			str = str.replace("\n", "").replace("\r", "");
			String[] dataArr = str.split("h#\t");
			
			if(dataArr != null && dataArr.length > 0) {
				xmlString.append("<OptionsCount>" + dataArr.length + "</OptionsCount>");
				xmlString.append("<MOptionsCount>" + dataArr.length + "</MOptionsCount>");
				if(dataArr[1] != null && !dataArr[1].equals("")) {
					dataArrayNewA = dataArr[1].split("\t");
				}
				xmlString.append("<City>");
				xmlString.append("<CityCode>" + dataArrayNewA[1] + "</CityCode>");
				xmlString.append("<CityName>" + dataArrayNewA[2] + "</CityName></City>");
				xmlString.append("<HotelOptions>");
			for(int j = 1 ; j < dataArr.length;j++) {
				if(dataArr[j] != null && !dataArr[j].equals("")) {
					dataArrayNew = dataArr[j].split("\t");
					if(dataArrayNew != null && dataArrayNew.length > 1) {
						if(dataArrayNew.length > 12) {
							String strA = dataArrayNew[12];
							if(strA != null && !strA.equals("")){
								String[] roomListArray = strA.split("#");
								if(roomListArray != null && roomListArray.length > 0) {
									xmlString.append("<Hotel>");
									xmlString.append("<HotelCode>" + dataArrayNew[3] + "</HotelCode>");
									xmlString.append("<HotelName>" + dataArrayNew[4] + "</HotelName>");
									xmlString.append("<Location>" + dataArrayNew[6] + "</Location>");
									xmlString.append("<Supplier>" + dataArrayNew[0] + "</Supplier>");
									xmlString.append("<StarRating>" + dataArrayNew[5] + "</StarRating>");
									xmlString.append("<MainImage></MainImage>");
									xmlString.append("<ImageCount></ImageCount>");
									xmlString.append("<FullAddress></FullAddress>");
									xmlString.append("<Longitude></Longitude>");
									xmlString.append("<Latitude></Latitude>");
									xmlString.append("<TAReviewCount></TAReviewCount>");
									xmlString.append("<TALocationId></TALocationId>");
									xmlString.append("<TARating></TARating>");
									xmlString.append("<TAPropertyURL></TAPropertyURL>");
									xmlString.append("<TASubRatingName></TASubRatingName>");
									xmlString.append("<TASubRatingValue></TASubRatingValue>");
									
									xmlString.append("<Description>" + dataArrayNew[8] + "</Description>");
									xmlString.append("<Remarks>" + dataArrayNew[9] + "</Remarks>");
									xmlString.append("<EssentialInformation>" + dataArrayNew[10] + "</EssentialInformation>");
									xmlString.append("<Amenities><Amenity></Amenity></Amenities>");
									xmlString.append("<RoomOptions>");
									for(int k = 0; k < roomListArray.length; k++) {
										if(roomListArray[k] != null && !roomListArray[k].equals("")) {
											String[] hotelDataArr = roomListArray[k].split(": ");
											if(hotelDataArr != null && hotelDataArr.length > 0) {
												xmlString.append("<Room>");
												xmlString.append("<RoomDescription>"+hotelDataArr[2]+"</RoomDescription>");
												xmlString.append("<Supplier>"+hotelDataArr[29]+"</Supplier>");
												xmlString.append("<FinalPrice SupplierPrice='" + hotelDataArr[12] + "' OTAFee='" + hotelDataArr[13] + "' OTADiscountAmount='" + hotelDataArr[14] + "'>" + hotelDataArr[15] + "</FinalPrice>");
												xmlString.append("</Room>");
											}
										}
									}
									xmlString.append("</RoomOptions>");
									xmlString.append("</Hotel>");
								}
							}
						}
					}
				}
			  }
			}
		}
		xmlString.append("</HotelOptions></HotelResponse>");
		writeStringToFile(xmlString.toString(),BontonProperties.FILE_WRITE_DIRECTORY + "FetchedDataXMl.xml");
		return xmlString.toString();
	}
	
	public static String readHBDataFileAndGenerateXMLResponse(String fileNameWithPath) {
		StringBuilder dataString = new StringBuilder("");
		File file = null;
		if(fileNameWithPath != null && !fileNameWithPath.equals("")) {
			file = new File(fileNameWithPath);
			try {
				
				FileInputStream fis = new FileInputStream(file);
				if (fis != null) {
					
					BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		             char[] charBuffer = new char[128];
		             int bytesRead = -1;
		             while ((bytesRead = br.read(charBuffer)) > 0) {
		            	 dataString.append(charBuffer, 0, bytesRead);
		             }
		         } else {
		             dataString.append("");
		         }
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
			
			
		}
		String str = dataString.toString();
		Map<String,List<String>> resultMap = new HashMap<String,List<String>>();
		String[] dataArrayNew = null;
		String[] dataArrayNewA = null;
		StringBuilder xmlString = new StringBuilder("<HotelResponse><TravelRequestID></TravelRequestID><ServiceRequestID></ServiceRequestID>");
		if(str.length() > 0) {
			int f = 0;
			str = str.replace("\n", "").replace("\r", "");
			String[] dataArr = str.split("h#\t");
			
			if(dataArr != null && dataArr.length > 0) {
				xmlString.append("<OptionsCount>" + dataArr.length + "</OptionsCount>");
				xmlString.append("<MOptionsCount>" + dataArr.length + "</MOptionsCount>");
				if(dataArr[1] != null && !dataArr[1].equals("")) {
					dataArrayNewA = dataArr[1].split("\t");
				}
				xmlString.append("<City>");
				xmlString.append("<CityCode>" + dataArrayNewA[1] + "</CityCode>");
				xmlString.append("<CityName>" + dataArrayNewA[2] + "</CityName></City>");
				xmlString.append("<HotelOptions>");
			for(int j = 1 ; j < dataArr.length;j++) {
				if(dataArr[j] != null && !dataArr[j].equals("")) {
					dataArrayNew = dataArr[j].split("\t");
		//			logger.debug("dataArrayNew dataArrayNew dataArrayNew {}", Arrays.toString(dataArrayNew));
					if(dataArrayNew != null && dataArrayNew.length > 1) {
						if(dataArrayNew.length > 12) {
							String strA = dataArrayNew[12];
							if(strA != null && !strA.equals("")){
								String[] roomListArray = strA.split("#");
								if(roomListArray != null && roomListArray.length > 0) {
									xmlString.append("<Hotel>");
									xmlString.append("<HotelCode>" + dataArrayNew[3] + "</HotelCode>");
									xmlString.append("<HotelName>" + dataArrayNew[4] + "</HotelName>");
									xmlString.append("<Location>" + dataArrayNew[6] + "</Location>");
									xmlString.append("<Supplier>" + dataArrayNew[0] + "</Supplier>");
									xmlString.append("<StarRating>" + dataArrayNew[5] + "</StarRating>");
									xmlString.append("<Longitude></Longitude>"); //8
									xmlString.append("<Latitude></Latitude>");	//7
									xmlString.append("<MainImage></MainImage>");
									xmlString.append("<ImageCount></ImageCount>");																	
								//	xmlString.append("<FullAddress></FullAddress>");
								//	xmlString.append("<TAReviewCount></TAReviewCount>");
								//	xmlString.append("<TALocationId></TALocationId>");
								//	xmlString.append("<TARating></TARating>");
								//	xmlString.append("<TAPropertyURL></TAPropertyURL>");
								//	xmlString.append("<TASubRatingName></TASubRatingName>");
								//	xmlString.append("<TASubRatingValue></TASubRatingValue>");									
								//	xmlString.append("<Description>" + dataArrayNew[8] + "</Description>");
								//	xmlString.append("<Remarks>" + dataArrayNew[9] + "</Remarks>");
								//	xmlString.append("<EssentialInformation>" + dataArrayNew[10] + "</EssentialInformation>");
									xmlString.append("<Amenities><Amenity></Amenity></Amenities>");
									xmlString.append("<RoomOptions>");
									for(int k = 0; k < roomListArray.length; k++) {
										if(roomListArray[k] != null && !roomListArray[k].equals("")) {
											String[] hotelDataArr = roomListArray[k].split(": ");
											if(hotelDataArr != null && hotelDataArr.length > 0) {
												xmlString.append("<Room>");
												xmlString.append("<RoomDescription>"+hotelDataArr[2]+"</RoomDescription>");
												xmlString.append("<Supplier>"+hotelDataArr[29]+"</Supplier>");
												xmlString.append("<FinalPrice SupplierPrice='" + hotelDataArr[12] + "' OTAFee='" + hotelDataArr[13] + "' OTADiscountAmount='" + hotelDataArr[14] + "'>" + hotelDataArr[15] + "</FinalPrice>");
												xmlString.append("<RateKey>"+hotelDataArr[18]+"</RateKey>");
												
												xmlString.append("<packaging>"+hotelDataArr[19]+"</packaging>");
												//hard coded [25]
												xmlString.append("<cancellationPolicies Amount='" + hotelDataArr[15] + "' from='" + hotelDataArr[21] + "' />");
												xmlString.append("<Remarks>"+hotelDataArr[25]+"</Remarks>");
												
												xmlString.append("</Room>");
											}
										}
									}
									xmlString.append("</RoomOptions>");
									xmlString.append("</Hotel>");
								}
							}
						}
					}
				}
			  }
			}
		}
		xmlString.append("</HotelOptions></HotelResponse>");
	//	writeStringToFile(xmlString.toString(),BontonProperties.FILE_WRITE_DIRECTORY + "FetchedDataXMl.xml");
		return xmlString.toString();
	}
	
	/*public static String getHotelOptionDataInXML(List<String> dataList,String dataString) {
		StringBuilder sbr = new StringBuilder("");
		
		if(dataString != null && !dataString.equals("")) {
			if(hotelDataList != null && !hotelDataList.isEmpty()) {
			resultMap.put("Key "+j+"",hotelDataList );
		}
			for(int k = 0; k < dataArrayNew.length; k++) {
			if(dataArrayNew[k] != null ) {
					hotelDataList.add(dataArrayNew[k]);
					System.out.println("k "+k+" :: "+dataArrayNew[k]);
			}
		}
		
	
		//	String[] data1 = dataString.split("#");
			
			if(data1 != null && data1.length > 0 && dataList != null ) {
				sbr.append("<HotelOptions>");
				sbr.append("<Hotel>");
				sbr.append("<HotelCode>" + dataList.get(3) + "</HotelCode>");
				sbr.append("<HotelName>" + dataList.get(4) + "</HotelName>");
				sbr.append("<Location>" + dataList.get(6) + "</Location>");
				sbr.append("<Supplier>" + dataList.get(0) + "</Supplier>");
				sbr.append("<StarRating></StarRating>");
                sbr.append("<MainImage></MainImage>");
                sbr.append("<ImageCount></ImageCount>");
                sbr.append("<FullAddress></FullAddress>");
                sbr.append("<Longitude></Longitude>");
                sbr.append("<Latitude></Latitude>");
                sbr.append("<TAReviewCount></TAReviewCount>");
                sbr.append("<TALocationId></TALocationId>");
                sbr.append("<TARating></TARating>");
                sbr.append("<TAPropertyURL></TAPropertyURL>");
                sbr.append("<TASubRatingName></TASubRatingName>");
                sbr.append("<TASubRatingValue></TASubRatingValue>");
				
				sbr.append("<Description>" + dataList.get(8) + "</Description>");
				sbr.append("<Remarks>" + dataList.get(7) + "</Remarks>");
				sbr.append("<EssentialInformation>" + dataList.get(9) + "</EssentialInformation>");
				sbr.append("<Amenities><Amenity></Amenity></Amenities>");
			//	System.out.println(sbr.toString());
				
				sbr.append("<RoomOptions>");
				
				for(int k = 0 ; k < data1.length ; k++) {
					
					if(data1[k] != null && !data1[k].equals("")) {
						
						String[] hotelDataArr = data1[k].split(": ");
						if(hotelDataArr != null && hotelDataArr.length > 0) {
							sbr.append("<Room>");
							sbr.append("<Supplier>"+hotelDataArr[28]+"</Supplier>");
							sbr.append("<FinalPrice SupplierPrice='" + hotelDataArr[12] + "' OTAFee='" + hotelDataArr[13] + "' OTADiscountAmount='" + hotelDataArr[14] + "'>" + hotelDataArr[15] + "</FinalPrice>");
							sbr.append("</Room>");
						}
					}
					
				}
				sbr.append("</RoomOptions>");
				sbr.append("</Hotel></HotelOptions>");
			
		}
Set<String> keySet = resultMap.keySet();
		
		StringBuilder xmlString = new StringBuilder("<HotelResponse><TravelRequestID></TravelRequestID><ServiceRequestID></ServiceRequestID>");
		
		if(keySet != null && !keySet.isEmpty()) {
			xmlString.append("<OptionsCount>"+keySet.size()+"</OptionsCount><MOptionsCount>" + keySet.size() + "</MOptionsCount>");
			for(String key : keySet) {
				List<String> dataList = (List<String>)resultMap.get(key);
				if(dataList != null && !dataList.isEmpty()) {
						xmlString.append("<City>");
						xmlString.append("<CityCode>" + dataList.get(1) + "</CityCode>");
						xmlString.append("<CityName>" + dataList.get(2) + "</CityName></City>");
						System.out.println(dataList.size());
						
						xmlString.append("<HotelOptions>");
						xmlString.append("<Hotel>");
						xmlString.append("<HotelCode>" + dataList.get(3) + "</HotelCode>");
						xmlString.append("<HotelName>" + dataList.get(4) + "</HotelName>");
						xmlString.append("<Location>" + dataList.get(4) + "</Location>");
						xmlString.append("<Supplier>" + dataList.get(0) + "</Supplier>");
						xmlString.append("<StarRating></StarRating>");
						xmlString.append("<MainImage></MainImage>");
						xmlString.append("<ImageCount></ImageCount>");
						xmlString.append("<FullAddress></FullAddress>");
						xmlString.append("<Longitude></Longitude>");
						xmlString.append("<Latitude></Latitude>");
						xmlString.append("<TAReviewCount></TAReviewCount>");
						xmlString.append("<TALocationId></TALocationId>");
						xmlString.append("<TARating></TARating>");
						xmlString.append("<TAPropertyURL></TAPropertyURL>");
						xmlString.append("<TASubRatingName></TASubRatingName>");
						xmlString.append("<TASubRatingValue></TASubRatingValue>");
						
						xmlString.append("<Description>" + dataList.get(8) + "</Description>");
						xmlString.append("<Remarks>" + dataList.get(7) + "</Remarks>");
						xmlString.append("<EssentialInformation>" + dataList.get(9) + "</EssentialInformation>");
						xmlString.append("<Amenities><Amenity></Amenity></Amenities>");
						for(String hotelDataString : dataList) {
							//xmlString.append(getHotelOptionDataInXML(dataList,hotelDataString));
							String[] hotelDataArr = hotelDataString.split(": ");
							if(hotelDataArr != null && hotelDataArr.length > 0) {
								xmlString.append("<Room>");
								xmlString.append("<Supplier>"+hotelDataArr[28]+"</Supplier>");
								xmlString.append("<FinalPrice SupplierPrice='" + hotelDataArr[12] + "' OTAFee='" + hotelDataArr[13] + "' OTADiscountAmount='" + hotelDataArr[14] + "'>" + hotelDataArr[15] + "</FinalPrice>");
								xmlString.append("</Room>");
							}
						}
						
						
				}
			}
		}
		return sbr.toString();
		
	}
	*/
}
