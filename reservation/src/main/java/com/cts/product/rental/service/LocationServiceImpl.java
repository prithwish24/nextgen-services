package com.cts.product.rental.service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.cts.product.rental.bo.Location;
import com.cts.product.rental.entity.Session;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class LocationServiceImpl implements LocationService {
	private static final Logger LOG = LoggerFactory.getLogger(LocationServiceImpl.class);

	@Autowired
	private SessionService sessionService;

	@Override
	public Location getLocation(Location locationRequest) throws IOException {
		Location location = null;
		String zipcode = null;
		String businessName = null;
		String city = null;
		List<Location> locationList = getAllLocations();
		boolean pickupFromNearestLocation = locationRequest.isPickupFromNearestLocation();
		LOG.debug("pickupFromNearestLocation: "+pickupFromNearestLocation);
		if (pickupFromNearestLocation) {
			Session findBySessionId = sessionService.findBySessionId(locationRequest.getSessionId());
			if (findBySessionId == null) {
				return null;
			}
			zipcode = findBySessionId.getZipcode();
		} else {
			zipcode = locationRequest.getZipcode();
			businessName = locationRequest.getBusinessName();
			city = StringUtils.isNotBlank(locationRequest.getCity())?
						locationRequest.getCity():locationRequest.getAddress();
			
		}

		String finalZipcode = zipcode;
		String finalBusinessName = businessName;
		String finalCity = city;
		LOG.debug("finalZipcode: "+finalZipcode);
		LOG.debug("finalBusinessName: "+finalBusinessName);
		LOG.debug("finalCity: "+finalCity);
		try {
			location = locationList.stream()
					.filter(loc -> ((StringUtils.isNotBlank(finalZipcode) && StringUtils.equals(loc.getZipcode(), finalZipcode)
							|| (StringUtils.isNotBlank(finalBusinessName) && StringUtils.isNotBlank(finalCity)
									&& StringUtils.equalsIgnoreCase(loc.getBusinessName(), finalBusinessName)
									&& StringUtils.equalsIgnoreCase(loc.getCity(), finalCity)))))
					.findFirst().get();
		} catch (NoSuchElementException e) {
			LOG.error("NoSuchElementException: "+e.getMessage());
		}
		return location;
	}

	public List<Location> getAllLocations() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Location>> typeReference = new TypeReference<List<Location>>() {

		};
		List<Location> locationList = null;
		try {
			locationList = mapper.readValue(new ClassPathResource("location.json").getInputStream(), typeReference);
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
