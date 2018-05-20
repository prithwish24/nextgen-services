package com.cts.product.profile.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "type", "value" })
public class Preference {

    private String type;
    private String value;

    public String getType() {
	return type;
    }

    public String getValue() {
	return value;
    }

    public void setType(String type) {
	this.type = type;
    }

    public void setValue(String value) {
	this.value = value;
    }

}
