package com.cts.product.profile.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserProfile {

	private String fullName;
	private String userId;
	private String mobileNo;
	private String emailId;
	private String password;
	private Date dateOfBirth;
	private List<Preference> preferences;

	public String getFullName() {
		return fullName;
	}

	public String getUserId() {
		return userId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public List<Preference> getPreferences() {
		if (preferences == null) {
			preferences = new ArrayList<Preference>();
		}
		return preferences;
	}
}
