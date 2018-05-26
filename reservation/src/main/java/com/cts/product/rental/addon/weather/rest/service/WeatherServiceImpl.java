package com.cts.product.rental.addon.weather.rest.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.cts.product.rental.addon.weather.model.WeatherResponse;
import com.cts.product.rental.entity.Session;
import com.cts.product.rental.service.SessionService;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private SessionService sessionService;

    @Override
    @Cacheable(value = "weather", key = "#city")
    public WeatherResponse getWeatherReport(String city, String sessionId) throws IOException {
	Session session = sessionService.findBySessionId(sessionId);
	if (session == null) {
	    throw new IOException("Invalid session Id");
	}
	final String q = "select * from weather.forecast where woeid in (select woeid from geo.places(1) where text='"
		+ city + "') and u='c'";
	final String uri = "https://query.yahooapis.com/v1/public/yql";
	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri).queryParam("q", q).queryParam("format",
		"json");
	RestTemplate restTemplate = new RestTemplate();
	WeatherResponse result = restTemplate.getForObject(builder.build().encode().toUri(), WeatherResponse.class);

	return result;
    }
}
