package com.example.myapplication.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.TaskAdapter;
import com.example.myapplication.data.entity.Task;
import com.example.myapplication.network.RetrofitNetwork;
import com.example.myapplication.network.TaskCallback;

import java.util.List;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    private RecyclerView recyclerView;


    private RetrofitNetwork retrofitNetwork;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.my_recycler_view);
        initRecyclerView();
        retrofitNetwork.appDatabase.getTaskDao().getAll().observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(List<Task> tasks) {
                recyclerView.setAdapter(new TaskAdapter(tasks));
            }
        });

    }

    private void initRecyclerView() {
        recyclerView.setHasFixedSize( true );
        LinearLayoutManager layoutManager = new LinearLayoutManager( getContext() );
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        retrofitNetwork = new RetrofitNetwork(context);
        retrofitNetwork.getTask();


    }

}
