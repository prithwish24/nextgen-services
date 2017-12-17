package com.cts.product.gateway.config;

public class FallbackResponse {
	private static final String F_CODE = "ERR-999";
	private static final String F_SERVICEID = "UNKNOWN";
	private static final String F_MESSAGE = "SORRY, SERVICE IS DOWN !";

	private String code;
	private String serviceId;
	private String message;

	public FallbackResponse(String serviceId) {
		this (F_CODE, serviceId, F_MESSAGE);
	}

	public FallbackResponse(String code, String serviceId, String message) {
		this.code = code;
		this.message = message;
		if ("*".equals(serviceId)) 
			serviceId = F_SERVICEID;
		else 
			this.serviceId = serviceId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
