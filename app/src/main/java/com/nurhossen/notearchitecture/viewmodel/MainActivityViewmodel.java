package com.nurhossen.notearchitecture.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nurhossen.notearchitecture.service.model.Result;
import com.nurhossen.notearchitecture.service.repository.Repository_TopRatedMovies;
import com.nurhossen.notearchitecture.view.adapter.TopratedMovieAdapter;

import java.util.List;
import java.util.Random;

import static android.content.ContentValues.TAG;

public class MainActivityViewmodel extends AndroidViewModel {

    private Repository_TopRatedMovies repositoryTopRatedMoviesopRatedMovies;

    public MainActivityViewmodel(@NonNull Application application) {
        super(application);
        repositoryTopRatedMoviesopRatedMovies= Repository_TopRatedMovies.getRepository_topRatedMoviesInstance(application);
    }

    public MutableLiveData<List<Result>> getTopratedMovies(){

      return   repositoryTopRatedMoviesopRatedMovies.getTopratedMoves();
    }
}
