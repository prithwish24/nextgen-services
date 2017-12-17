package com.cts.product.profile.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserProfile {

	private final String fullName;
	private final String userId;
	private final String mobileNo;
	private final String emailId;
	private final Date	 dateOfBirth;
	private final Map<String, String> preferences;
	
	private UserProfile(
			final String fullName, final String userId, 
			final String mobileNo, final String emailId,
			final Date dateOfBirth,
			final Map<String, String> preferences) {
		this.fullName = fullName;
		this.userId = userId;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.preferences = preferences;
	}
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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public Map<String, String> getPreferences() {
		return preferences;
	}
	
	public static class ProfileBuilder {
		private String fullName;
		private String userId;
		private String mobileNo;
		private String emailId;
		private Date dateOfBirth;
		private Map<String, String> preferences;
		
		final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
		
		public ProfileBuilder(final String userId) {
			this.userId = userId;
		}

		public ProfileBuilder fullName(String fullName) {
			this.fullName = fullName;
			return this;
		}

		public ProfileBuilder userId(String userId) {
			this.userId = userId;
			return this;
		}

		public ProfileBuilder mobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
			return this;
		}

		public ProfileBuilder emailId(String emailId) {
			this.emailId = emailId;
			return this;
		}

		/**
		 * Format 'yyyy-MM-yy' or '2017-12-17' 
		 * @param dateOfBirth
		 * @return
		 */
		public ProfileBuilder dateOfBirth(String dateOfBirth) {
			try {
				this.dateOfBirth = SDF.parse(dateOfBirth);
			} catch(ParseException pe) { }				
			return this;
		}
		
		public ProfileBuilder preferences(Map<String, String> preferences) {
			this.preferences = preferences;
			return this;
		}
		
		public ProfileBuilder addPreference(String type, String value) {
			if (this.preferences == null) 
				this.preferences = new HashMap<String, String>();
			this.preferences.put(type, value);
			return this;
		}
		
		public UserProfile build() {
			return new UserProfile(fullName, userId, 
					mobileNo, emailId, dateOfBirth, preferences);
		}
	}
	
}
