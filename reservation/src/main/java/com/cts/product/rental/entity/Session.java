package com.cts.product.rental.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Session {

	@Id
	@Column(name = "orch_session_id")
	private String orchSessionId;
	@Column(name = "request_session_id")
	private String requestSessionId;
	@Column(name = "zipcode")
	private String zipcode;

	public String getOrchSessionId() {
		return orchSessionId;
	}

	public void setOrchSessionId(String orchSessionId) {
		this.orchSessionId = orchSessionId;
	}

	public String getRequestSessionId() {
		return requestSessionId;
	}

	public void setRequestSessionId(String requestSessionId) {
		this.requestSessionId = requestSessionId;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
