package com.devm7mdibrahim.rxjava_room_hilt.ui.main.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devm7mdibrahim.rxjava_room_hilt.R;
import com.devm7mdibrahim.rxjava_room_hilt.data.local.entity.User;
import com.devm7mdibrahim.rxjava_room_hilt.databinding.ActivityMainBinding;
import com.devm7mdibrahim.rxjava_room_hilt.ui.main.adapter.UserAdapter;
import com.devm7mdibrahim.rxjava_room_hilt.ui.main.viewModel.MainViewModel;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;
    ActivityMainBinding mainBinding;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initRecyclerView();
        initViewModel();
        getDataFromDatabase();
    }

    private void initRecyclerView() {
        RecyclerView usersRecyclerView = mainBinding.mainRecyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        usersRecyclerView.setLayoutManager(linearLayoutManager);
        usersRecyclerView.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(usersRecyclerView.getContext(), linearLayoutManager.getOrientation());
        usersRecyclerView.addItemDecoration(dividerItemDecoration);
        userAdapter = new UserAdapter();
        usersRecyclerView.setAdapter(userAdapter);
    }

    private void initViewModel() {
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }

    private void getDataFromDatabase() {
        mainViewModel.getAllUsers().observe(this, this::displayData);
    }

    private void displayData(List<User> users) {
        userAdapter.submitUsersList(users);
        userAdapter.notifyDataSetChanged();
    }
}