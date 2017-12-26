package com.cts.product.addon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.product.addon.domain.WeatherResponse;
import com.cts.product.weather.rest.service.WeatherService;

@RestController
@RequestMapping("/")
@ComponentScan(basePackages = { "com.cts.product" })
public class AddonServicesController {

	@Autowired
	private WeatherService weatherService;

	@RequestMapping(value = "/weather", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	public WeatherResponse getWeatherReport(@RequestParam(value = "city") String city) {
		return weatherService.getWeatherReport(city);
	}

}
