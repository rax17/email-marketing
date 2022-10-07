package com.company.marketing.model.response;

public class EmailResponse {

	String statusCode;
	String status;
	String description;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EmailResponse() {

	}

	public EmailResponse(String statusCode, String status, String description) {
		super();
		this.statusCode = statusCode;
		this.status = status;
		this.description = description;
	}

}