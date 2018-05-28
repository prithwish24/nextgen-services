
package com.cts.product.rental.addon.weather.model;

import java.util.ArrayList;
import java.util.List;

import com.cts.product.rental.addon.weather.domain.Atmosphere;
import com.cts.product.rental.addon.weather.domain.Condition;
import com.cts.product.rental.addon.weather.domain.Forecast;
import com.cts.product.rental.addon.weather.domain.Location;
import com.cts.product.rental.addon.weather.domain.Units;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeatherForecast {

    private String title;
    private String description;
    private Location location;
    private Condition condition;
    private Units units;
    private Atmosphere atmosphere;
    private List<Forecast> forecastList;

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public Location getLocation() {
	return location;
    }

    public void setLocation(Location location) {
	this.location = location;
    }

    public Condition getCondition() {
	return condition;
    }

    public void setCondition(Condition condition) {
	this.condition = condition;
    }

    public Units getUnits() {
	return units;
    }

    public void setUnits(Units units) {
	this.units = units;
    }

    public Atmosphere getAtmosphere() {
	return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
	this.atmosphere = atmosphere;
    }

    public List<Forecast> getForecastList() {
	if (forecastList == null) {
	    forecastList = new ArrayList<Forecast>();
	}
	return this.forecastList;
    }
}
