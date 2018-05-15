package com.cts.product.profile.domain;

import java.util.ArrayList;
import java.util.List;

public class UserProfile {

    private String fullname;
    private String username;
    private String mobileNo;
    private String emailId;
    private String password;
    private String dateOfBirth;
    private List<Preference> preferences;

    public String getFullname() {
	return fullname;
    }

    public void setFullname(String fullname) {
	this.fullname = fullname;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getMobileNo() {
	return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
    }

    public String getEmailId() {
	return emailId;
    }

    public void setEmailId(String emailId) {
	this.emailId = emailId;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getDateOfBirth() {
	return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
    }

    public List<Preference> getPreferences() {
	if (preferences == null) {
	    preferences = new ArrayList<Preference>();
	}
	return preferences;
    }
}
