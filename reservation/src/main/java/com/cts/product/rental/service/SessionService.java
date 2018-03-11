package com.cts.product.rental.service;

import com.cts.product.rental.bo.ReservationRequest;

public interface SessionService {
	public String createSession(ReservationRequest reservationRequest);
}
