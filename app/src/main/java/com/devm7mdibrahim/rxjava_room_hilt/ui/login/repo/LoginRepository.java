package com.devm7mdibrahim.rxjava_room_hilt.ui.login.repo;

import androidx.lifecycle.LiveData;

import com.devm7mdibrahim.rxjava_room_hilt.data.local.entity.User;
import com.devm7mdibrahim.rxjava_room_hilt.utils.DataState;

public interface LoginRepository {
    void insertUser(User user);
    LiveData<DataState<String>> getInsertionState();
}
