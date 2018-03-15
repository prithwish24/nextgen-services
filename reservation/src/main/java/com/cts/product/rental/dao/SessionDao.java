package com.cts.product.rental.dao;

import java.io.IOException;

import com.cts.product.rental.entity.Session;

public interface SessionDao {

	void create(String requestSessionId, String orchSessionId);

	void updateZip(String requestSessionId, String zipcode) throws IOException;

	Session findBySessionId(String sessionId);
}
