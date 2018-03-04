package com.cts.product.rental.service;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.cts.product.rental.bo.Location;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class LocationServiceImpl implements LocationService {

	@Override
	public Location getLocation() {
		List<Location> locationList = getAllLocations();
		int nextInt = new Random().nextInt(3);
		Location location = locationList.get(nextInt);
		return location;
	}

	public List<Location> getAllLocations() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Location>> typeReference = new TypeReference<List<Location>>() {

		};
		List<Location> locationList = null;
		try {
			locationList = mapper.readValue(
					new ClassPathResource("location.json").getInputStream(),
					typeReference);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return locationList;
	}

}
