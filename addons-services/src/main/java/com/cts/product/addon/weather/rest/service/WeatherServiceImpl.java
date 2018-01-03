package com.cts.product.addon.weather.rest.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.cts.product.addon.weather.model.WeatherResponse;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Override
	@Cacheable(value = "weather", key = "#city")
	public WeatherResponse getWeatherReport(String city) {
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
