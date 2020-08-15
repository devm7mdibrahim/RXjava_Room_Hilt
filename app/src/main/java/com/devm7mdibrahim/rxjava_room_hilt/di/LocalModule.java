package com.devm7mdibrahim.rxjava_room_hilt.di;

import android.content.Context;

import androidx.room.Room;

import com.devm7mdibrahim.rxjava_room_hilt.data.local.UserDatabase;
import com.devm7mdibrahim.rxjava_room_hilt.data.local.dao.UserDao;
import com.devm7mdibrahim.rxjava_room_hilt.data.local.datasource.UserLocalDataSource;
import com.devm7mdibrahim.rxjava_room_hilt.data.local.datasource.UserLocalDataSourceImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.android.qualifiers.ApplicationContext;

@Module
@InstallIn(ApplicationComponent.class)
public class LocalModule {

    @Provides
    @Singleton
    public UserDatabase provideDataBase(@ApplicationContext Context context){
        return Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, "users_database")
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    public UserDao provideUserDao(UserDatabase userDatabase){
        return userDatabase.userDao();
    }

    @Provides
    @Singleton
    public UserLocalDataSource provideUserLocalDataSource(UserDao userDao){
        return new UserLocalDataSourceImpl(userDao);
    }
}
