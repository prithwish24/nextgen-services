package com.cts.product.rental.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
    private Date pickupDateTime;
    @Column(name = "dropoffDateTime")
    private Date dropoffDateTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id")
    private Session session;

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

    public Date getPickupDateTime() {
	return pickupDateTime;
    }

    public void setPickupDateTime(Date pickupDateTime) {
	this.pickupDateTime = pickupDateTime;
    }

    public Date getDropoffDateTime() {
	return dropoffDateTime;
    }

    public void setDropoffDateTime(Date dropoffDateTime) {
	this.dropoffDateTime = dropoffDateTime;
    }

    public Session getSession() {
	return session;
    }

    public void setSession(Session session) {
	this.session = session;
    }

}