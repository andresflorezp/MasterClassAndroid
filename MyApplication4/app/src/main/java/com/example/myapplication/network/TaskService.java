package com.example.myapplication.network;

import com.example.myapplication.model.dto.Task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TaskService {

    @GET("master/tasks")
    Call<List<Task>> getTasksList();
}
