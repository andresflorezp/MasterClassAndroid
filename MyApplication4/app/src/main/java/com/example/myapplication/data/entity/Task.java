package com.example.myapplication.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Task {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo()
    String text;

    @ColumnInfo()
    String priority;

    @ColumnInfo()
    String dueDate;


    public Task() {
    }

    public Task(com.example.myapplication.model.dto.Task task) {
        text = task.getText();
        priority = task.getPriority();
        dueDate = task.getDueDate();
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPriority() {
        return String.valueOf(priority);
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "text='" + text + '\'' +
                ", priority=" + priority +
                ", dueDate='" + dueDate + '\'' +
                '}';
    }


}
