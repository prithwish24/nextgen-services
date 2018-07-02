package com.cts.product.rental.mapper;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.cts.product.rental.bo.Context;
import com.cts.product.rental.bo.Location;
import com.cts.product.rental.bo.ReservationRequest;

public class LocationRequestMapper {

	public static Location map(ReservationRequest reservationRequest) {
		final Location locationRequest = new Location();
		List<Context> contexts = reservationRequest.getResult().getContexts();
		contexts.stream().filter(context -> StringUtils.equals("carrental", context.getName())).forEach(context -> {
			locationRequest.setPickupFromNearestLocation(context.getParameters().isPickupFromNearestLocation());
			locationRequest.setSessionId(context.getParameters().getSessionId());
			if (StringUtils.isNotBlank(context.getParameters().getPickupCity())) {
				locationRequest.setCity(context.getParameters().getPickupCity());
			}
			else if (context.getParameters().getLandmark() != null) {
				locationRequest.setBusinessName(context.getParameters().getLandmark().getBusinessName());
				locationRequest.setCity(context.getParameters().getLandmark().getCity());
				locationRequest.setAddress(context.getParameters().getLandmark().getStreetAddress());
			}
		});
		return locationRequest;
	}
}
