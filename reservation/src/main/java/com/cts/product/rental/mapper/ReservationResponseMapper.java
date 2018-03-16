package com.cts.product.rental.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.cts.product.rental.bo.Context;
import com.cts.product.rental.bo.Data;
import com.cts.product.rental.bo.FollowupEvent;
import com.cts.product.rental.bo.Location;
import com.cts.product.rental.bo.Reservation;
import com.cts.product.rental.bo.ReservationRequest;
import com.cts.product.rental.bo.ReservationResponse;

public class ReservationResponseMapper {

	public static ReservationResponse mapReservation(Reservation reservation) {

		ReservationResponse reservationResponse = new ReservationResponse();
		reservationResponse.setSpeech(
				"Your Booking is Confirmed and the confirmation number is #"
						+ reservation.getId());
		reservationResponse.setDisplayText(
				"Your Booking is Confirmed and the confirmation number is #"
						+ reservation.getId());
		return reservationResponse;
	}

	public static ReservationResponse mapLocation(
			ReservationRequest reservationRequest, Location location) {

		ReservationResponse reservationResponse = new ReservationResponse();
		List<Context> contextOut = new ArrayList<>();
		for (Context context : reservationRequest.getResult().getContexts()) {
			if (StringUtils.equals("carrental", context.getName())) {
				contextOut.add(context);
				break;
			}
		}
		if (location != null) {
			contextOut.get(0).getParameters()
					.setPickuplocation(location.getAddress());
		} else {
			FollowupEvent followupEvent = new FollowupEvent();
			followupEvent.setName("error_location");
			reservationResponse.setFollowupEvent(followupEvent);
		}
		reservationResponse.setContextOut(contextOut);
		return reservationResponse;
	}

	public static ReservationResponse mapSession(String sessionId) {

		ReservationResponse reservationResponse = new ReservationResponse();
		FollowupEvent followupEvent = new FollowupEvent();
		followupEvent.setName("start_reservation");
		Data data = new Data();
		data.setSessionId(sessionId);
		followupEvent.setData(data);
		reservationResponse.setFollowupEvent(followupEvent);
		return reservationResponse;
	}
}
