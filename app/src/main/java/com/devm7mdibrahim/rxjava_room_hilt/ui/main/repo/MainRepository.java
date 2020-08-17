package com.devm7mdibrahim.rxjava_room_hilt.ui.main.repo;

import androidx.lifecycle.LiveData;

import com.devm7mdibrahim.rxjava_room_hilt.data.local.entity.User;
import com.devm7mdibrahim.rxjava_room_hilt.utils.DataState;

import java.util.List;

public interface MainRepository {
    void requestAllUsers();
    LiveData<DataState<List<User>>> getAllUsers();
}
