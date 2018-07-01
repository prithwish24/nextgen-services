package com.cts.product.rental.mapper;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.product.rental.RentalConstants;
import com.cts.product.rental.bo.Context;
import com.cts.product.rental.bo.Duration;
import com.cts.product.rental.bo.FollowupEvent;
import com.cts.product.rental.bo.Fulfillment;
import com.cts.product.rental.bo.Location;
import com.cts.product.rental.bo.Parameters;
import com.cts.product.rental.bo.Reservation;
import com.cts.product.rental.bo.ReservationRequest;
import com.cts.product.rental.bo.ReservationResponse;
import com.cts.product.rental.google.ai.bo.ResponseMessage;

public class ReservationResponseMapper {
	private static final Logger LOG = LoggerFactory.getLogger(ReservationResponseMapper.class);

	private static final DecimalFormat DF = new DecimalFormat("###.##");
	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
	
	static {
		DF.setRoundingMode(RoundingMode.UP);
	}
	
	/*
	 * ---------- AI Action Mappings----------- 
	 */
	
	public static ReservationResponse mapRentOfficeCallback(ReservationRequest reservationRequest) {
		LOG.debug("Inside mapRentOfficeCallback() ");
		final ReservationResponse response = new ReservationResponse();
		/*final StringBuilder speechText = new StringBuilder();
		
		reservationRequest.getResult().getContexts().stream()
			.filter  (context -> "carrental".equals(context.getName()))
			.forEach (context -> {
				if (StringUtils.equalsIgnoreCase(
						context.getParameters().getCartype(), 
						context.getParameters().getCarpref())) {
					
					speechText.append("Okey. Would you like to pick up your car from the nearest rent office?");
					
				} else {
					speechText.append("OK. I choose a ")
						.append(context.getParameters().getCartype())
						.append(" car for you. ")
						.append("Would you like to take this car from your nearest rent office?");
				}
			});
		response.setSpeech(speechText.toString());
		response.setDisplayText(speechText.toString());*/
		//reservationRequest.getResult().setFulfillment(fulfillment);
		
		String responseSpeech = reservationRequest.getResult().getFulfillment().getSpeech();
		response.setSpeech(responseSpeech);
		response.setDisplayText(responseSpeech);
		response.setSource("RentOfficeCallback mapping");
		
		
		final Fulfillment responseFulfilment = new Fulfillment();
		responseFulfilment.setSpeech(reservationRequest.getResult().getFulfillment().getSpeech());
		response.setFulfilment(responseFulfilment);
		
		LOG.debug("fulfilment : "+ reservationRequest.getResult().getFulfillment().toString());
		
		List<Context> contextOut = reservationRequest.getResult().getContexts().parallelStream()
			.filter(context -> "carrental".equals(context.getName()) || "awaiting-rentoffice".equals(context.getName()))
			.collect(Collectors.toList());
		response.setContextOut(contextOut);
		
		FollowupEvent followupEvent = new FollowupEvent();
		followupEvent.setName("query_location");
		response.setFollowupEvent(followupEvent);
		return response;
	}
	
	public static ReservationResponse mapLocationCallback(ReservationRequest reservationRequest) {
		LOG.debug("Inside mapLocationCallback() ");
		ReservationResponse response = new ReservationResponse();
		List<Context> contextOut = reservationRequest.getResult().getContexts().parallelStream()
			.filter(context -> "carrental".equals(context.getName()) || "awaiting-landmark".equals(context.getName()))
			.collect(Collectors.toList());
		response.setContextOut(contextOut);
		
		String speechText = "Please tell me your pickup location or some nearest landmark?";
		response.setSpeech(speechText);
		response.setDisplayText(speechText);
		
		FollowupEvent followupEvent = new FollowupEvent();
		followupEvent.setName("ask_location");
		response.setFollowupEvent(followupEvent);
		
		return response;
	}
	
	public static ReservationResponse mapLocation(ReservationRequest reservationRequest, Location location) {
		ReservationResponse response = new ReservationResponse();
		List<Context> contextOut = reservationRequest.getResult().getContexts().stream()
				.filter(context -> StringUtils.equals("carrental", context.getName())).collect(Collectors.toList());
		if (location != null) {
			contextOut.get(0).getParameters().setPickuplocation(location.getAddress());
		
			FollowupEvent followupEvent = new FollowupEvent();
			followupEvent.setName("location_found");
			response.setFollowupEvent(followupEvent);			
			
			String speechText = "Great. Thank you. I'm reserving a "
					+ contextOut.get(0).getParameters().getCartype() 
					+ " car for you for "
					+ getPickupDateAsSpeech(contextOut.get(0).getParameters().getPickupdate())
					+ " for " + contextOut.get(0).getParameters().getDuration().toString()
					+ ". Shall I confirm this booking?";
			response.setSpeech(speechText);
			response.setDisplayText(speechText);

		} else {
			FollowupEvent followupEvent = new FollowupEvent();
			followupEvent.setName("error_location");
			response.setFollowupEvent(followupEvent);
		}
		response.setContextOut(contextOut);
		return response;
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

	private static String getPickupDateAsSpeech(String pickupdate) {
		StringBuilder sb = new StringBuilder();
		try {
			Date date = SDF.parse(pickupdate);
			Calendar cal = GregorianCalendar.getInstance();
			cal.setTime(date);
			int day = cal.get(Calendar.DAY_OF_MONTH);
			
			sb.append(cal.get(Calendar.MONTH))
				.append(" ").append(day).append(ordinalNo(day));
			
		} catch (ParseException e) {
			LOG.error("Error parsing date - "+pickupdate, e);
		}
		return null;
	}
	
	private static String ordinalNo(int value) {
		int hunRem = value % 100;
		int tenRem = value % 10;
		if (hunRem - tenRem == 10) {
			return "th";
		}
		switch (tenRem) {
		case 1:
			return "st";
		case 2:
			return "nd";
		case 3:
			return "rd";
		default:
			return "th";
		}
	}

}
