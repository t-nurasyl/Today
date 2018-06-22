package com.example.user2.today.holiday;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Holidays implements Serializable{
    @SerializedName("name")
    private String name;
    @SerializedName("date")
    private String date;
    @SerializedName("observed")
    private String observed;
    @SerializedName("public")
    private String publicc;

    public Holidays(){
        this.name = name;
        this.date = date;
        this.observed = observed;
        this.publicc = publicc;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setDate(String date){
        this.date = date;
    }
    public String getDate(){
        return date;
    }
    public void setObserved(String observed){
        this.observed = observed;
    }
    public String getObserved(){
        return observed;
    }
    public void setPublicc(String publicc){
        this.publicc = publicc;
    }
    public String getPublicc(){
        return publicc;
    }
}
