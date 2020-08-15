package com.devm7mdibrahim.rxjava_room_hilt.ui.main.repo;

import androidx.lifecycle.LiveData;

import com.devm7mdibrahim.rxjava_room_hilt.data.local.entity.User;

import java.util.List;

public interface MainRepository {
    LiveData<List<User>> getAllUsers();
}
