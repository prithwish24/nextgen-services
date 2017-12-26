
package com.cts.product.addon.domain;

import java.util.HashMap;
import java.util.Map;

public class WeatherResponse {

    private Query query;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
