package com.cts.product.rental.dao;

import java.io.IOException;
import java.util.List;

import com.cts.product.rental.bo.Reservation;
import com.cts.product.rental.entity.Session;

public interface SessionDao {

    List<Reservation> getUpcomingTrips(String sessionId, String userId);

    void updateZip(String sessionId, String zipcode) throws IOException;

    Session findBySessionId(String sessionId);

    void updateReservation(String sessionId, Reservation reservation) throws IOException;
}
