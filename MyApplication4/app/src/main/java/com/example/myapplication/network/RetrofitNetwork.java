package com.example.myapplication.network;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.example.myapplication.data.AppDatabase;
import com.example.myapplication.data.dao.TaskDao;
import com.example.myapplication.model.dto.Task;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitNetwork {

    private TaskService taskService;

    private ExecutorService executorService = Executors.newFixedThreadPool(1);

    public AppDatabase appDatabase;

//    public MutableLiveData<List<Task>> listMutableLiveData = new MutableLiveData<>();

    public RetrofitNetwork(Context context) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/sancarbar/api-tester/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        taskService = retrofit.create(TaskService.class);

        appDatabase = Room.databaseBuilder(context,
                AppDatabase.class, "database-tasks").build();

    }


    public void getTask() {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    List<Task> taskList = taskService.getTasksList().execute().body();
//                    listMutableLiveData.postValue(taskList);

                    TaskDao taskDao = appDatabase.getTaskDao();
                    for (Task task : taskList) {
                        taskDao.inser(new com.example.myapplication.data.entity.Task(task));
                    }



                } catch (IOException e) {

                }
            }
        });
    }


}
