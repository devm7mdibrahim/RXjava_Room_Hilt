package com.devm7mdibrahim.rxjava_room_hilt.ui.login.viewModel;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.ViewModel;

import com.devm7mdibrahim.rxjava_room_hilt.data.local.entity.User;
import com.devm7mdibrahim.rxjava_room_hilt.ui.login.repo.LoginRepository;


public class LoginViewModel extends ViewModel {

    private LoginRepository loginRepository;

    @ViewModelInject
    public LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public void insertUser(User user) {
        loginRepository.insertUser(user);
    }
}
