package com.cts.product.rental.addon.weather.rest.service;

import java.io.IOException;

import com.cts.product.rental.addon.weather.model.WeatherResponse;

public interface WeatherService {
    WeatherResponse getWeatherReport(String city, String sessionId) throws IOException;
}
