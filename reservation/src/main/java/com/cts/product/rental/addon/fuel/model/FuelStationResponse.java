package com.cts.product.rental.addon.fuel.model;

import java.util.ArrayList;
import java.util.List;

import com.cts.product.rental.addon.fuel.domain.FuelStation;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "fuel_stations" })
public class FuelStationResponse {

	@JsonProperty("fuel_stations")
	private List<FuelStation> fuelStations = null;

	@JsonProperty("fuel_stations")
	public List<FuelStation> getFuelStations() {
		if (this.fuelStations == null) {
			this.fuelStations = new ArrayList<FuelStation>();
		}
		return this.fuelStations;
	}
}
