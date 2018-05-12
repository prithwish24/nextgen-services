package com.cts.product.rental.bo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "amount", "unit" })
public class Duration {

    @JsonProperty("amount")
    Integer amount;
    @JsonProperty("unit")
    String unit;

    @JsonProperty("amount")
    public Integer getAmount() {
	return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Integer amount) {
	this.amount = amount;
    }

    @JsonProperty("unit")
    public String getUnit() {
	return unit;
    }

    @JsonProperty("unit")
    public void setUnit(String unit) {
	this.unit = unit;
    }

}
