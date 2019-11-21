package com.example.myapplication.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.myapplication.data.dao.TaskDao;
import com.example.myapplication.data.entity.Task;

@Database(entities = {Task.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TaskDao getTaskDao();
}