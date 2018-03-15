package com.cts.product.rental.service;

import java.io.IOException;

import com.cts.product.rental.bo.Location;

public interface LocationService {
	Location getLocation(Location locationRequest) throws IOException;
}
