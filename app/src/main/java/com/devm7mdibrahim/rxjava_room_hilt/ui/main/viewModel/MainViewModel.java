package com.devm7mdibrahim.rxjava_room_hilt.ui.main.viewModel;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.devm7mdibrahim.rxjava_room_hilt.data.local.entity.User;
import com.devm7mdibrahim.rxjava_room_hilt.ui.main.repo.MainRepository;
import com.devm7mdibrahim.rxjava_room_hilt.utils.DataState;

import java.util.List;


public class MainViewModel extends ViewModel {

    private MainRepository mainRepository;

    @ViewModelInject
    public MainViewModel(MainRepository mainRepository){
        this.mainRepository = mainRepository;
    }

    public void requestAllUsers() {
        mainRepository.requestAllUsers();
    }

    public LiveData<DataState<List<User>>> getUsers(){
        return mainRepository.getAllUsers();
    }
}
