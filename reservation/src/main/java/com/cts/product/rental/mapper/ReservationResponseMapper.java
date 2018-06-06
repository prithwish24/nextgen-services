package com.cts.product.rental.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.cts.product.rental.RentalConstants;
import com.cts.product.rental.bo.Context;
import com.cts.product.rental.bo.Duration;
import com.cts.product.rental.bo.FollowupEvent;
import com.cts.product.rental.bo.Location;
import com.cts.product.rental.bo.Parameters;
import com.cts.product.rental.bo.Reservation;
import com.cts.product.rental.bo.ReservationRequest;
import com.cts.product.rental.bo.ReservationResponse;

public class ReservationResponseMapper {

    public static ReservationResponse mapReservation(ReservationRequest reservationRequest, Reservation reservation) {

	ReservationResponse reservationResponse = new ReservationResponse();
	List<Context> contextOut = reservationRequest.getResult().getContexts().stream()
		.filter(context -> StringUtils.equals("carrental", context.getName())).collect(Collectors.toList());
	if (reservation != null) {
	    Parameters parameters = contextOut.get(0).getParameters();
	    parameters = calculateTotalVehicalPrice(parameters);
	    parameters.setConfirmationNumber(reservation.getConfNum());
	    contextOut.get(0).setParameters(parameters);
	    String speechText = "Your booking is confirmed";
	    reservationResponse.setSpeech(speechText);
	    reservationResponse.setDisplayText(speechText);
	} else {
	    FollowupEvent followupEvent = new FollowupEvent();
	    followupEvent.setName("error_reservation");
	    reservationResponse.setFollowupEvent(followupEvent);
	}
	reservationResponse.setContextOut(contextOut);
	return reservationResponse;
    }

    public static ReservationResponse mapReviewReservation(ReservationRequest reservationRequest) {

	ReservationResponse reservationResponse = new ReservationResponse();
	List<Context> contextOut = reservationRequest.getResult().getContexts().stream()
		.filter(context -> StringUtils.equals("carrental", context.getName())).collect(Collectors.toList());
	Parameters parameters = contextOut.get(0).getParameters();
	parameters = calculateTotalVehicalPrice(parameters);
	contextOut.get(0).setParameters(parameters);
	String speechText = "Could you please review and confirmed?";
	reservationResponse.setSpeech(speechText);
	reservationResponse.setDisplayText(speechText);
	reservationResponse.setContextOut(contextOut);
	return reservationResponse;
    }

    private static Parameters calculateTotalVehicalPrice(Parameters parameters) {
	String cartype = parameters.getCartype();
	double totalVehicalPrice = 0;
	if (StringUtils.equalsIgnoreCase(RentalConstants.STANDARD, cartype)) {
	    totalVehicalPrice = calculateTotalVehicalPrice(parameters, RentalConstants.STANDARD_CAR_PRICE_PER_DAY);
	} else if (StringUtils.equalsIgnoreCase(RentalConstants.ECONOMY, cartype)) {
	    totalVehicalPrice = calculateTotalVehicalPrice(parameters, RentalConstants.ECONOMY_CAR_PRICE_PER_DAY);
	} else if (StringUtils.equalsIgnoreCase(RentalConstants.COMPACT, cartype)) {
	    totalVehicalPrice = calculateTotalVehicalPrice(parameters, RentalConstants.COMPACT_CAR_PRICE_PER_DAY);
	} else if (StringUtils.equalsIgnoreCase(RentalConstants.INTERMEDIATE, cartype)) {
	    totalVehicalPrice = calculateTotalVehicalPrice(parameters, RentalConstants.INTERMEDIATE_CAR_PRICE_PER_DAY);
	} else {
	    totalVehicalPrice = calculateTotalVehicalPrice(parameters, RentalConstants.STANDARD_CAR_PRICE_PER_DAY);
	}
	double totalPrice = (totalVehicalPrice + ((totalVehicalPrice * RentalConstants.SERVICE_TAX) / 100));
	parameters.setTotalVehicalPrice(Double.toString(totalVehicalPrice));
	parameters.setTotalPrice(Double.toString(totalPrice));
	parameters.setTaxFees(Double.toString(RentalConstants.SERVICE_TAX));
	return parameters;
    }

    private static double calculateTotalVehicalPrice(Parameters parameters, double price) {
	Duration duration = parameters.getDuration();
	Integer amount = duration.getAmount();
	String unit = duration.getUnit();
	double totalVehicalPrice = 0;
	if (StringUtils.equalsIgnoreCase(RentalConstants.DAY, unit)) {
	    totalVehicalPrice = price * amount;
	} else if (StringUtils.equalsIgnoreCase(RentalConstants.WEEK, unit)) {
	    totalVehicalPrice = price * amount * 7;
	}
	return totalVehicalPrice;
    }

    public static ReservationResponse mapLocation(ReservationRequest reservationRequest, Location location) {

	ReservationResponse reservationResponse = new ReservationResponse();
	List<Context> contextOut = reservationRequest.getResult().getContexts().stream()
		.filter(context -> StringUtils.equals("carrental", context.getName())).collect(Collectors.toList());
	if (location != null) {
	    contextOut.get(0).getParameters().setPickuplocation(location.getAddress());
	    String speechText = "What type of car do you want?";
	    reservationResponse.setSpeech(speechText);
	    reservationResponse.setDisplayText(speechText);
	} else {
	    FollowupEvent followupEvent = new FollowupEvent();
	    followupEvent.setName("error_location");
	    reservationResponse.setFollowupEvent(followupEvent);
	}
	reservationResponse.setContextOut(contextOut);
	return reservationResponse;
    }
}
