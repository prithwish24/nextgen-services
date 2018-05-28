package com.cts.product.rental.addon.fuel.rest.service;

import java.io.IOException;

import com.cts.product.rental.addon.fuel.model.FuelStationResponse;

public interface NearbyFuelStationService {
    FuelStationResponse getNearbyFuelStations(String location, String sessionId) throws IOException;
}
