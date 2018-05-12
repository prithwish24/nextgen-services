package com.cts.product.profile.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.product.profile.domain.UserProfile;
import com.cts.product.profile.service.ProfileService;
import com.cts.product.profile.service.SessionService;

@Service
public class ProfileServiceDelegate {

    @Autowired
    private ProfileService profileService;
    @Autowired
    private SessionService sessionService;

    // @HystrixCommand(fallbackMethod = "authenticate_fallback")
    public UserProfile authenticate(String username, String password) {
	return profileService.authenticate(username, password);
    }

    public UserProfile getUserProfile(String userId) {
	return profileService.getUserProfile(userId);
    }

    public String createSession(String userId) {
	return sessionService.createSession(userId);
    }

    public void logout(String userId) {
	sessionService.removeSession(userId);
    }

    public UserProfile authenticate_fallback(String username, String password) {
	return null;
    }

}
