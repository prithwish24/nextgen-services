package com.cts.product.rental.service;

import java.io.IOException;

import com.cts.product.rental.bo.ReservationRequest;
import com.cts.product.rental.entity.Session;

public interface SessionService {

	String createSession(ReservationRequest reservationRequest);

	void updateSessionWithZipcode(String sessionId, String zipcode)
			throws IOException;

	Session findBySessionId(String requestSessionId);
}
