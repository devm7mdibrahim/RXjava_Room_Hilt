package com.devm7mdibrahim.rxjava_room_hilt.ui.login.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.devm7mdibrahim.rxjava_room_hilt.data.local.datasource.UserLocalDataSource;
import com.devm7mdibrahim.rxjava_room_hilt.data.local.entity.User;
import com.devm7mdibrahim.rxjava_room_hilt.utils.DataState;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginRepositoryImpl implements LoginRepository {

    private MutableLiveData<DataState<String>> insertionState = new MutableLiveData<>();
    private UserLocalDataSource userLocalDataSource;

    @Inject
    public LoginRepositoryImpl(UserLocalDataSource userLocalDataSource) {
        this.userLocalDataSource = userLocalDataSource;
    }

    @Override
    public void insertUser(User user) {
        insertionState.postValue(DataState.loading());
        userLocalDataSource.insertUser(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        insertionState.postValue(DataState.success("User Added"));
                    }

                    @Override
                    public void onError(Throwable e) {
                        insertionState.postValue(DataState.error(e.getMessage()!= null? e.getMessage(): "Unknown Error"));
                    }
                });
    }

    @Override
    public LiveData<DataState<String>> getInsertionState() {
        return insertionState;
    }
}
