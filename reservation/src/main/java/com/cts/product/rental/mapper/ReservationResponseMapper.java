package com.cts.product.rental.mapper;

import java.math.RoundingMode;
import java.text.DecimalFormat;
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

	private static final DecimalFormat DF = new DecimalFormat("###.##");
	
	static {
		DF.setRoundingMode(RoundingMode.UP);
	}
	
	public static ReservationResponse mapReservation(ReservationRequest reservationRequest, Reservation reservation) {

		ReservationResponse reservationResponse = new ReservationResponse();
		List<Context> contextOut = reservationRequest.getResult().getContexts().stream()
				.filter(context -> StringUtils.equals("carrental", context.getName())).collect(Collectors.toList());
		if (reservation != null) {
			Parameters parameters = contextOut.get(0).getParameters();
			parameters = calculateTotalVehicalPrice(parameters);
			parameters.setConfirmationNumber(reservation.getConfNum());
			contextOut.get(0).setParameters(parameters);
			String speechText = "Your reservation is confirmed. Thank you for using our service.";
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
		String speechText = "Great. Thank you. I have reserved a "
				+ parameters.getCartype()
				+ " car for you for "
				+ parameters.getPickupdate()
				+ ". Shall I confirm this booking?";
		reservationResponse.setSpeech(speechText);
		reservationResponse.setDisplayText(speechText);
		reservationResponse.setContextOut(contextOut);
		return reservationResponse;
	}

	private static Parameters calculateTotalVehicalPrice(Parameters parameters) {
		final String cartype = parameters.getCartype();
		final Duration duration = parameters.getDuration();
		double vehicleRentPrice = 0;
		
		if (StringUtils.equalsIgnoreCase(RentalConstants.ECONOMY, cartype)) {
			vehicleRentPrice = calculateTotalVehicalPrice(duration, RentalConstants.ECONOMY_CAR_PRICE_PER_DAY);
		} else if (StringUtils.equalsIgnoreCase(RentalConstants.COMPACT, cartype)) {
			vehicleRentPrice = calculateTotalVehicalPrice(duration, RentalConstants.COMPACT_CAR_PRICE_PER_DAY);
		} else if (StringUtils.equalsIgnoreCase(RentalConstants.INTERMEDIATE, cartype)) {
			vehicleRentPrice = calculateTotalVehicalPrice(duration, RentalConstants.INTERMEDIATE_CAR_PRICE_PER_DAY);
		} else if (StringUtils.equalsIgnoreCase(RentalConstants.STANDARD, cartype)) {
			vehicleRentPrice = calculateTotalVehicalPrice(duration, RentalConstants.STANDARD_CAR_PRICE_PER_DAY);
		} else if (StringUtils.equalsIgnoreCase(RentalConstants.FULLSIZE, cartype)) {
			vehicleRentPrice = calculateTotalVehicalPrice(duration, RentalConstants.FULLSIZE_CAR_PRICE_PER_DAY);
		} else if (StringUtils.equalsIgnoreCase(RentalConstants.PREMIUM, cartype)) {
			vehicleRentPrice = calculateTotalVehicalPrice(duration, RentalConstants.PREMIUM_CAR_PRICE_PER_DAY);
		} else if (StringUtils.equalsIgnoreCase(RentalConstants.LUXURY, cartype)) {
			vehicleRentPrice = calculateTotalVehicalPrice(duration, RentalConstants.LUXURY_CAR_PRICE_PER_DAY);
		} else {
			vehicleRentPrice = calculateTotalVehicalPrice(duration, RentalConstants.STANDARD_CAR_PRICE_PER_DAY);
		}
		
		double consessionFee = vehicleRentPrice * RentalConstants.CONCESSIONFEE; 
		double salesTax = vehicleRentPrice * RentalConstants.SALES_TAX;
		double estimatedTotal = vehicleRentPrice + consessionFee + RentalConstants.VEHICLE_LICENSE_RECVRY_FEE + salesTax;
		
		parameters.setVehicleRentPrice(DF.format(vehicleRentPrice));
		parameters.setConsessionFee(DF.format(consessionFee));
		parameters.setEstimatedTotal(DF.format(estimatedTotal));
		parameters.setSalesTax(DF.format(salesTax));		
		return parameters;
	}

	private static double calculateTotalVehicalPrice(Duration duration, double price) {
		Integer amount = duration.getAmount();
		String unit = duration.getUnit();
		double rentPrice = 0;
		if (StringUtils.equalsIgnoreCase(RentalConstants.DAY, unit)) {
			rentPrice = price * amount;
		} else if (StringUtils.equalsIgnoreCase(RentalConstants.WEEK, unit)) {
			rentPrice = price * amount * 7;
		}
		return rentPrice;
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
