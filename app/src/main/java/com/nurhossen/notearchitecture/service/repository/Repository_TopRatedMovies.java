package com.nurhossen.notearchitecture.service.repository;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.nurhossen.notearchitecture.service.model.ResponsePopularMovie;
import com.nurhossen.notearchitecture.service.model.Result;
import com.nurhossen.notearchitecture.service.network.ApiService;
import com.nurhossen.notearchitecture.service.network.NetworkSingleton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Repository_TopRatedMovies {

    private  ResponsePopularMovie responsePopularMovie;
    private  List<Result> mresult=new ArrayList<>();
    private static Context mcontext;
    private static Repository_TopRatedMovies repository_topRatedMoviesInstance;
    private MutableLiveData mlivedata;

    public static Repository_TopRatedMovies getRepository_topRatedMoviesInstance(Context context){
        if(repository_topRatedMoviesInstance==null){
            mcontext=context;
            repository_topRatedMoviesInstance= new Repository_TopRatedMovies();
        }

        return  repository_topRatedMoviesInstance;
    }


    public MutableLiveData<List<Result>> getTopratedMoves(){

        if(mlivedata==null){
            mlivedata=new MutableLiveData();
        }
        ApiService apiService = NetworkSingleton.getRetrofit().create(ApiService.class);
        Call<ResponsePopularMovie> call = apiService.topRatedMovies();

        call.enqueue(new Callback<ResponsePopularMovie>() {
            @Override
            public void onResponse(Call<ResponsePopularMovie> call, Response<ResponsePopularMovie> response) {
                responsePopularMovie=response.body();
                mresult = responsePopularMovie.getResults();
                mlivedata.postValue(mresult);
            }

            @Override
            public void onFailure(Call<ResponsePopularMovie> call, Throwable t) {

            }
        });

        return mlivedata;
    }
}
