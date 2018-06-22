package com.example.user2.today.holiday;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HolidayResponse {
    @SerializedName("tracks")
    private List<Holidays> holidays;

    public HolidayResponse(List<Holidays> holidays){
        this.holidays = holidays;
    }

    public void setHolidays(List<Holidays> holidays){
        this.holidays = holidays;
    }

    public List<Holidays> getHolidays(){
        return holidays;
    }

}
