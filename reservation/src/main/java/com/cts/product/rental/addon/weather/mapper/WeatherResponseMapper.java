package com.cts.product.rental.addon.weather.mapper;

import com.cts.product.rental.addon.weather.domain.Channel;
import com.cts.product.rental.addon.weather.domain.Item;
import com.cts.product.rental.addon.weather.domain.WeatherResponse;
import com.cts.product.rental.addon.weather.model.WeatherForecast;

public class WeatherResponseMapper {
    public static WeatherForecast mapResponse(WeatherResponse weather) {
	WeatherForecast weatherForecast = new WeatherForecast();
	if (null != weather.getQuery().getResults()) {
	    Channel channel = weather.getQuery().getResults().getChannel();
	    if (null != channel) {
		weatherForecast.setLocation(channel.getLocation());
		weatherForecast.setUnits(channel.getUnits());
		weatherForecast.setAtmosphere(channel.getAtmosphere());
		Item item = channel.getItem();
		if (null != item) {
		    weatherForecast.setTitle(item.getTitle());
		    weatherForecast.setDescription(item.getDescription());
		    weatherForecast.setCondition(item.getCondition());
		    weatherForecast.getForecastList().addAll(item.getForecast());
		}
	    }
	}
	return weatherForecast;
    }
}
