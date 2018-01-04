package com.cts.product.addon.fuel.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "access_days_time", "cards_accepted", "date_last_confirmed", "expected_date", "fuel_type_code",
		"id", "groups_with_access_code", "open_date", "owner_type_code", "status_code", "station_name", "station_phone",
		"updated_at", "geocode_status", "latitude", "longitude", "city", "intersection_directions", "state",
		"street_address", "zip", "lpg_primary", "ng_vehicle_class", "distance" })
public class FuelStation {

	@JsonProperty("access_days_time")
	private String accessDaysTime;
	@JsonProperty("cards_accepted")
	private String cardsAccepted;
	@JsonProperty("date_last_confirmed")
	private String dateLastConfirmed;
	@JsonProperty("expected_date")
	private String expectedDate;
	@JsonProperty("fuel_type_code")
	private String fuelTypeCode;
	@JsonProperty("id")
	private String id;
	@JsonProperty("groups_with_access_code")
	private String groupsWithAccessCode;
	@JsonProperty("open_date")
	private String openDate;
	@JsonProperty("owner_type_code")
	private String ownerTypeCode;
	@JsonProperty("status_code")
	private String statusCode;
	@JsonProperty("station_name")
	private String stationName;
	@JsonProperty("station_phone")
	private String stationPhone;
	@JsonProperty("updated_at")
	private String updatedAt;
	@JsonProperty("geocode_status")
	private String geocodeStatus;
	@JsonProperty("latitude")
	private String latitude;
	@JsonProperty("longitude")
	private String longitude;
	@JsonProperty("city")
	private String city;
	@JsonProperty("intersection_directions")
	private String intersectionDirections;
	@JsonProperty("state")
	private String state;
	@JsonProperty("street_address")
	private String streetAddress;
	@JsonProperty("zip")
	private String zip;
	@JsonProperty("lpg_primary")
	private boolean lpgPrimary;
	@JsonProperty("ng_vehicle_class")
	private String ngVehicleClass;
	@JsonProperty("distance")
	private String distance;

	@JsonProperty("access_days_time")
	public String getAccessDaysTime() {
		return accessDaysTime;
	}

	@JsonProperty("access_days_time")
	public void setAccessDaysTime(String accessDaysTime) {
		this.accessDaysTime = accessDaysTime;
	}

	@JsonProperty("cards_accepted")
	public String getCardsAccepted() {
		return cardsAccepted;
	}

	@JsonProperty("cards_accepted")
	public void setCardsAccepted(String cardsAccepted) {
		this.cardsAccepted = cardsAccepted;
	}

	@JsonProperty("date_last_confirmed")
	public String getDateLastConfirmed() {
		return dateLastConfirmed;
	}

	@JsonProperty("date_last_confirmed")
	public void setDateLastConfirmed(String dateLastConfirmed) {
		this.dateLastConfirmed = dateLastConfirmed;
	}

	@JsonProperty("expected_date")
	public String getExpectedDate() {
		return expectedDate;
	}

	@JsonProperty("expected_date")
	public void setExpectedDate(String expectedDate) {
		this.expectedDate = expectedDate;
	}

	@JsonProperty("fuel_type_code")
	public String getFuelTypeCode() {
		return fuelTypeCode;
	}

	@JsonProperty("fuel_type_code")
	public void setFuelTypeCode(String fuelTypeCode) {
		this.fuelTypeCode = fuelTypeCode;
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("groups_with_access_code")
	public String getGroupsWithAccessCode() {
		return groupsWithAccessCode;
	}

	@JsonProperty("groups_with_access_code")
	public void setGroupsWithAccessCode(String groupsWithAccessCode) {
		this.groupsWithAccessCode = groupsWithAccessCode;
	}

	@JsonProperty("open_date")
	public String getOpenDate() {
		return openDate;
	}

	@JsonProperty("open_date")
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	@JsonProperty("owner_type_code")
	public String getOwnerTypeCode() {
		return ownerTypeCode;
	}

	@JsonProperty("owner_type_code")
	public void setOwnerTypeCode(String ownerTypeCode) {
		this.ownerTypeCode = ownerTypeCode;
	}

	@JsonProperty("status_code")
	public String getStatusCode() {
		return statusCode;
	}

	@JsonProperty("status_code")
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	@JsonProperty("station_name")
	public String getStationName() {
		return stationName;
	}

	@JsonProperty("station_name")
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	@JsonProperty("station_phone")
	public String getStationPhone() {
		return stationPhone;
	}

	@JsonProperty("station_phone")
	public void setStationPhone(String stationPhone) {
		this.stationPhone = stationPhone;
	}

	@JsonProperty("updated_at")
	public String getUpdatedAt() {
		return updatedAt;
	}

	@JsonProperty("updated_at")
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	@JsonProperty("geocode_status")
	public String getGeocodeStatus() {
		return geocodeStatus;
	}

	@JsonProperty("geocode_status")
	public void setGeocodeStatus(String geocodeStatus) {
		this.geocodeStatus = geocodeStatus;
	}

	@JsonProperty("latitude")
	public String getLatitude() {
		return latitude;
	}

	@JsonProperty("latitude")
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@JsonProperty("longitude")
	public String getLongitude() {
		return longitude;
	}

	@JsonProperty("longitude")
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

	@JsonProperty("intersection_directions")
	public String getIntersectionDirections() {
		return intersectionDirections;
	}

	@JsonProperty("intersection_directions")
	public void setIntersectionDirections(String intersectionDirections) {
		this.intersectionDirections = intersectionDirections;
	}

	@JsonProperty("state")
	public String getState() {
		return state;
	}

	@JsonProperty("state")
	public void setState(String state) {
		this.state = state;
	}

	@JsonProperty("street_address")
	public String getStreetAddress() {
		return streetAddress;
	}

	@JsonProperty("street_address")
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	@JsonProperty("zip")
	public String getZip() {
		return zip;
	}

	@JsonProperty("zip")
	public void setZip(String zip) {
		this.zip = zip;
	}

	@JsonProperty("lpg_primary")
	public boolean getLpgPrimary() {
		return lpgPrimary;
	}

	@JsonProperty("lpg_primary")
	public void setLpgPrimary(boolean lpgPrimary) {
		this.lpgPrimary = lpgPrimary;
	}

	@JsonProperty("ng_vehicle_class")
	public String getNgVehicleClass() {
		return ngVehicleClass;
	}

	@JsonProperty("ng_vehicle_class")
	public void setNgVehicleClass(String ngVehicleClass) {
		this.ngVehicleClass = ngVehicleClass;
	}

	@JsonProperty("distance")
	public String getDistance() {
		return distance;
	}

	@JsonProperty("distance")
	public void setDistance(String distance) {
		this.distance = distance;
	}

}
