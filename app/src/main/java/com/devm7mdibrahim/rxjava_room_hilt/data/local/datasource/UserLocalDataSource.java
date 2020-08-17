package com.devm7mdibrahim.rxjava_room_hilt.data.local.datasource;

import com.devm7mdibrahim.rxjava_room_hilt.data.local.entity.User;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface UserLocalDataSource {

    Completable insertUser(User user);
    Single<List<User>> getAllUsers();
}
