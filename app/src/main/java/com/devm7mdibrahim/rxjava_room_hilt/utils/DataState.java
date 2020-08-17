package com.devm7mdibrahim.rxjava_room_hilt.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DataState<T> {

    @NonNull
    public final Status status;

    @Nullable
    public final T data;

    @Nullable
    public final String message;


    public DataState(@NonNull Status status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> DataState<T> success (@Nullable T data) {
        return new DataState<>(Status.SUCCESS, data, null);
    }

    public static <T> DataState<T> error(@NonNull String msg) {
        return new DataState<>(Status.ERROR, null, msg);
    }

    public static <T> DataState<T> loading() {
        return new DataState<>(Status.LOADING, null, null);
    }
}