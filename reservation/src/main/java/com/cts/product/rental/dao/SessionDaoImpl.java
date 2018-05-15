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
    public List<Reservation> getUpcomingTrips(String sessionId, String userId) {
	Session session = new Session();
	session.setSessionId(sessionId);
	session.setUserId(userId);
	TypedQuery<Session> createNamedQuery = entityManager.createQuery("from Session where user_id='" + userId + "'",
		Session.class);
	List<Session> sessionResults = createNamedQuery.getResultList();
	List<Reservation> reservations = new ArrayList<Reservation>();
	boolean isNewSession = true;
	if (sessionResults != null && !sessionResults.isEmpty()) {
	    for (Session sessionResult : sessionResults) {
		List<ReservationSession> reservationSessions = sessionResult.getReservations();
		for (ReservationSession reservationSession : reservationSessions) {
		    reservations.add(populateReservation(reservationSession));
		}
		if (sessionResult.getSessionId().equals(sessionId)) {
		    isNewSession = false;
		}
	    }
	}
	if (isNewSession) {
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
	reservationSession.setCarType(reservation.getCarType());
	reservationSession.setSession(session);
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
	session.getReservations().add(populateReservationSession(session, reservation));
	entityManager.merge(session);
    }

}
