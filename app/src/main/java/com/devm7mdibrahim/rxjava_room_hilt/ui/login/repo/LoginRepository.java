package com.devm7mdibrahim.rxjava_room_hilt.ui.login.repo;

import com.devm7mdibrahim.rxjava_room_hilt.data.local.entity.User;

public interface LoginRepository {
    void insertUser(User user);
}
