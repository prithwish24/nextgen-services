package com.cts.product.addon.fuel.rest.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.cts.product.addon.fuel.model.FuelStationResponse;

@Service
public class NearbyFuelStationServiceImpl implements NearbyFuelStationService {

	@Override
	@Cacheable(value = "nearbyFuel", key = "#city")
	public FuelStationResponse getNearbyFuelStations(String city) {
		final String q = "api_key=DEMO_KEY&location=" + city;
		final String uri = "https://developer.nrel.gov/api/alt-fuel-stations/v1/nearest.json?";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri).queryParam("q", q).queryParam("format",
				"json");
		RestTemplate restTemplate = new RestTemplate();
		FuelStationResponse result = restTemplate.getForObject(uri + q, FuelStationResponse.class);

		return result;
	}

	public static void main(String[] args) {
		System.out.println(new NearbyFuelStationServiceImpl().getNearbyFuelStations("St. Louis"));
	}
}
