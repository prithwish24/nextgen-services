package com.cts.product.profile.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.product.profile.delegate.ProfileServiceDelegate;
import com.cts.product.profile.domain.BaseResponse;
import com.cts.product.profile.domain.LoginRequest;
import com.cts.product.profile.domain.UserProfile;

@RestController
@RequestMapping("/")
@ComponentScan(basePackages = { "com.cts.product.profile" })
public class ProfileController {
	private static final Logger LOG = LoggerFactory.getLogger(ProfileController.class);

	@Autowired
	private ProfileServiceDelegate delegate;

	@RequestMapping(value = "/login", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse<UserProfile> userlogin(@RequestBody LoginRequest loginRequest) {
		LOG.debug("Inside userlogin()");
		
		BaseResponse<UserProfile> bp = new BaseResponse<>();
		if (StringUtils.isEmpty(loginRequest.getUsername())) {
			bp.setServiceError("2001", "ERROR", "Username is required");
		}

		if (StringUtils.isEmpty(loginRequest.getPassword())) {
			bp.setServiceError("2002", "ERROR", "Password is required");
		}

		if (org.apache.commons.lang3.StringUtils.length(loginRequest.getPassword()) < 5) {
			bp.setServiceError("2002", "ERROR", "Password length should be 5 or more characters.");
		}
		
		LOG.debug("login requested for ["+loginRequest.getUsername()+"] using password {"+
				org.apache.commons.lang3.StringUtils.overlay(loginRequest.getPassword(), "*", 3, loginRequest.getPassword().length())+"}");
		
		if (!StringUtils.isEmpty(loginRequest.getUsername()) && !StringUtils.isEmpty(loginRequest.getPassword())) {
			UserProfile profile = delegate.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
			if (profile == null) {
				bp.setServiceError("2003", "ERROR", "Invalid user credentials");
			} else {
				bp.setSuccess(true);
				bp.setResponse(profile);
				bp.setSessionId(delegate.createSession(profile.getUsername()));
			}
		}
		LOG.debug("Returning from userlogin: " + bp.toString());
		return bp;
	}

	@RequestMapping(value = "/getprofile", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse<UserProfile> getProfile(
			@RequestParam(name = "username", required = true, defaultValue = "") String username) {
		LOG.debug("Inside getProfile()");
		BaseResponse<UserProfile> bp = new BaseResponse<>();

		if (StringUtils.isEmpty(username)) {
			bp.setServiceError("2002", "INFO", "Profile Not Found");
		} else {
			UserProfile profile = delegate.getUserProfile(username);
			bp.setResponse(profile);
			bp.setSuccess(true);
		}
		LOG.debug("Returning from getProfile: " + bp.toString());
		return bp;
	}

	@RequestMapping(value = "/logout", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse<?> logout(
			@RequestParam(name = "username", required = true, defaultValue = "") String username) {
		LOG.debug("Inside logout");

		BaseResponse<?> bp = new BaseResponse<Object>();
		delegate.logout(username);
		bp.setSuccess(true);
		return bp;
	}

}
