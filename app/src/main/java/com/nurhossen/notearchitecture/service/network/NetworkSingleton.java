package com.nurhossen.notearchitecture.service.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.nurhossen.notearchitecture.service.network.ApiConstant.BASEURL;

public class NetworkSingleton {

    private static Retrofit retrofit;

    public static Retrofit getRetrofit(){
        if(retrofit==null){
            retrofit = new  Retrofit
                    .Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return  retrofit;
    }
}
