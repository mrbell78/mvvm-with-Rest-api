package com.nurhossen.notearchitecture.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nurhossen.notearchitecture.R;
import com.nurhossen.notearchitecture.service.model.Result;
import com.nurhossen.notearchitecture.view.adapter.TopratedMovieAdapter;
import com.nurhossen.notearchitecture.viewmodel.MainActivityViewmodel;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    MainActivityViewmodel mainActivityViewmodel;
    private TopratedMovieAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.recyclerviwe_mainacitvity);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));


        mainActivityViewmodel = new ViewModelProvider(this).get(MainActivityViewmodel.class);
         mainActivityViewmodel.getTopratedMovies().observe(this, new Observer<List<Result>>() {
             @Override
             public void onChanged(List<Result> results) {
                 adapter= new TopratedMovieAdapter(MainActivity.this, results);
                 recyclerView.setAdapter(adapter);
             }
         });


    }
}