package com.hotelbeds.beans.repricing;

import java.io.Serializable;
import java.util.List;

public class Taxes implements Serializable {
	
	private List<com.hotelbeds.beans.repricing.json.Taxes> taxes = null;
	private boolean allIncluded ;
	public List<com.hotelbeds.beans.repricing.json.Taxes> getTaxes() {
		return taxes;
	}
	public void setTaxes(List<com.hotelbeds.beans.repricing.json.Taxes> taxes) {
		this.taxes = taxes;
	}
	public boolean isAllIncluded() {
		return allIncluded;
	}
	public void setAllIncluded(boolean allIncluded) {
		this.allIncluded = allIncluded;
	}

	
	
}
