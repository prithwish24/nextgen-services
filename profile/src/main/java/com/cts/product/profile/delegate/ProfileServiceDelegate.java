package com.cts.product.profile.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.product.profile.domain.UserProfile;
import com.cts.product.profile.service.ProfileService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ProfileServiceDelegate {

	@Autowired
	private ProfileService profileService;
	
	@HystrixCommand(fallbackMethod="authenticate_fallback")
	public UserProfile authenticate(String username, String password) {
		return profileService.authenticate(username, password);
	}
	
	public UserProfile getUserProfile(String userId) {
		return profileService.getUserProfile(userId);
	}
	
	
	public UserProfile authenticate_fallback(String username, String password) {
		return null;
	}
	
}
