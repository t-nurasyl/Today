package com.example.user2.today.music;
import android.os.Bundle;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class Track implements Serializable {
    @SerializedName("name")
    private String name;
    @SerializedName("duration")
    private String duration;
    @SerializedName("playcount")
    private String playcount;
    @SerializedName("listeners")
    private String listeners;
    @SerializedName("mbid")
    private String mbid;
    @SerializedName("url")
    private String url;
    @SerializedName("streamable")
    private Streamable streamable;
    @SerializedName("artist")
    private Artist artist;
    @SerializedName("image")
    private List<Image> image;

    public Track(){
        this.name = name;
        this.duration = duration;
        this.playcount = playcount;
        this.listeners = listeners;
        this.mbid = mbid;
        this.url = url;
        this.streamable = streamable;
        this.artist = artist;
        this.image = image;

    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setDuration(String duration){
        this.duration = duration;
    }

    public String getDuration(){
        return duration;
    }

    public void setPlaycount(String playcount){
        this.playcount = playcount;
    }

    public String getPlaycount(){
        return playcount;
    }

    public void setListeners(String listeners){
        this.listeners = listeners;
    }

    public String getListeners(){
        return listeners;
    }

    public void setMbid(String mbid){
        this.mbid = mbid;
    }

    public String getMbid(){
        return mbid;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getUrl(){
        return url;
    }

    public void setStreamable(Streamable streamable){
        this.streamable = streamable;
    }

    public Streamable getStreamable(){
        return streamable;
    }

    public void setArtist(Artist artist){
        this.artist = artist;
    }

    public Artist getArtist(){
        return artist;
    }

    public void setImage(List<Image> image){
        this.image = image;
    }

    public List<Image> getImage(){
        return image;
    }
}
