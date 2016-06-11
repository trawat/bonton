package com.hotelbeds.beans.repricing.json;

import java.io.Serializable;

public class Taxes implements Serializable {
	public boolean isIncluded() {
		return included;
	}
	public void setIncluded(boolean included) {
		this.included = included;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}
	private boolean included;
    public String percent = "";
	public String clientAmount = "";
	public String clientCurrency = "";
	public String currency = "";
}
