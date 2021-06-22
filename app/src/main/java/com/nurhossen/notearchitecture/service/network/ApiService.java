package com.nurhossen.notearchitecture.service.network;

import com.nurhossen.notearchitecture.service.model.ResponsePopularMovie;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("3/movie/top_rated?api_key=aca92a7bb299b17919709bc86e7858c6")
    Call<ResponsePopularMovie> topRatedMovies();
}
