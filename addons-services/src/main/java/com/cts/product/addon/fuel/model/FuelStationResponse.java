package com.cts.product.addon.fuel.model;

import java.util.ArrayList;
import java.util.List;

import com.cts.product.addon.fuel.domain.FuelStation;

public class FuelStationResponse {

	private List<FuelStation> fuel_stations;

	public List<FuelStation> getFuelStations() {
		if (this.fuel_stations == null) {
			this.fuel_stations = new ArrayList<FuelStation>();
		}
		return this.fuel_stations;
	}
}
