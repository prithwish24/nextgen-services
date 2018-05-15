package com.cts.product.rental.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cts.product.rental.bo.Reservation;
import com.cts.product.rental.entity.ReservationSession;
import com.cts.product.rental.entity.Session;

@Repository
public class SessionDaoImpl implements SessionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Reservation> getUpcomingTrips(String sessionId, String username) {
	Session session = new Session();
	session.setSessionId(sessionId);
	session.setUsername(username);
	TypedQuery<ReservationSession> createNamedQuery = entityManager
		.createQuery("from ReservationSession where username='" + username + "'", ReservationSession.class);
	List<ReservationSession> reservationSessions = createNamedQuery.getResultList();
	List<Reservation> reservations = new ArrayList<Reservation>();
	if (reservationSessions != null && !reservationSessions.isEmpty()) {
	    for (ReservationSession reservationSession : reservationSessions) {
		reservations.add(populateReservation(reservationSession));
	    }
	}
	Session sessionResult = findBySessionId(sessionId);
	if (sessionResult == null) {
	    entityManager.persist(session);
	}
	return reservations;
    }

    private ReservationSession populateReservationSession(Session session, Reservation reservation) {
	ReservationSession reservationSession = new ReservationSession();
	reservationSession.setId(reservation.getId());
	reservationSession.setPickupPoint(reservation.getPickupPoint());
	reservationSession.setDropPoint(reservation.getDropPoint());
	reservationSession.setPickupDateTime(reservation.getPickupDateTime());
	reservationSession.setDropoffDateTime(reservation.getDropoffDateTime());
	reservationSession.setUsername(session.getUsername());
	reservationSession.setCarType(reservation.getCarType());
	return reservationSession;
    }

    private Reservation populateReservation(ReservationSession reservationSession) {
	Reservation reservation = new Reservation();
	reservation.setId(reservationSession.getId());
	reservation.setPickupPoint(reservationSession.getPickupPoint());
	reservation.setDropPoint(reservationSession.getDropPoint());
	reservation.setPickupDateTime(reservationSession.getPickupDateTime());
	reservation.setDropoffDateTime(reservationSession.getDropoffDateTime());
	reservation.setCarType(reservationSession.getCarType());
	return reservation;
    }

    @Override
    public void updateZip(String sessionId, String zipcode) throws IOException {

	Session session = findBySessionId(sessionId);
	if (session == null) {
	    throw new IOException("Invalid session Id");
	}
	session.setZipcode(zipcode);
	entityManager.merge(session);
    }

    @Override
    public Session findBySessionId(String sessionId) {
	return entityManager.find(Session.class, sessionId);
    }

    @Override
    public void updateReservation(String sessionId, Reservation reservation) throws IOException {

	Session session = findBySessionId(sessionId);
	if (session == null) {
	    throw new IOException("Invalid session Id");
	}
	ReservationSession populateReservationSession = populateReservationSession(session, reservation);
	entityManager.persist(populateReservationSession);
    }

    @Override
    public void clearSession(String sessionId) {
	Session session = findBySessionId(sessionId);
	entityManager.remove(session);
    }

}
