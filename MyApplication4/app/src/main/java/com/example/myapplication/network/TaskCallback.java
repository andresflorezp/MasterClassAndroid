package com.example.myapplication.network;

import com.example.myapplication.model.dto.Task;

import java.util.List;

public interface TaskCallback {

    void onSuccess(List<Task> taskList);

    void onFailed(Exception e);
}
