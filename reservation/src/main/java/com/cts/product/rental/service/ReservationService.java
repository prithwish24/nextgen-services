package com.cts.product.rental.service;

import java.io.IOException;
import java.util.List;

import com.cts.product.rental.bo.Location;
import com.cts.product.rental.bo.Reservation;
import com.cts.product.rental.bo.ReservationRequest;

public interface ReservationService {

    Reservation createReservation(ReservationRequest reservationRequest);

    List<Reservation> getUpcomingTrips();

    Location updateSessionWithZipcode(String sessionId, String zipcode) throws IOException;
}
