package com.example.user2.today.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.bumptech.glide.Glide;
import com.example.user2.today.BuildConfig;
import com.example.user2.today.R;
import com.example.user2.today.database.Client;
import com.example.user2.today.database.Service;
import com.example.user2.today.main;
import com.example.user2.today.music.Artist;
import com.example.user2.today.music.Image;
import com.example.user2.today.music.MusicResponse;
import com.example.user2.today.music.Track;
import com.example.user2.today.music.Tracks;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Intent.getIntent;

public class MusicFragment extends Fragment{
    List<Track> tracks1;
    TextView title;
    TextView duration;

    public MusicFragment(){

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        Bundle bundle= getArguments();
//        String username= bundle.getString("username");
//        String token = bundle.getString("token");

//        SharedPreferences preferences=getActivity().getSharedPreferences("myPref", Context.MODE_PRIVATE);
//        String name =preferences.getString("name","");
//        String token = preferences.getString("duration","");
          //        title.setText("SHIT");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music, container, false);
        title = view.findViewById(R.id.textView);
        String username = this.getArguments().getString("name").toString();
//        String token = bundle.getString("token");
        System.out.println(username);

        title.setText(username);

        return view;
    }

    public interface OnfragmentInteractionListener {}

    public void initViews(){}

    private void loadJSON(){
        try{
            if (BuildConfig.THE_MUSIC_DB_API_TOKEN.isEmpty()){
                Toast.makeText(getContext(),"-",Toast.LENGTH_LONG).show();
                return;
            }
            Client Client = new Client();
            Service apiService = Client.getClient().create(Service.class);
            Call<MusicResponse> call = apiService.getPopularMusics("chart.gettoptracks",BuildConfig.THE_MUSIC_DB_API_TOKEN, "json");
            call.enqueue(new Callback<MusicResponse>(){
                @Override
                public void onResponse(Call<MusicResponse> call, Response<MusicResponse> response) {
                    Tracks tracks = response.body().getTracks();
                    tracks1 = tracks.getTracks();
                    Log.e("Track name",tracks1.get(0).getName());
                }

                @Override
                public void onFailure(Call<MusicResponse> call, Throwable t){
                    Log.d("----", t.getMessage());
                    }
            });
        }catch (Exception e){
            Log.d("-", e.getMessage());
            }
    }

}
