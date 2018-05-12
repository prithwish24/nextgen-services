
package com.cts.product.rental.bo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "duration", "sessionId.original", "date-period.original", "sessionId", "duration.original",
	"date-period", "TypeOfItems", "cartype", "TypeOfItems.original", "TypeOfService.original", "TypeOfService",
	"cartype.original", "pickuptime", "pickupdate.original", "pickupdate", "pickuptime.original", "pickuplocation",
	"landmark", "landmark.original", "pickupfromnearestlocation", "confirmationnumber", "step" })
public class Parameters {

    @JsonProperty("duration")
    private Duration duration;
    @JsonProperty("sessionId.original")
    private String sessionIdOriginal;
    @JsonProperty("date-period.original")
    private String datePeriodOriginal;
    @JsonProperty("sessionId")
    private String sessionId;
    @JsonProperty("duration.original")
    private String durationOriginal;
    @JsonProperty("date-period")
    private String datePeriod;
    @JsonProperty("TypeOfItems")
    private String typeOfItems;
    @JsonProperty("cartype")
    private String cartype;
    @JsonProperty("TypeOfItems.original")
    private String typeOfItemsOriginal;
    @JsonProperty("TypeOfService.original")
    private String typeOfServiceOriginal;
    @JsonProperty("TypeOfService")
    private String typeOfService;
    @JsonProperty("cartype.original")
    private String cartypeOriginal;
    @JsonProperty("pickuptime")
    private String pickuptime;
    @JsonProperty("pickupdate.original")
    private String pickupdateOriginal;
    @JsonProperty("pickupdate")
    private String pickupdate;
    @JsonProperty("pickuptime.original")
    private String pickuptimeOriginal;
    @JsonProperty("pickuplocation")
    private String pickuplocation;
    @JsonProperty("landmark")
    private Landmark landmark;
    @JsonProperty("landmark.original")
    private String landmarkOriginal;
    @JsonProperty("pickupfromnearestlocation")
    private boolean pickupfromnearestlocation;
    @JsonProperty("confirmationnumber")
    private String confirmationnumber;
    @JsonProperty("step")
    private String step;

    @JsonProperty("duration")
    public Duration getDuration() {
	return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Duration duration) {
	this.duration = duration;
    }

    @JsonProperty("sessionId.original")
    public String getSessionIdOriginal() {
	return sessionIdOriginal;
    }

    @JsonProperty("sessionId.original")
    public void setSessionIdOriginal(String sessionIdOriginal) {
	this.sessionIdOriginal = sessionIdOriginal;
    }

    @JsonProperty("date-period.original")
    public String getDatePeriodOriginal() {
	return datePeriodOriginal;
    }

    @JsonProperty("date-period.original")
    public void setDatePeriodOriginal(String datePeriodOriginal) {
	this.datePeriodOriginal = datePeriodOriginal;
    }

    @JsonProperty("sessionId")
    public String getSessionId() {
	return sessionId;
    }

    @JsonProperty("sessionId")
    public void setSessionId(String sessionId) {
	this.sessionId = sessionId;
    }

    @JsonProperty("duration.original")
    public String getDurationOriginal() {
	return durationOriginal;
    }

    @JsonProperty("duration.original")
    public void setDurationOriginal(String durationOriginal) {
	this.durationOriginal = durationOriginal;
    }

    @JsonProperty("date-period")
    public String getDatePeriod() {
	return datePeriod;
    }

    @JsonProperty("date-period")
    public void setDatePeriod(String datePeriod) {
	this.datePeriod = datePeriod;
    }

    @JsonProperty("TypeOfItems")
    public String getTypeOfItems() {
	return typeOfItems;
    }

    @JsonProperty("TypeOfItems")
    public void setTypeOfItems(String typeOfItems) {
	this.typeOfItems = typeOfItems;
    }

    @JsonProperty("cartype")
    public String getCartype() {
	return cartype;
    }

    @JsonProperty("cartype")
    public void setCartype(String cartype) {
	this.cartype = cartype;
    }

    @JsonProperty("TypeOfItems.original")
    public String getTypeOfItemsOriginal() {
	return typeOfItemsOriginal;
    }

    @JsonProperty("TypeOfItems.original")
    public void setTypeOfItemsOriginal(String typeOfItemsOriginal) {
	this.typeOfItemsOriginal = typeOfItemsOriginal;
    }

    @JsonProperty("TypeOfService.original")
    public String getTypeOfServiceOriginal() {
	return typeOfServiceOriginal;
    }

    @JsonProperty("TypeOfService.original")
    public void setTypeOfServiceOriginal(String typeOfServiceOriginal) {
	this.typeOfServiceOriginal = typeOfServiceOriginal;
    }

    @JsonProperty("TypeOfService")
    public String getTypeOfService() {
	return typeOfService;
    }

    @JsonProperty("TypeOfService")
    public void setTypeOfService(String typeOfService) {
	this.typeOfService = typeOfService;
    }

    @JsonProperty("cartype.original")
    public String getCartypeOriginal() {
	return cartypeOriginal;
    }

    @JsonProperty("cartype.original")
    public void setCartypeOriginal(String cartypeOriginal) {
	this.cartypeOriginal = cartypeOriginal;
    }

    @JsonProperty("pickuptime")
    public String getPickuptime() {
	return pickuptime;
    }

    @JsonProperty("pickuptime")
    public void setPickuptime(String pickuptime) {
	this.pickuptime = pickuptime;
    }

    @JsonProperty("pickupdate.original")
    public String getPickupdateOriginal() {
	return pickupdateOriginal;
    }

    @JsonProperty("pickupdate.original")
    public void setPickupdateOriginal(String pickupdateOriginal) {
	this.pickupdateOriginal = pickupdateOriginal;
    }

    @JsonProperty("pickupdate")
    public String getPickupdate() {
	return pickupdate;
    }

    @JsonProperty("pickupdate")
    public void setPickupdate(String pickupdate) {
	this.pickupdate = pickupdate;
    }

    @JsonProperty("pickuptime.original")
    public String getPickuptimeOriginal() {
	return pickuptimeOriginal;
    }

    @JsonProperty("pickuptime.original")
    public void setPickuptimeOriginal(String pickuptimeOriginal) {
	this.pickuptimeOriginal = pickuptimeOriginal;
    }

    @JsonProperty("pickuplocation")
    public String getPickuplocation() {
	return pickuplocation;
    }

    @JsonProperty("pickuplocation")
    public void setPickuplocation(String pickuplocation) {
	this.pickuplocation = pickuplocation;
    }

    @JsonProperty("landmark")
    public Landmark getLandmark() {
	return landmark;
    }

    @JsonProperty("landmark")
    public void setLandmark(Landmark landmark) {
	this.landmark = landmark;
    }

    @JsonProperty("landmark.original")
    public String getLandmarkOriginal() {
	return landmarkOriginal;
    }

    @JsonProperty("landmark.original")
    public void setLandmarkOriginal(String landmarkOriginal) {
	this.landmarkOriginal = landmarkOriginal;
    }

    @JsonProperty("pickupfromnearestlocation")
    public boolean isPickupFromNearestLocation() {
	return pickupfromnearestlocation;
    }

    @JsonProperty("pickupfromnearestlocation")
    public void setPickupfromnearestlocation(boolean pickupfromnearestlocation) {
	this.pickupfromnearestlocation = pickupfromnearestlocation;
    }

    @JsonProperty("confirmationnumber")
    public String getConfirmationNumber() {
	return confirmationnumber;
    }

    @JsonProperty("confirmationnumber")
    public void setConfirmationNumber(String confirmationnumber) {
	this.confirmationnumber = confirmationnumber;
    }

    @JsonProperty("step")
    public String getStep() {
	return step;
    }

    @JsonProperty("step")
    public void setStep(String step) {
	this.step = step;
    }
}
