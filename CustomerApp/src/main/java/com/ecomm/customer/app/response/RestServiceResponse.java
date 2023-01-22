package com.ecomm.customer.app.response;

public class RestServiceResponse {
	private int statusCode;
	private String statusMessage;
	public String getStatusMessage() {
		return statusMessage;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
}
