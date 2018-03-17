package com.cts.product.rental.service;

import java.io.IOException;

import com.cts.product.rental.bo.ReservationRequest;

public interface SessionService {

    String createSession(ReservationRequest reservationRequest);

    void updateSessionWithZipcode(String sessionId, String zipcode) throws IOException;

    String findBySessionId(String requestSessionId);
}
