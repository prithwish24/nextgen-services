
package com.cts.product.rental.bo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "intentId",
    "webhookUsed",
    "webhookForSlotFillingUsed",
    "intentName"
})
public class Metadata {

    @JsonProperty("intentId")
    private String intentId;
    @JsonProperty("webhookUsed")
    private String webhookUsed;
    @JsonProperty("webhookForSlotFillingUsed")
    private String webhookForSlotFillingUsed;
    @JsonProperty("intentName")
    private String intentName;

    @JsonProperty("intentId")
    public String getIntentId() {
        return intentId;
    }

    @JsonProperty("intentId")
    public void setIntentId(String intentId) {
        this.intentId = intentId;
    }

    @JsonProperty("webhookUsed")
    public String getWebhookUsed() {
        return webhookUsed;
    }

    @JsonProperty("webhookUsed")
    public void setWebhookUsed(String webhookUsed) {
        this.webhookUsed = webhookUsed;
    }

    @JsonProperty("webhookForSlotFillingUsed")
    public String getWebhookForSlotFillingUsed() {
        return webhookForSlotFillingUsed;
    }

    @JsonProperty("webhookForSlotFillingUsed")
    public void setWebhookForSlotFillingUsed(String webhookForSlotFillingUsed) {
        this.webhookForSlotFillingUsed = webhookForSlotFillingUsed;
    }

    @JsonProperty("intentName")
    public String getIntentName() {
        return intentName;
    }

    @JsonProperty("intentName")
    public void setIntentName(String intentName) {
        this.intentName = intentName;
    }

}
