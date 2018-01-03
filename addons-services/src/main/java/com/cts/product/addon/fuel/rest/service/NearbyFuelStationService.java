package com.cts.product.addon.fuel.rest.service;

import com.cts.product.addon.fuel.model.FuelStationResponse;

public interface NearbyFuelStationService {
	FuelStationResponse getNearbyFuelStations(String city);
}
