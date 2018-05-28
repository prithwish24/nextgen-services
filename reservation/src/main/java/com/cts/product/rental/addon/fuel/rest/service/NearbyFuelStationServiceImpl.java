package com.cts.product.rental.addon.fuel.rest.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.product.rental.addon.fuel.model.FuelStationResponse;
import com.cts.product.rental.entity.Session;
import com.cts.product.rental.service.SessionService;

@Service
public class NearbyFuelStationServiceImpl implements NearbyFuelStationService {

    @Autowired
    private SessionService sessionService;

    @Override
    @Cacheable(value = "nearbyFuelStations", key = "#location")
    public FuelStationResponse getNearbyFuelStations(String location, String sessionId) throws IOException {
	Session session = sessionService.findBySessionId(sessionId);
	if (session == null) {
	    throw new IOException("Invalid session Id");
	}
	final String q = "api_key=DEMO_KEY&location=" + location;
	final String uri = "http://developer.nrel.gov/api/alt-fuel-stations/v1/nearest.json?";
	RestTemplate restTemplate = new RestTemplate();
	FuelStationResponse result = restTemplate.getForObject(uri + q, FuelStationResponse.class);

	return result;
    }
}
