package com.cts.product.profile.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"firstName", "lastName", "username", "mobileNo", "emailId", "password", "dateOfBirth", "carTypePref", "preferences"})
public class UserProfile {

    private String firstName;
    private String lastName;
    private String username;
    private String mobileNo;
    private String emailId;
    private String password;
    private String dateOfBirth;
    private String carTypePref;
    private List<Preference> preferences;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getCarTypePref() {
        return carTypePref;
    }

    public void setCarTypePref(String carTypePref) {
        this.carTypePref = carTypePref;
    }

    public List<Preference> getPreferences() {
	if (preferences == null) {
	    preferences = new ArrayList<Preference>();
	}
	return preferences;
    }
}
