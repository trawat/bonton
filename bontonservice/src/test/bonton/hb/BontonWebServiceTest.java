package bonton.hb;

import java.util.Date;
import java.util.List;

public class BontonWebServiceTest {

	/*public static void main(String[] args) {
		
		
		String json = "{\"hotels\":{\"hotel\":[]},\"occupancies\":[{\"rooms\":1,\"children\":1,\"adults\":2,\"paxes\":[{\"type\":\"AD\",\"age\":30},{\"type\":\"AD\",\"age\":30},{\"type\":\"CH\",\"age\":2}]}],\"stay\":{\"checkIn\":\"2016-05-18\",\"checkOut\":\"2016-05-19\",\"shiftDays\":\"2\"}}";
		
		HotelDataRequest requestData = HotelDataRequest.createHotelRequestDataObj(json);
		
		BontonResponseBuilder responseBuilder = new BontonResponseBuilder();
		
		List<String> endPointsList = responseBuilder.getEnabledEndPoints();
		HotelAndBeds hbObject = null;
		
		hbObject = new HotelAndBeds(requestData);
		boolean isHBThreadAlive = true;
		
		while (isHBThreadAlive) {
			isHBThreadAlive = hbObject.hbThread.isAlive();
			
			if(isHBThreadAlive) {
			//	System.out.println("HBTHreadAlive "+new Date(System.currentTimeMillis()));
				continue;
				
			}else {
				System.out.println("HBTHread IS NOT ALIVE "+new Date(System.currentTimeMillis()));
				break;
			}
		}
		for(String endPoint : endPointsList) {
			
			if(endPoint.equals(BontonProperties.HOTELANDBEDS)) {
		
				hbObject = new HotelAndBeds(requestData);
			
			}else if (endPoint.equals(BontonProperties.EXPEDIA)) {
				
			}else if(endPoint.equals(BontonProperties.DESIA)) {
				
			}
		}
		boolean isHBThreadAlive = true;
		boolean isExpediaThreadAlive = false;
		boolean isDesiaThreadAlive = false;
		
		if(hbObject != null) {
			while ()
		}
		
		while((hbObject != null && isHBThreadAlive) || isExpediaThreadAlive || isDesiaThreadAlive) {
			isHBThreadAlive = 
			if(!isHBThreadAlive) {
				
			}else if (!isExpediaThreadAlive) {
				
			}else if (!isDesiaThreadAlive)
		}
		
	}*/

}
