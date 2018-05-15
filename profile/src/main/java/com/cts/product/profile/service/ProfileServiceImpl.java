package com.cts.product.profile.service;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.cts.product.profile.domain.UserProfile;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Override
    public UserProfile authenticate(String username, String password) {
	List<UserProfile> userProfileList = getAllUsers();
	UserProfile profile = null;
	for (UserProfile userProfile : userProfileList)
	    if (userProfile.getUsername().equalsIgnoreCase(username) && userProfile.getPassword().equals(password)) {
		profile = userProfile;
		break;
	    }

	return profile;
    }

    @Override
    public UserProfile getUserProfile(String userId) {
	List<UserProfile> userProfileList = getAllUsers();
	UserProfile profile = null;
	for (UserProfile userProfile : userProfileList) {
	    if (userProfile.getUsername().equals(userId)) {
		profile = userProfile;
		break;
	    }
	}
	return profile;
    }

    public List<UserProfile> getAllUsers() {
	ObjectMapper mapper = new ObjectMapper();
	TypeReference<List<UserProfile>> typeReference = new TypeReference<List<UserProfile>>() {

	};
	List<UserProfile> userProfileList = null;
	try {
	    userProfileList = mapper.readValue(new ClassPathResource("data.json").getInputStream(), typeReference);
	} catch (JsonParseException e) {
	    e.printStackTrace();
	} catch (JsonMappingException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return userProfileList;
    }
}
