
package com.cts.product.rental.bo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "speech",
    "messages"
})
public class Fulfillment {

    @JsonProperty("speech")
    private String speech;
    @JsonProperty("messages")
    private List<Message> messages = null;

    @JsonProperty("speech")
    public String getSpeech() {
        return speech;
    }

    @JsonProperty("speech")
    public void setSpeech(String speech) {
        this.speech = speech;
    }

    @JsonProperty("messages")
    public List<Message> getMessages() {
        return messages;
    }

    @JsonProperty("messages")
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
    	try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) { }
    	return super.toString();
    }
    
}
