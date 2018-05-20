package com.cts.product.profile.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "success", "error", "sessionId", "response" })
public class BaseResponse<T> {
    private boolean success;
    private ServiceError error;
    private String sessionId;
    private T response;

    public BaseResponse() {
    }

    public BaseResponse(String code, String type, String text) {
	this.success = false;
	setServiceError(code, type, text);
    }

    public boolean isSuccess() {
	return success;
    }

    public void setSuccess(boolean success) {
	this.success = success;
    }

    public ServiceError getError() {
	return error;
    }

    public void setError(ServiceError error) {
	this.error = error;
    }

    public void setServiceError(String code, String type, String text) {
	this.error = new ServiceError(code, type, text);
    }

    public String getSessionId() {
	return sessionId;
    }

    public void setSessionId(String sessionId) {
	this.sessionId = sessionId;
    }

    public T getResponse() {
	return response;
    }

    public void setResponse(T response) {
	this.response = response;
    }

}
