package com.hotelbeds.beans;

import java.io.Serializable;

public class Offers implements Serializable {

	
	private String code = "";
	private String name = "";
	private String amount = "";
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
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
}
