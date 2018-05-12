package com.cts.product.profile.dao;

import com.cts.product.profile.entity.ProfileSession;

public interface SessionDao {

    void create(String userId, String sessionId);

    ProfileSession findByUserId(String userId);

    void remove(String userId);
}
