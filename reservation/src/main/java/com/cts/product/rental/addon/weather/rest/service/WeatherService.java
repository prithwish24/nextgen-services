package com.cts.product.rental.addon.weather.rest.service;

import java.io.IOException;

import com.cts.product.rental.addon.weather.model.WeatherForecast;

public interface WeatherService {
    WeatherForecast getWeatherReport(String city, String sessionId) throws IOException;
}
