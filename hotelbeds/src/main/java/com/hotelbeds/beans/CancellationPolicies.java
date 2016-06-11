package com.hotelbeds.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CancellationPolicies implements Serializable {
	
	private boolean included;
	private String percent = "";
	
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
	
	
}
