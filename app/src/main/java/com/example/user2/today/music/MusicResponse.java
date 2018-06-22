package com.example.user2.today.music;

import com.google.gson.annotations.SerializedName;

public class MusicResponse {
    @SerializedName("tracks")
    private Tracks tracks;

    public MusicResponse(Tracks tracks){
        this.tracks = tracks;
    }

    public void setTracks(Tracks tracks){
        this.tracks = tracks;
    }

    public Tracks getTracks(){
        return tracks;
    }


}
