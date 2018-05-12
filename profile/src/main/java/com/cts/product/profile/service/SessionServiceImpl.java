package com.cts.product.profile.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cts.product.profile.dao.SessionDao;
import com.cts.product.profile.entity.ProfileSession;

@Transactional
@Component
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionDao sessionDao;

    @Override
    public String createSession(String userId) {
	String sessionId = RandomStringUtils.randomAlphanumeric(40);
	sessionDao.create(userId, sessionId);
	return sessionId;
    }

    @Override
    public ProfileSession findByUserId(String userId) {
	ProfileSession profileSession = sessionDao.findByUserId(userId);
	return profileSession;
    }

    @Override
    public void removeSession(String userId) {
	sessionDao.remove(userId);
    }
}
