package com.bonton.beans.hb;

public class CancellationBean {
	
	private String eMailAddress = "";
	private String client = "";
	private String password = "";	
	private String requestMode = "";
	private String referenceSource= "";
	private String text = "";
	
	
	public String geteMailAddress() {
		return eMailAddress;
	}
	public void seteMailAddress(String eMailAddress) {
		this.eMailAddress = eMailAddress;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRequestMode() {
		return requestMode;
	}
	public void setRequestMode(String requestMode) {
		this.requestMode = requestMode;
	}
	public String getReferenceSource() {
		return referenceSource;
	}
	public void setReferenceSource(String referenceSource) {
		this.referenceSource = referenceSource;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
