package com.cts.product.addon.fuel.domain;

public class FuelStation {

	private String access_days_time;

	private boolean cards_accepted;

	private String date_last_confirmed;

	private String expected_date;

	private String fuel_type_code;

	private int id;

	private String groups_with_access_code;

	private String open_date;

	private String owner_type_code;

	private String status_code;

	private String station_name;

	private String station_phone;

	private String updated_at;

	private String geocode_status;

	private double latitude;

	private double longitude;

	private String city;

	private String intersection_directions;

	private String state;

	private String street_address;

	private String ng_vehicle_class;

	private double distance;

	public String getAccessDaysTime() {
		return this.access_days_time;
	}

	public void setAccessDaysTime(String access_days_time) {
		this.access_days_time = access_days_time;
	}

	public boolean isCardsAccepted() {
		return this.cards_accepted;
	}

	public void setCardsAccepted(boolean cards_accepted) {
		this.cards_accepted = cards_accepted;
	}

	public String getDateLastConfirmed() {
		return this.date_last_confirmed;
	}

	public void setDateLastConfirmed(String date_last_confirmed) {
		this.date_last_confirmed = date_last_confirmed;
	}

	public String getExpectedDate() {
		return this.expected_date;
	}

	public void setExpectedDate(String expected_date) {
		this.expected_date = expected_date;
	}

	public String getFuelTypeCode() {
		return this.fuel_type_code;
	}

	public void setFuelTypeCode(String fuel_type_code) {
		this.fuel_type_code = fuel_type_code;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupsWithAccessCode() {
		return this.groups_with_access_code;
	}

	public void setGroupsWithAccessCode(String groups_with_access_code) {
		this.groups_with_access_code = groups_with_access_code;
	}

	public String getOpenDate() {
		return this.open_date;
	}

	public void setOpenDate(String open_date) {
		this.open_date = open_date;
	}

	public String getOwnerTypeCode() {
		return this.owner_type_code;
	}

	public void setOwnerTypeCode(String owner_type_code) {
		this.owner_type_code = owner_type_code;
	}

	public String getStatusCode() {
		return this.status_code;
	}

	public void setStatusCode(String status_code) {
		this.status_code = status_code;
	}

	public String getStationName() {
		return this.station_name;
	}

	public void setStationName(String station_name) {
		this.station_name = station_name;
	}

	public String getStationPhone() {
		return this.station_phone;
	}

	public void setStationPhone(String station_phone) {
		this.station_phone = station_phone;
	}

	public String getUpdatedAt() {
		return this.updated_at;
	}

	public void setUpdatedAt(String updated_at) {
		this.updated_at = updated_at;
	}

	public String getGeocodeStatus() {
		return this.geocode_status;
	}

	public void setGeocodeStatus(String geocode_status) {
		this.geocode_status = geocode_status;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getIntersectionDirections() {
		return this.intersection_directions;
	}

	public void setIntersectionDirections(String intersection_directions) {
		this.intersection_directions = intersection_directions;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreetAddress() {
		return this.street_address;
	}

	public void setStreetAddress(String street_address) {
		this.street_address = street_address;
	}

	private String zip;

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getNgVehicleClass() {
		return this.ng_vehicle_class;
	}

	public void setNgVehicleClass(String ng_vehicle_class) {
		this.ng_vehicle_class = ng_vehicle_class;
	}

	public double getDistance() {
		return this.distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
}
