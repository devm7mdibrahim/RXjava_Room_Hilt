package com.devm7mdibrahim.rxjava_room_hilt.data.local.datasource;

import com.devm7mdibrahim.rxjava_room_hilt.data.local.dao.UserDao;
import com.devm7mdibrahim.rxjava_room_hilt.data.local.entity.User;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Flowable;


public class UserLocalDataSourceImpl implements UserLocalDataSource {

    private UserDao userDao;

    @Inject
    public UserLocalDataSourceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Completable insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public Flowable<List<User>> getAllUsers() {
        return userDao.getAllUsers();
    }
}
