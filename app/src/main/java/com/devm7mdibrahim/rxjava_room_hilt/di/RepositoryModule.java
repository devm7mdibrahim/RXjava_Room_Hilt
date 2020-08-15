package com.devm7mdibrahim.rxjava_room_hilt.di;

import com.devm7mdibrahim.rxjava_room_hilt.data.local.datasource.UserLocalDataSource;
import com.devm7mdibrahim.rxjava_room_hilt.ui.login.repo.LoginRepository;
import com.devm7mdibrahim.rxjava_room_hilt.ui.login.repo.LoginRepositoryImpl;
import com.devm7mdibrahim.rxjava_room_hilt.ui.main.repo.MainRepository;
import com.devm7mdibrahim.rxjava_room_hilt.ui.main.repo.MainRepositoryImpl;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public class RepositoryModule {

    @Provides
    public LoginRepository provideLoginRepository(UserLocalDataSource userLocalDataSource){
        return new LoginRepositoryImpl(userLocalDataSource);
    }

    @Provides
    public MainRepository provideMainRepository(UserLocalDataSource userLocalDataSource){
        return new MainRepositoryImpl(userLocalDataSource);
    }
}
