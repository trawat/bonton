package com.hotelbeds.beans.repricing;

import java.io.Serializable;
import java.util.List;

public class Rooms implements Serializable {

	private String code = "";
	private String name = "";
	
	private List<com.hotelbeds.beans.repricing.json.Rates> rates;

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

	public List<com.hotelbeds.beans.repricing.json.Rates> getRates() {
		return rates;
	}

	public void setRates(List<com.hotelbeds.beans.repricing.json.Rates> rates) {
		this.rates = rates;
	}

	
}
