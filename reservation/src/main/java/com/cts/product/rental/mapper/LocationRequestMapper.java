package com.cts.product.rental.mapper;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.cts.product.rental.bo.Context;
import com.cts.product.rental.bo.Location;
import com.cts.product.rental.bo.ReservationRequest;

public class LocationRequestMapper {

	public static Location map(ReservationRequest reservationRequest) {
		Location locationRequest = new Location();
		List<Context> contexts = reservationRequest.getResult().getContexts();
		contexts.stream().filter(context -> StringUtils.equals("carrental", context.getName())).forEach(context -> {
			locationRequest.setPickupFromNearestLocation(context.getParameters().isPickupFromNearestLocation());
			locationRequest.setSessionId(context.getParameters().getSessionId());
			locationRequest.setBusinessName(context.getParameters().getLandmark().getBusinessName());
			locationRequest.setCity(context.getParameters().getLandmark().getCity());
		});
		return locationRequest;
	}
}
