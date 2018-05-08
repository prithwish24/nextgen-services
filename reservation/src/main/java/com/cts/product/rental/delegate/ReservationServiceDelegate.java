package com.cts.product.rental.delegate;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.product.rental.bo.Location;
import com.cts.product.rental.bo.Reservation;
import com.cts.product.rental.bo.ReservationRequest;
import com.cts.product.rental.bo.ReservationResponse;
import com.cts.product.rental.mapper.LocationRequestMapper;
import com.cts.product.rental.mapper.ReservationResponseMapper;
import com.cts.product.rental.service.LocationService;
import com.cts.product.rental.service.ReservationService;
import com.cts.product.rental.service.SessionService;

@Service
public class ReservationServiceDelegate {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private SessionService sessionService;

    public ReservationResponse delegate(ReservationRequest reservationRequest) throws IOException {
	ReservationResponse reservationResponse = new ReservationResponse();
	String action = reservationRequest.getResult().getAction();
	switch (action) {
	case "getSessionId":
	    String sessionId = sessionService.createSession(reservationRequest);
	    reservationResponse = ReservationResponseMapper.mapSession(sessionId);
	    break;
	case "findNearestRentOffice":
	    Location locationRequest = LocationRequestMapper.map(reservationRequest);
	    Location location = locationService.getLocation(locationRequest);
	    reservationResponse = ReservationResponseMapper.mapLocation(reservationRequest, location);
	    break;
	case "createReservation":
	    Reservation reservation = reservationService.createReservation(reservationRequest);
	    reservationResponse = ReservationResponseMapper.mapReservation(reservationRequest, reservation);
	    break;
	default:
	    throw new IOException("Undefined action.");
	}

	return reservationResponse;

    }
}
