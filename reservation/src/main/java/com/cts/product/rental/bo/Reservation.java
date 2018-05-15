package com.cts.product.rental.bo;

public class Reservation {

    private String id;
    private String pickupPoint;
    private String dropPoint;
    private String pickupDateTime;
    private String dropoffDateTime;
    private String carType;

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getPickupPoint() {
	return pickupPoint;
    }

    public void setPickupPoint(String pickupPoint) {
	this.pickupPoint = pickupPoint;
    }

    public String getDropPoint() {
	return dropPoint;
    }

    public void setDropPoint(String dropPoint) {
	this.dropPoint = dropPoint;
    }

    public String getPickupDateTime() {
	return pickupDateTime;
    }

    public void setPickupDateTime(String pickupDateTime) {
	this.pickupDateTime = pickupDateTime;
    }

    public String getDropoffDateTime() {
	return dropoffDateTime;
    }

    public void setDropoffDateTime(String dropoffDateTime) {
	this.dropoffDateTime = dropoffDateTime;
    }

    public String getCarType() {
	return carType;
    }

    public void setCarType(String carType) {
	this.carType = carType;
    }
}