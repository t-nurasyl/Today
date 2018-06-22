package com.example.user2.today.database;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client_Holiday {
    public static final String BASE_URL = "https://holidayapi.com/v1";
    public static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
