package com.cts.product.rental.service;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.cts.product.rental.bo.Location;
import com.cts.product.rental.bo.Reservation;
import com.cts.product.rental.bo.ReservationRequest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private SessionService sessionService;

	public Reservation createReservation(ReservationRequest reservationRequest) {
		List<Reservation> reservationList = getAllReservations();
		int nextInt = new Random().nextInt(3);
		Reservation reservation = reservationList.get(nextInt);
		return reservation;
	}

	public List<Reservation> getAllReservations() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Reservation>> typeReference = new TypeReference<List<Reservation>>() {

		};
		List<Reservation> reservationList = null;
		try {
			reservationList = mapper.readValue(new ClassPathResource("reservation.json").getInputStream(),
					typeReference);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reservationList;
	}

	@Override
	public Location updateSessionWithZipcode(String sessionId, String zipcode) {
		return sessionService.updateSessionWithZipcode(sessionId, zipcode);
	}
}
