package com.cts.product.rental.bo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "code", "type", "text" })
public class ServiceError {

    private String code;
    private String type;
    private String text;

    public ServiceError() {
    }

    public ServiceError(String code, String type, String text) {
	this.code = code;
	this.type = type;
	this.text = text;
    }

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public String getText() {
	return text;
    }

    public void setText(String text) {
	this.text = text;
    }

}
