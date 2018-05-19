package com.cts.product.rental.service;

import java.io.IOException;
import java.util.List;

import com.cts.product.rental.bo.Reservation;
import com.cts.product.rental.entity.Session;

public interface SessionService {

    List<Reservation> getUpcomingTrips(String sessionId, String username);

    List<Reservation> getAllRentals(String username);

    void updateSessionWithZipcode(String sessionId, String zipcode) throws IOException;

    Session findBySessionId(String requestSessionId);

    void updateSessionWithReservation(String sessionId, Reservation reservation) throws IOException;

    void clearSession(String sessionId);

    void removeAllRentals(String username);
}
