package com.devm7mdibrahim.rxjava_room_hilt.ui.main.viewModel;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.devm7mdibrahim.rxjava_room_hilt.data.local.entity.User;
import com.devm7mdibrahim.rxjava_room_hilt.ui.main.repo.MainRepository;

import java.util.List;


public class MainViewModel extends ViewModel {

    private MainRepository mainRepository;

    @ViewModelInject
    public MainViewModel(MainRepository mainRepository){
        this.mainRepository = mainRepository;
    }

    public LiveData<List<User>> getAllUsers() {
        return mainRepository.getAllUsers();
    }
}
