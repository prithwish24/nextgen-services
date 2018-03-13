package com.cts.product.rental.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cts.product.rental.entity.Session;

@Repository
public class SessionDaoImpl implements SessionDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void create(String requestSessionId, String orchSessionId) {

		Session session = new Session();
		session.setRequestSessionId(requestSessionId);
		session.setOrchSessionId(orchSessionId);
		entityManager.persist(session);
	}

	@Override
	public void updateZip(String requestSessionId, String zipcode) {

		Session session = entityManager.find(Session.class, requestSessionId);
		session.setZipcode(zipcode);
		entityManager.merge(session);
	}

	@Override
	public String findBySessionId(String requestSessionId) {
		return entityManager.find(Session.class, requestSessionId).getZipcode();
	}

}
