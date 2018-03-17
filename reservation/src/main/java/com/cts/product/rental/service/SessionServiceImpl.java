package com.cts.product.rental.service;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cts.product.rental.bo.ReservationRequest;

@Transactional
@Component
public class SessionServiceImpl implements SessionService {

    // @Autowired
    // private SessionDao sessionDao;

    private ConcurrentHashMap<String, String> sessionDao;

    @PostConstruct
    public void init() {
	sessionDao = new ConcurrentHashMap<String, String>();
    }

    @Override
    public String createSession(ReservationRequest reservationRequest) {
	String orchSessionId = RandomStringUtils.randomAlphanumeric(40);
	// sessionDao.create(reservationRequest.getSessionId(), orchSessionId);
	sessionDao.putIfAbsent(orchSessionId, orchSessionId);
	return orchSessionId;
    }

    @Override
    public void updateSessionWithZipcode(String sessionId, String zipcode) throws IOException {
	// sessionDao.updateZip(sessionId, zipcode);

	if (findBySessionId(sessionId) == null) {
	    throw new IOException("Invalid session Id");
	}
	sessionDao.put(sessionId, zipcode);
    }

    @Override
    public String findBySessionId(String requestSessionId) {
	// Session session = sessionDao.findBySessionId(requestSessionId);
	return sessionDao.get(requestSessionId);
    }
}
