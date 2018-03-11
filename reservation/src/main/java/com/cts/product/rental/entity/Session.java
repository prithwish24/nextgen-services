package com.cts.product.rental.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "request_session_id")
	private String requestSessionId;
	@Column(name = "orch_session_id")
	private String orchSessionId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRequestSessionId() {
		return requestSessionId;
	}

	public void setRequestSessionId(String requestSessionId) {
		this.requestSessionId = requestSessionId;
	}

	public String getOrchSessionId() {
		return orchSessionId;
	}

	public void setOrchSessionId(String orchSessionId) {
		this.orchSessionId = orchSessionId;
	}

}
