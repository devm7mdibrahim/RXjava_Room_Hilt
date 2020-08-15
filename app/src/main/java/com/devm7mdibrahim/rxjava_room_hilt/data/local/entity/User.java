package com.devm7mdibrahim.rxjava_room_hilt.data.local.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String userName;
    private String userAge;
    private String jobTitle;
    private String gender;

    public User(String userName, String userAge, String jobTitle, String gender) {
        this.userName = userName;
        this.userAge = userAge;
        this.jobTitle = jobTitle;
        this.gender = gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getGender() {
        return gender;
    }
}
