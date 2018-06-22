package com.example.user2.today.database;

import com.example.user2.today.holiday.HolidayResponse;
import com.example.user2.today.music.MusicResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service_Holiday {
    @GET("v1/holidays")
    Call<HolidayResponse> getHolidays(@Query("api_key")String apiKey,
                                      @Query("country") String country,
                                      @Query("year")String year,
                                      @Query("month")String month);
}
