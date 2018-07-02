package com.cts.product.rental.delegate;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger LOG = LoggerFactory.getLogger(ReservationServiceDelegate.class);

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private SessionService sessionService;
    String sessionId;

    public ReservationResponse delegate(ReservationRequest reservationRequest) throws IOException {
    	ReservationResponse reservationResponse = new ReservationResponse();
    	String action = reservationRequest.getResult().getAction() == null?
    			"":reservationRequest.getResult().getAction().trim();
    	LOG.debug("action: "+action);
    	
    	switch (action) {
    	case "rentOfficeCallback":
    		reservationResponse = ReservationResponseMapper.mapRentOfficeCallback(reservationRequest);
    		break;
    	case "askLocationCallback":
    		reservationResponse = ReservationResponseMapper.mapLocationCallback(reservationRequest);
    		break;
    	case "findNearestRentOffice":
    		Location locationRequest = LocationRequestMapper.map(reservationRequest);
    		LOG.debug("locationRequest : " + locationRequest.toString());
    		Location location = locationService.getLocation(locationRequest);
    		LOG.debug("location : " + location!=null?location.toString():null);
    		reservationResponse = ReservationResponseMapper.mapLocation(reservationRequest, location);
    		break;
    	case "reviewReservation":
    		reservationRequest = reservationService.reviewReservation(reservationRequest);
    		reservationResponse = ReservationResponseMapper.mapReviewReservation(reservationRequest);
    		break;
    	case "createReservation":
    		Reservation reservation = reservationService.createReservation(reservationRequest);
    		reservationRequest.getResult().getContexts().stream()
    		.filter(context -> StringUtils.equals("carrental", context.getName())).forEach(context -> {
    			sessionId = context.getParameters().getSessionId();
    		});
    		if (reservation != null) {
    			sessionService.updateSessionWithReservation(sessionId, reservation);
    			sessionService.clearSession(sessionId);
    		}
    		reservationResponse = ReservationResponseMapper.mapReservation(reservationRequest, reservation);
    		break;
    	default:
    		throw new IOException("Undefined action (" + action + ")");
    	}

    	LOG.debug("response: " +reservationResponse);
    	return reservationResponse;
    }
}
