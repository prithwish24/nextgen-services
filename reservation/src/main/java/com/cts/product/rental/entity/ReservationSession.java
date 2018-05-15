package com.cts.product.rental.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReservationSession {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "pickupPoint")
    private String pickupPoint;
    @Column(name = "dropPoint")
    private String dropPoint;
    @Column(name = "pickupDateTime")
    private String pickupDateTime;
    @Column(name = "dropoffDateTime")
    private String dropoffDateTime;
    @Column(name = "username")
    private String username;
    @Column(name = "carType")
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

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }
}