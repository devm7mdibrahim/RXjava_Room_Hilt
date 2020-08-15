package com.devm7mdibrahim.rxjava_room_hilt.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.devm7mdibrahim.rxjava_room_hilt.data.local.dao.UserDao;
import com.devm7mdibrahim.rxjava_room_hilt.data.local.entity.User;

@Database(entities = User.class, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
