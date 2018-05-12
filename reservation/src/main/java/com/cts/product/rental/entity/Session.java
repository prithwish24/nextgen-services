package com.cts.product.rental.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Session {

    @Id
    @Column(name = "session_id")
    private String sessionId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "zipcode")
    private String zipcode;
    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReservationSession> reservationSessions;

    public String getUserId() {
	return userId;
    }

    public void setUserId(String userId) {
	this.userId = userId;
    }

    public String getSessionId() {
	return sessionId;
    }

    public void setSessionId(String sessionId) {
	this.sessionId = sessionId;
    }

    public String getZipcode() {
	return zipcode;
    }

    public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
    }

    public List<ReservationSession> getReservations() {
	if (reservationSessions == null) {
	    reservationSessions = new ArrayList<ReservationSession>();
	}
	return reservationSessions;
    }

}
