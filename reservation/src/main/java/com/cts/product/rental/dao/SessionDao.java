package com.cts.product.rental.dao;

public interface SessionDao {

	void create(String requestSessionId, String orchSessionId);

	void updateZip(String requestSessionId, String zipcode);

	String findBySessionId(String sessionId);
}
