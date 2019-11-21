package com.example.myapplication.ui.main;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
    }

    public void onStartMainActivityButtonClicked(View view) {

//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
        finish();


    }
}
