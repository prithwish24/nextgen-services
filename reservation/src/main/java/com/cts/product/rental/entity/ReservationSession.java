package com.cts.product.rental.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReservationSession {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "pickup_point")
    private String pickupPoint;
    @Column(name = "drop_point")
    private String dropPoint;
    @Column(name = "pickup_time")
    private String pickupDateTime;
    @Column(name = "dropoff_time")
    private String dropoffDateTime;
    @Column(name = "username")
    private String username;
    @Column(name = "car_type")
    private String carType;
    @Column(name = "status")
    private String status;
    @Column(name = "booking_time")
    private LocalDateTime bookingTime;

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

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public LocalDateTime getBookingTime() {
	return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
	this.bookingTime = bookingTime;
    }
}