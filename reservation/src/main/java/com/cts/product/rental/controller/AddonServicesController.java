package com.cts.product.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.product.rental.addon.fuel.model.FuelStationResponse;
import com.cts.product.rental.addon.fuel.rest.service.NearbyFuelStationService;
import com.cts.product.rental.addon.weather.model.WeatherResponse;
import com.cts.product.rental.addon.weather.rest.service.WeatherService;
import com.cts.product.rental.bo.BaseResponse;

@RestController
@RequestMapping("/")
@ComponentScan(basePackages = { "com.cts.product.rental" })
public class AddonServicesController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private NearbyFuelStationService nearbyFuelStationService;

    @RequestMapping(value = "/weather/{sessionId}", method = {
	    RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse<WeatherResponse> getWeatherReport(@PathVariable String sessionId,
	    @RequestParam(value = "city") String city) {
	BaseResponse<WeatherResponse> bp = new BaseResponse<>();
	if (StringUtils.isEmpty(city)) {
	    bp.setServiceError("2001", "ERROR", "City is required");
	} else {
	    try {
		bp.setSuccess(true);
		bp.setResponse(weatherService.getWeatherReport(city, sessionId));
	    } catch (Exception ex) {
		bp.setServiceError("2001", "ERROR", "Invalid session Id");
	    }
	}
	return bp;
    }

    @RequestMapping(value = "/nearbyFuelStations/{sessionId}", method = {
	    RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse<FuelStationResponse> getNearbyFuelStations(@PathVariable String sessionId,
	    @RequestParam(value = "city") String city) {
	BaseResponse<FuelStationResponse> bp = new BaseResponse<>();
	if (StringUtils.isEmpty(city)) {
	    bp.setServiceError("2001", "ERROR", "City is required");
	} else {
	    try {
		bp.setSuccess(true);
		bp.setResponse(nearbyFuelStationService.getNearbyFuelStations(city, sessionId));
	    } catch (Exception ex) {
		bp.setServiceError("2001", "ERROR", "Invalid session Id");
	    }
	}
	return bp;
    }

}
