package com.cts.product.rental.service;

import com.cts.product.rental.bo.Location;
import com.cts.product.rental.bo.Reservation;
import com.cts.product.rental.bo.ReservationRequest;

public interface ReservationService {

	Reservation createReservation(ReservationRequest reservationRequest);

	Location updateSessionWithZipcode(String sessionId, String zipcode);
}
