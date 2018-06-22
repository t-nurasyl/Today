package com.example.user2.today.database;

import com.example.user2.today.music.MusicResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {
    @GET("2.0/")
    Call<MusicResponse> getPopularMusics(@Query("method") String toptrack,
                                         @Query("api_key")String apiKey,
                                         @Query("format")String format);
}
