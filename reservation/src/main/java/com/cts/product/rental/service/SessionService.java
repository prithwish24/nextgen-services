package com.cts.product.rental.service;

import com.cts.product.rental.bo.Location;
import com.cts.product.rental.bo.ReservationRequest;

public interface SessionService {

	String createSession(ReservationRequest reservationRequest);

	Location updateSessionWithZipcode(String sessionId, String zipcode);

	String findBySessionId(String requestSessionId);
}
