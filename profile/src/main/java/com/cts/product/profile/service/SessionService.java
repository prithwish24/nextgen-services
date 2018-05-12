package com.cts.product.profile.service;

import com.cts.product.profile.entity.ProfileSession;

public interface SessionService {

    String createSession(String userId);

    ProfileSession findByUserId(String userId);

    void removeSession(String userId);
}
