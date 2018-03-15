package com.cts.product.rental.dao;

import java.io.IOException;

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
	public void updateZip(String requestSessionId, String zipcode) throws IOException {

		Session session = entityManager.find(Session.class, requestSessionId);
		if (session == null) {
			throw new IOException("Invalid session Id");
		}
		session.setZipcode(zipcode);
		entityManager.merge(session);
	}

	@Override
	public Session findBySessionId(String requestSessionId) {
		return entityManager.find(Session.class, requestSessionId);
	}

}
