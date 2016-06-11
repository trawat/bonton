package com.bonton.beans.hb;

import java.util.List;
import java.util.Map;

public class Occupancies {
	
	private String rooms = "";
	private String adults = "";
	private String children = "";
	private List<Map<String, String>> paxes = null;
	
	public String getRooms() {
		return rooms;
	}
	public void setRooms(String rooms) {
		this.rooms = rooms;
	}
	public String getAdults() {
		return adults;
	}
	public void setAdults(String adults) {
		this.adults = adults;
	}
	public String getChildren() {
		return children;
	}
	public void setChildren(String children) {
		this.children = children;
	}
	public List<Map<String, String>> getPaxes() {
		return paxes;
	}
	public void setPaxes(List<Map<String, String>> paxes) {
		this.paxes = paxes;
	}
		

}
