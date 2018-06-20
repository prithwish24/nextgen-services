package com.cts.product.rental.dao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cts.product.rental.bo.Reservation;
import com.cts.product.rental.entity.ReservationSession;
import com.cts.product.rental.entity.Session;

@Repository
public class SessionDaoImpl implements SessionDao {
	private static final Logger LOG = LoggerFactory.getLogger(SessionDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	private SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");

	@Override
	public List<Reservation> getUpcomingTrips(String sessionId, String username, String count) throws ParseException {
		LOG.debug("getUpcomingTrips() : sessionId- "+sessionId);
		Session session = new Session();
		session.setSessionId(sessionId);
		session.setUsername(username);
		int maxResult = 0;
		if (StringUtils.isBlank(count) || StringUtils.equals("0", count)) {
			maxResult = 1;
		} else {
			maxResult = Integer.parseInt(count);
		}
		TypedQuery<ReservationSession> createNamedQuery = entityManager.createQuery(
				"from ReservationSession where username='" + username + "' order by bookingTime desc",
				ReservationSession.class);
		List<ReservationSession> reservationSessions = createNamedQuery.setMaxResults(maxResult).getResultList();
		List<Reservation> reservations = new ArrayList<Reservation>();
		if (reservationSessions != null && !reservationSessions.isEmpty()) {
			for (ReservationSession reservationSession : reservationSessions) {
				reservations.add(populateReservation(reservationSession));
			}
		}
		Session sessionResult = findBySessionId(sessionId);
		if (sessionResult == null) {
			LOG.debug("getUpcomingTrips() : session is NEW - "+sessionId);
			entityManager.persist(session);
		}
		return reservations;
	}

	@Override
	public List<Reservation> getAllRentals(String username) throws ParseException {
		TypedQuery<ReservationSession> createNamedQuery = entityManager
				.createQuery("from ReservationSession where username='" + username + "'", ReservationSession.class);
		List<ReservationSession> reservationSessions = createNamedQuery.getResultList();
		List<Reservation> reservations = new ArrayList<Reservation>();
		if (reservationSessions != null && !reservationSessions.isEmpty()) {
			for (ReservationSession reservationSession : reservationSessions) {
				reservations.add(populateReservation(reservationSession));
			}
		}
		return reservations;
	}

	private ReservationSession populateReservationSession(Session session, Reservation reservation) {
		ReservationSession reservationSession = new ReservationSession();
		reservationSession.setId(reservation.getConfNum());
		reservationSession.setPickupPoint(reservation.getPickupLoc());
		reservationSession.setDropPoint(reservation.getReturnLoc());
		reservationSession.setPickupDateTime(sdf.format(reservation.getPickupDateTime()));
		reservationSession.setDropoffDateTime(sdf.format(reservation.getReturnDateTime()));
		reservationSession.setUsername(session.getUsername());
		reservationSession.setCarType(reservation.getCarType());
		reservationSession.setStatus(reservation.getStatus());
		reservationSession.setBookingTime(LocalDateTime.now());
		reservationSession.setVehicleRentPrice(reservation.getVehicleRentPrice());
		reservationSession.setConsessionFee(reservation.getConsessionFee());
		reservationSession.setSalesTax(reservation.getSalesTax());
		reservationSession.setEstimatedTotal(reservation.getEstimatedTotal());
		return reservationSession;
	}

	private Reservation populateReservation(ReservationSession reservationSession) throws ParseException {
		Reservation reservation = new Reservation();
		reservation.setConfNum(reservationSession.getId());
		reservation.setPickupLoc(reservationSession.getPickupPoint());
		reservation.setReturnLoc(reservationSession.getDropPoint());
		reservation.setPickupDateTime(sdf.parse(reservationSession.getPickupDateTime()));
		reservation.setReturnDateTime(sdf.parse(reservationSession.getDropoffDateTime()));
		reservation.setCarType(reservationSession.getCarType());
		reservation.setStatus(reservationSession.getStatus());
		reservation.setVehicleRentPrice(reservationSession.getVehicleRentPrice());
		reservation.setConsessionFee(reservationSession.getConsessionFee());
		reservation.setSalesTax(reservationSession.getSalesTax());
		reservation.setEstimatedTotal(reservationSession.getEstimatedTotal());
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

	@Override
	public void removeAllRentals(String username) {
		Query createQuery = entityManager
				.createQuery("DELETE from ReservationSession where username='" + username + "'");
		createQuery.executeUpdate();
	}
}
