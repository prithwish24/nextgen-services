
package com.cts.product.rental.bo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "followupEvent", "speech", "displayText", "contextOut" })
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
	private Fulfillment fulfillment;

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

	@JsonProperty("fulfillment")
	public Fulfillment getFulfillment() {
		return fulfillment;
	}

	@JsonProperty("fulfillment")
	public void setFulfillment(Fulfillment fulfillment) {
		this.fulfillment = fulfillment;
	}

}
