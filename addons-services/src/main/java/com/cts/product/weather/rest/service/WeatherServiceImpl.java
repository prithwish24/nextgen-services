package com.cts.product.weather.rest.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.cts.product.addon.domain.WeatherResponse;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Override
	@Cacheable("weather")
	public WeatherResponse getWeatherReport(String city) {
		final String q = "select * from weather.forecast where woeid in (select woeid from geo.places(1) where text='"
				+ city + "') and u='c'";
		final String uri = "https://query.yahooapis.com/v1/public/yql";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri).queryParam("q", q).queryParam("format",
				"json");
		System.out.println("toURI=" + builder.build().encode().toUri());
		RestTemplate restTemplate = new RestTemplate();
		WeatherResponse result = restTemplate.getForObject(builder.build().encode().toUri(), WeatherResponse.class);

		return result;
	}

	@Scheduled(fixedDelay = 60000)
	@CacheEvict(value = "weather", allEntries = true)
	public void evict() {
		System.out.println("cache evicted");
	}

	// public static void main(String[] args) throws Exception {
	// Weather weatherReport = getWeatherReport("Howrah");
	// System.out.println(weatherReport.getQuery().getResults().getChannel().getItem().getCondition().getDate());
	// System.out.println(weatherReport.getQuery().getResults().getChannel().getItem().getCondition().getTemp());
	// }
}
