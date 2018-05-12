package com.cts.product.profile.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cts.product.profile.entity.ProfileSession;

@Repository
public class SessionDaoImpl implements SessionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(String userId, String sessionId) {

	ProfileSession findBySessionId = findByUserId(userId);
	ProfileSession profileSession = new ProfileSession();
	profileSession.setUserId(userId);
	profileSession.setSessionId(sessionId);
	if (findBySessionId != null) {
	    entityManager.merge(profileSession);
	} else {
	    entityManager.persist(profileSession);
	}
    }

    @Override
    public ProfileSession findByUserId(String userId) {
	return entityManager.find(ProfileSession.class, userId);
    }

    @Override
    public void remove(String userId) {
	ProfileSession profileSession = findByUserId(userId);
	entityManager.remove(profileSession);
    }

}
