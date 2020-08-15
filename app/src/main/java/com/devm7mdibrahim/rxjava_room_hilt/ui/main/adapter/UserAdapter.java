package com.devm7mdibrahim.rxjava_room_hilt.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.devm7mdibrahim.rxjava_room_hilt.R;
import com.devm7mdibrahim.rxjava_room_hilt.data.local.entity.User;
import com.devm7mdibrahim.rxjava_room_hilt.databinding.UserItemBinding;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {


    private List<User> usersList = new ArrayList<>();

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        UserItemBinding userItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.user_item, parent, false);
        return new UserViewHolder(userItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = usersList.get(position);
        holder.bind(user);
    }

    @Override
    public int getItemCount() {
        return usersList!= null? usersList.size(): 0;
    }

    public void submitUsersList(List<User> usersList){
        this.usersList = usersList;
    }

    static class UserViewHolder extends RecyclerView.ViewHolder{

        private UserItemBinding userItemBinding;
        public UserViewHolder(@NonNull UserItemBinding userItemBinding) {
            super(userItemBinding.getRoot());
            this.userItemBinding = userItemBinding;
        }

        public void bind(User user) {
            userItemBinding.setUser(user);
        }
    }
}
