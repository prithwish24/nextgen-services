package com.cts.product.weather.rest.service;

import com.cts.product.addon.domain.WeatherResponse;

public interface WeatherService {
	WeatherResponse getWeatherReport(String city);
}
