package com.cts.product.addon.weather.rest.service;

import com.cts.product.addon.weather.model.WeatherResponse;

public interface WeatherService {
	WeatherResponse getWeatherReport(String city);
}
