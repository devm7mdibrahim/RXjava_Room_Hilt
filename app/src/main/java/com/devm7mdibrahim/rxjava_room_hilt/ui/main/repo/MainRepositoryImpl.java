package com.devm7mdibrahim.rxjava_room_hilt.ui.main.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.devm7mdibrahim.rxjava_room_hilt.data.local.datasource.UserLocalDataSource;
import com.devm7mdibrahim.rxjava_room_hilt.data.local.entity.User;
import com.devm7mdibrahim.rxjava_room_hilt.utils.DataState;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainRepositoryImpl implements MainRepository {

    private MutableLiveData<DataState<List<User>>> _users = new MutableLiveData<>();
    private UserLocalDataSource userLocalDataSource;

    @Inject
    public MainRepositoryImpl(UserLocalDataSource userLocalDataSource) {
        this.userLocalDataSource = userLocalDataSource;
    }

    @Override
    public void requestAllUsers() {
        _users.postValue(DataState.loading());
        userLocalDataSource.getAllUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<User> users) {
                        _users.postValue(DataState.success(users));
                    }

                    @Override
                    public void onError(Throwable e) {
                        _users.postValue(DataState.error(e.getMessage() != null ? e.getMessage() : "Unknown Error"));
                    }
                });
    }

    @Override
    public LiveData<DataState<List<User>>> getAllUsers() {
        return _users;
    }
}
