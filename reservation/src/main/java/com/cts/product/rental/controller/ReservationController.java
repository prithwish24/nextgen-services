package com.cts.product.rental.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.product.rental.bo.Location;
import com.cts.product.rental.bo.Reservation;
import com.cts.product.rental.bo.ReservationRequest;
import com.cts.product.rental.bo.ReservationResponse;
import com.cts.product.rental.delegate.ReservationServiceDelegate;
import com.cts.product.rental.google.ai.bo.Fulfillment;
import com.cts.product.rental.service.LocationService;
import com.cts.product.rental.service.ReservationService;

@RestController
@RequestMapping("/")
@ComponentScan(basePackages = { "com.cts.product.rental" })
public class ReservationController {
	private static final Logger LOG = LoggerFactory.getLogger(ReservationController.class);

	@Autowired
	private ReservationService reservationService;
	@Autowired
	private ReservationServiceDelegate reservationServiceDelegate;
	@Autowired
	private LocationService locationService;
	// @Autowired
	// private ReservationTransformer transformer;

	@RequestMapping(value = "/lfs", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	public Fulfillment lowFareSearch() {

		return new Fulfillment();
	}

	// @HystrixCommand(fallbackMethod = "create_fallback")
	@RequestMapping(value = "/rental", method = { RequestMethod.POST,
			RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ReservationResponse aiCall(@RequestBody ReservationRequest reservationRequest) throws IOException {
		LOG.debug("Entered into reservation service");
		ReservationResponse reservationResponse = reservationServiceDelegate.delegate(reservationRequest);
		LOG.debug("Exiting from reservation service");
		return reservationResponse;
	}

	// @HystrixCommand(fallbackMethod = "create_fallback")
	@RequestMapping(value = "/zipcode/{sessionId}", method = { RequestMethod.POST,
			RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	public Location updateSessionWithZipcode(@PathVariable String sessionId, @RequestParam String zipcode)
			throws IOException {
		LOG.debug("Entered into update Session With Zipcode service");
		Location locationResponse = reservationService.updateSessionWithZipcode(sessionId, zipcode);
		LOG.debug("Exiting from update Session With Zipcode service");
		return locationResponse;
	}

	// @HystrixCommand(fallbackMethod = "create_fallback")
	@RequestMapping(value = "/create", method = { RequestMethod.POST,
			RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reservation create(@RequestBody ReservationRequest reservationRequest) {
		LOG.debug("Entered into create reservation service");
		Reservation reservation = reservationService.createReservation(reservationRequest);
		LOG.debug("Exiting from create reservation service");
		return reservation;
	}

	// @HystrixCommand(fallbackMethod = "create_fallback")
	@RequestMapping(value = "/location", method = { RequestMethod.POST,
			RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	public Location getLocation(@RequestBody Location locationRequest) throws IOException {
		LOG.debug("Entered into get location service");
		Location locationResponse = locationService.getLocation(locationRequest);
		LOG.debug("Exiting from get location service");
		return locationResponse;
	}

	public Fulfillment create_fallback() {
		return null;
	}

}
