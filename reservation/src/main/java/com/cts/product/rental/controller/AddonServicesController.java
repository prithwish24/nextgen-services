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
import com.cts.product.rental.addon.weather.model.WeatherForecast;
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
    public BaseResponse<WeatherForecast> getWeatherReport(@PathVariable String sessionId,
	    @RequestParam(value = "location") String location) {
	BaseResponse<WeatherForecast> bp = new BaseResponse<>();
	if (StringUtils.isEmpty(location)) {
	    bp.setServiceError("2001", "ERROR", "Location is required");
	} else {
	    try {
		bp.setResponse(weatherService.getWeatherReport(location, sessionId));
		bp.setSuccess(true);
	    } catch (Exception ex) {
		bp.setServiceError("2001", "ERROR", "Invalid session Id");
	    }
	}
	return bp;
    }

    @RequestMapping(value = "/nearbyFuelStations/{sessionId}", method = {
	    RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse<FuelStationResponse> getNearbyFuelStations(@PathVariable String sessionId,
	    @RequestParam(value = "location") String location) {
	BaseResponse<FuelStationResponse> bp = new BaseResponse<>();
	if (StringUtils.isEmpty(location)) {
	    bp.setServiceError("2001", "ERROR", "Location is required");
	} else {
	    try {
		bp.setSuccess(true);
		bp.setResponse(nearbyFuelStationService.getNearbyFuelStations(location, sessionId));
	    } catch (Exception ex) {
		bp.setServiceError("2001", "ERROR", "Invalid session Id");
	    }
	}
	return bp;
    }

}
