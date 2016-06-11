package com.hotelbeds.beans.repricing;

public class AuditData {
	
	private String processTime = "";
	private String timestamp = "";
	private String requestHost = "";
	private String serverId = "";
	private String environment = "";
	private String release = "";
	private String internal = "";
	
	public String getProcessTime() {
		return processTime;
	}
	public void setProcessTime(String processTime) {
		this.processTime = processTime;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getRequestHost() {
		return requestHost;
	}
	public void setRequestHost(String requestHost) {
		this.requestHost = requestHost;
	}
	public String getServerId() {
		return serverId;
	}
	public void setServerId(String serverId) {
		this.serverId = serverId;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public String getRelease() {
		return release;
	}
	public void setRelease(String release) {
		this.release = release;
	}
	public String getInternal() {
		return internal;
	}
	public void setInternal(String internal) {
		this.internal = internal;
	}

}
