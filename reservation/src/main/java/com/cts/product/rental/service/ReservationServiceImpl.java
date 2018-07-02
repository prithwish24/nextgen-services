package com.cts.product.rental.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.cts.product.rental.bo.Context;
import com.cts.product.rental.bo.Location;
import com.cts.product.rental.bo.Parameters;
import com.cts.product.rental.bo.Reservation;
import com.cts.product.rental.bo.ReservationRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ReservationServiceImpl implements ReservationService {
	private static final Logger LOG = LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	@Autowired
	private SessionService sessionService;
	String sessionId;

	@Override
	public ReservationRequest reviewReservation(ReservationRequest reservationRequest) throws IOException {
		reservationRequest.getResult().getContexts().stream()
				.filter(context -> StringUtils.equals("carrental", context.getName())).forEach(context -> {
					sessionId = context.getParameters().getSessionId();
				});
		if (sessionService.findBySessionId(sessionId) == null) {
			throw new RuntimeException("Invalid user session!"); 
		}
		return reservationRequest;
	}

	@Override
	public Reservation createReservation(ReservationRequest reservationRequest) throws IOException {
		reservationRequest.getResult().getContexts().stream()
				.filter(context -> StringUtils.equals("carrental", context.getName())).forEach(context -> {
					sessionId = context.getParameters().getSessionId();
				});
		if (sessionService.findBySessionId(sessionId) == null) {
			throw new RuntimeException("Invalid user session!"); 
		}
		List<Context> contextOut = reservationRequest.getResult().getContexts().stream()
				.filter(context -> StringUtils.equals("carrental", context.getName())).collect(Collectors.toList());
		Parameters parameters = contextOut.get(0).getParameters();
		List<Reservation> reservationList = getAllReservations();
		int nextInt = new Random().nextInt(3);
		Reservation reservation = reservationList.get(nextInt);
		reservation.setConfNum(RandomStringUtils.randomNumeric(9));
		reservation.setVehicleRentPrice(parameters.getVehicleRentPrice());
		reservation.setConsessionFee(parameters.getConsessionFee());
		reservation.setSalesTax(parameters.getSalesTax());
		reservation.setEstimatedTotal(parameters.getEstimatedTotal());
		reservation.setCarType(parameters.getCartype());
		return reservation;
	}

	private List<Reservation> getAllReservations() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Reservation>> typeReference = new TypeReference<List<Reservation>>() {

		};
		List<Reservation> reservationList = null;
		try {
			reservationList = mapper.readValue(new ClassPathResource("reservation.json").getInputStream(),
					typeReference);
		} catch (IOException e) {
			LOG.error("Error fetching reservation details", e);
		}
		return reservationList;
	}

	@Override
	public Location updateSessionWithZipcode(String sessionId, String zipcode) throws IOException {
		sessionService.updateSessionWithZipcode(sessionId, zipcode);
		Location location = new Location();
		location.setZipcode(zipcode);
		return location;
	}

	@Override
	public List<Reservation> getUpcomingTrips(String sessionId, String username, String count) throws ParseException {
		return sessionService.getUpcomingTrips(sessionId, username, count);
	}

	@Override
	public List<Reservation> getAllRentals(String username) throws ParseException {
		return sessionService.getAllRentals(username);
	}

	@Override
	public void removeAllRentals(String username) {
		sessionService.removeAllRentals(username);
	}
}
