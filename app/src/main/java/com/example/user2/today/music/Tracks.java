package com.example.user2.today.music;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Tracks {
    @SerializedName("track")
    private List<Track> track;

    public Tracks(List<Track> track){
        this.track = track;
    }

    public void setTrack(List<Track> track){
        this.track = track;
    }

    public List<Track> getTracks(){
        return track;
    }
}
