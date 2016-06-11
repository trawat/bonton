package com.hotelbeds.beans.repricing;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CancellationPolicies implements Serializable {
	
	private String amount;
	private String from;
	
	
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	
	
	
	
}
