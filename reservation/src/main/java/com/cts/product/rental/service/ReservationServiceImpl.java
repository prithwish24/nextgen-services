package com.cts.product.rental.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.cts.product.rental.bo.Reservation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ReservationServiceImpl implements ReservationService {

	public Reservation createReservation() {
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
			reservationList = mapper.readValue(new File("src/main/resources/data.json"), typeReference);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reservationList;
	}
}
