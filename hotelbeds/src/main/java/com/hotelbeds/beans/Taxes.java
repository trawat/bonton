package com.hotelbeds.beans;

import java.io.Serializable;
import java.util.List;

public class Taxes implements Serializable {
	
	private List<com.hotelbeds.jsonbeans.Taxes> taxes = null;
	private boolean allIncluded ;

	public List<com.hotelbeds.jsonbeans.Taxes> getTaxes() {
		return taxes;
	}
	public void setTaxes(List<com.hotelbeds.jsonbeans.Taxes> taxes) {
		this.taxes = taxes;
	}
	public boolean isAllIncluded() {
		return allIncluded;
	}
	public void setAllIncluded(boolean allIncluded) {
		this.allIncluded = allIncluded;
	}
	
}
