package com.devm7mdibrahim.rxjava_room_hilt.ui.main.repo;

import android.annotation.SuppressLint;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.devm7mdibrahim.rxjava_room_hilt.data.local.datasource.UserLocalDataSource;
import com.devm7mdibrahim.rxjava_room_hilt.data.local.entity.User;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainRepositoryImpl implements MainRepository {

    MutableLiveData<List<User>> usersMutableLiveData = new MutableLiveData<>();
    private UserLocalDataSource userLocalDataSource;

    @Inject
    public MainRepositoryImpl(UserLocalDataSource userLocalDataSource){
        this.userLocalDataSource = userLocalDataSource;
    }

    @SuppressLint("CheckResult")
    @Override
    public LiveData<List<User>> getAllUsers() {
        userLocalDataSource.getAllUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(users -> usersMutableLiveData.postValue(users));
        return usersMutableLiveData;
    }
}
