package com.hotelbeds.jsonbeans;

import java.io.Serializable;
import java.util.List;

public class Hotels implements Serializable {
	
	public List<com.hotelbeds.beans.Hotels> getHotels() {
		return hotels;
	}

	public void setHotels(List<com.hotelbeds.beans.Hotels> hotels) {
		this.hotels = hotels;
	}

	private List<com.hotelbeds.beans.Hotels> hotels = null;

}
