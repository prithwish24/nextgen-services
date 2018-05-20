package com.cts.product.rental.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.cts.product.rental.bo.Location;
import com.cts.product.rental.bo.Reservation;
import com.cts.product.rental.bo.ReservationRequest;

public interface ReservationService {

    Reservation createReservation(ReservationRequest reservationRequest) throws IOException;

    List<Reservation> getAllRentals(String username) throws ParseException;

    void removeAllRentals(String username);

    List<Reservation> getUpcomingTrips(String sessionId, String username, String count) throws ParseException;

    Location updateSessionWithZipcode(String sessionId, String zipcode) throws IOException;
}
