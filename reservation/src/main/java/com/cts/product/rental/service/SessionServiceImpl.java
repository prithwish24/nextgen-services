package com.cts.product.rental.service;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cts.product.rental.bo.ReservationRequest;
import com.cts.product.rental.dao.SessionDao;
import com.cts.product.rental.entity.Session;

@Transactional
@Component
public class SessionServiceImpl implements SessionService {

	@Autowired
	private SessionDao sessionDao;

	@Override
	public String createSession(ReservationRequest reservationRequest) {
		String orchSessionId = RandomStringUtils.randomAlphanumeric(40);
		sessionDao.create(reservationRequest.getSessionId(), orchSessionId);
		return orchSessionId;
	}

	@Override
	public void updateSessionWithZipcode(String sessionId, String zipcode)
			throws IOException {
		sessionDao.updateZip(sessionId, zipcode);
	}

	@Override
	public Session findBySessionId(String requestSessionId) {
		Session session = sessionDao.findBySessionId(requestSessionId);
		return session;
	}
}
