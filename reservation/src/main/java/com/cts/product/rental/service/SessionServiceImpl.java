package com.cts.product.rental.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cts.product.rental.bo.Reservation;
import com.cts.product.rental.dao.SessionDao;
import com.cts.product.rental.entity.Session;

@Transactional
@Component
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionDao sessionDao;

    @Override
    public List<Reservation> getUpcomingTrips(String sessionId, String username, String count) throws ParseException {
	return sessionDao.getUpcomingTrips(sessionId, username, count);
    }

    @Override
    public void updateSessionWithZipcode(String sessionId, String zipcode) throws IOException {
	sessionDao.updateZip(sessionId, zipcode);
    }

    @Override
    public Session findBySessionId(String requestSessionId) {
	Session session = sessionDao.findBySessionId(requestSessionId);
	return session;
    }

    @Override
    public void updateSessionWithReservation(String sessionId, Reservation reservation) throws IOException {
	sessionDao.updateReservation(sessionId, reservation);
    }

    @Override
    public void clearSession(String sessionId) {
	sessionDao.clearSession(sessionId);
    }

    @Override
    public List<Reservation> getAllRentals(String username) throws ParseException {
	return sessionDao.getAllRentals(username);
    }

    @Override
    public void removeAllRentals(String username) {
	sessionDao.removeAllRentals(username);
    }
}
