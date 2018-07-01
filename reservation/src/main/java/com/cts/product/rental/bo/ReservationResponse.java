
package com.cts.product.rental.bo;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "fulfillmentText", "followupEvent", "speech", "displayText", "contextOut" })
public class ReservationResponse {

	@JsonProperty("followupEvent")
	private FollowupEvent followupEvent;
	@JsonProperty("speech")
	private String speech;
	@JsonProperty("displayText")
	private String displayText;
	@JsonProperty("contextOut")
	private List<Context> contextOut;
	@JsonProperty("fulfillment")
	private Fulfillment fulfilment;
	

	@JsonProperty("fulfillment")
	public Fulfillment getFulfilment() {
		return fulfilment;
	}

	@JsonProperty("fulfillment")
	public void setFulfilment(Fulfillment fulfilment) {
		this.fulfilment = fulfilment;
	}
	
	@JsonProperty("followupEvent")
	public FollowupEvent getFollowupEvent() {
		return followupEvent;
	}

	@JsonProperty("followupEvent")
	public void setFollowupEvent(FollowupEvent followupEvent) {
		this.followupEvent = followupEvent;
	}

	@JsonProperty("speech")
	public String getSpeech() {
		return speech;
	}

	@JsonProperty("speech")
	public void setSpeech(String speech) {
		this.speech = speech;
	}

	@JsonProperty("displayText")
	public String getDisplayText() {
		return displayText;
	}

	@JsonProperty("displayText")
	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}

	@JsonProperty("contextOut")
	public List<Context> getContextOut() {
		return contextOut;
	}

	@JsonProperty("contextOut")
	public void setContextOut(List<Context> contextOut) {
		this.contextOut = contextOut;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
