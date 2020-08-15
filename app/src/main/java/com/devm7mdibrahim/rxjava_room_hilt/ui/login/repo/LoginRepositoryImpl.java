package com.devm7mdibrahim.rxjava_room_hilt.ui.login.repo;

import com.devm7mdibrahim.rxjava_room_hilt.data.local.datasource.UserLocalDataSource;
import com.devm7mdibrahim.rxjava_room_hilt.data.local.entity.User;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginRepositoryImpl implements LoginRepository {

    private UserLocalDataSource userLocalDataSource;

    @Inject
    public LoginRepositoryImpl(UserLocalDataSource userLocalDataSource) {
        this.userLocalDataSource = userLocalDataSource;
    }

    @Override
    public void insertUser(User user) {
        userLocalDataSource.insertUser(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }
}
