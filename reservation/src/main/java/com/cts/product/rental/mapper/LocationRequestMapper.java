package com.cts.product.rental.mapper;

import org.apache.commons.lang3.StringUtils;

import com.cts.product.rental.bo.Context;
import com.cts.product.rental.bo.Location;
import com.cts.product.rental.bo.ReservationRequest;

public class LocationRequestMapper {

	public static Location map(ReservationRequest reservationRequest) {
		Location locationRequest = new Location();
		for (Context context : reservationRequest.getResult().getContexts()) {
			if (StringUtils.equals("carrental", context.getName())) {
				locationRequest.setBusinessName(context.getParameters()
						.getLandmark().getBusinessName());
				locationRequest.setCity(
						context.getParameters().getLandmark().getCity());
				break;
			}
		}
		return locationRequest;
	}
}
