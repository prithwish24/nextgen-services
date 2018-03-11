package com.cts.product.rental.service;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
	public Location getLocation(Location locationRequest) {
		List<Location> locationList = getAllLocations();
		Location location = null;
		for (Location loc : locationList) {
			String zipcode = locationRequest.getZipcode();
			String businessName = locationRequest.getBusinessName();
			String city = locationRequest.getCity();
			if (StringUtils.isNotBlank(zipcode)
					&& StringUtils.equals(loc.getZipcode(), zipcode)) {
				location = loc;
				break;
			} else if (StringUtils.isNotBlank(businessName)
					&& StringUtils.isNotBlank(city)
					&& StringUtils.equalsIgnoreCase(loc.getBusinessName(),
							businessName)
					&& StringUtils.equalsIgnoreCase(loc.getCity(), city)) {
				location = loc;
				break;
			}
		}
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
