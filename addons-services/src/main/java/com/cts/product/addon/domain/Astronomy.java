
package com.cts.product.addon.domain;

import java.util.HashMap;
import java.util.Map;

public class Astronomy {

    private String sunrise;
    private String sunset;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
