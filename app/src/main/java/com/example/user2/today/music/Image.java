package com.example.user2.today.music;
import com.google.gson.annotations.SerializedName;

public class Image {
    @SerializedName("#text")
    private String text;
    @SerializedName("size")
    private String size;

    public Image(String text, String size){
        this.text = text;
        this.size = size;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public void setSize(String size){
        this.size = size;
    }

    public String getSize(){
        return size;
    }
}
