package com.devm7mdibrahim.rxjava_room_hilt.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.devm7mdibrahim.rxjava_room_hilt.data.local.entity.User;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;


@Dao
public interface UserDao {
    @Insert
    Completable insertUser(User user);

    @Query("SELECT * FROM User ORDER BY id ASC")
    Single<List<User>> getAllUsers();
}
