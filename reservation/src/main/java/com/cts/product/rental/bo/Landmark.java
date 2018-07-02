
package com.cts.product.rental.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "city",
    "city.original",
    "city.object",
    "business-name",
    "business-name.original",
    "business-name.object",
    "pickuplocation"
})
public class Landmark {

	@JsonProperty("street-address")
    private String streetAddress;
    @JsonProperty("city")
    private String city;
    @JsonProperty("city.original")
    private String cityOriginal;
    @JsonProperty("city.object")
    private CityObject cityObject;
    @JsonProperty("business-name")
    private String businessName;
    @JsonProperty("business-name.original")
    private String businessNameOriginal;
    @JsonProperty("business-name.object")
    private BusinessNameObject businessNameObject;
    @JsonProperty("pickuplocation")
    private String pickuplocation;

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("city.original")
    public String getCityOriginal() {
        return cityOriginal;
    }

    @JsonProperty("city.original")
    public void setCityOriginal(String cityOriginal) {
        this.cityOriginal = cityOriginal;
    }

    @JsonProperty("city.object")
    public CityObject getCityObject() {
        return cityObject;
    }

    @JsonProperty("city.object")
    public void setCityObject(CityObject cityObject) {
        this.cityObject = cityObject;
    }

    @JsonProperty("business-name")
    public String getBusinessName() {
        return businessName;
    }

    @JsonProperty("business-name")
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    @JsonProperty("business-name.original")
    public String getBusinessNameOriginal() {
        return businessNameOriginal;
    }

    @JsonProperty("business-name.original")
    public void setBusinessNameOriginal(String businessNameOriginal) {
        this.businessNameOriginal = businessNameOriginal;
    }

    @JsonProperty("business-name.object")
    public BusinessNameObject getBusinessNameObject() {
        return businessNameObject;
    }

    @JsonProperty("business-name.object")
    public void setBusinessNameObject(BusinessNameObject businessNameObject) {
        this.businessNameObject = businessNameObject;
    }

    @JsonProperty("pickuplocation")
    public String getPickuplocation() {
        return pickuplocation;
    }

    @JsonProperty("pickuplocation")
    public void setPickuplocation(String pickuplocation) {
        this.pickuplocation = pickuplocation;
    }

    @JsonProperty("street-address")
	public String getStreetAddress() {
		return streetAddress;
	}

    @JsonProperty("street-address")
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

}
