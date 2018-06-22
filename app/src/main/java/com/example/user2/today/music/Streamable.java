package com.example.user2.today.music;
import com.google.gson.annotations.SerializedName;

public class Streamable {
    @SerializedName("text")
    private String text;
    @SerializedName("fulltrack")
    private String fulltrack;

    public Streamable(String text, String fulltrack){
        this.text = text;
        this.fulltrack = fulltrack;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public void setFulltrack(String fulltrack){
        this.fulltrack = fulltrack;
    }

    public String getFulltrack(){
        return fulltrack;
    }
}
