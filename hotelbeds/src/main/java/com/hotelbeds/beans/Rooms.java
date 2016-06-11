package com.hotelbeds.beans;

import java.io.Serializable;
import java.util.List;

public class Rooms implements Serializable {

	private String code = "";
	private String name = "";
	private List<Rates> rates;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Rates> getRates() {
		return rates;
	}
	public void setRates(List<Rates> rates) {
		this.rates = rates;
	}
	
}
