package com.example.user2.today;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.user2.today.database.Client;
import com.example.user2.today.database.Client_Holiday;
import com.example.user2.today.database.Service;
import com.example.user2.today.database.Service_Holiday;
import com.example.user2.today.fragment.DayFragment;
import com.example.user2.today.fragment.MusicFragment;
import com.example.user2.today.fragment.PoetryFragment;
import com.example.user2.today.fragment.WordFragment;
import com.example.user2.today.holiday.HolidayResponse;
import com.example.user2.today.holiday.Holidays;
import com.example.user2.today.music.Artist;
import com.example.user2.today.music.MusicAdapter;
import com.example.user2.today.music.MusicResponse;
import com.example.user2.today.music.Track;
import com.example.user2.today.music.Tracks;

import org.json.JSONObject;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class main extends AppCompatActivity implements
        DayFragment.OnfragmentInteractionListener, MusicFragment.OnfragmentInteractionListener,
        WordFragment.OnfragmentInteractionListener, PoetryFragment.OnfragmentInteractionListener {

    String musicName, musicDuration, musicArtist, musicImage;
    String holidayName;

    List<Track> tracks1 ;
    List<Holidays> holidays1;

    MusicFragment myFragment;
    DayFragment dayFragment;

    FragmentTransaction fragmentTransaction;

    private static FragmentManager fragmentManager;

    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadJSON();
        loadJSON2();

        bundle = new Bundle();

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, new DayFragment());
        fragmentTransaction.commit();

        fragmentManager = getSupportFragmentManager();

        BottomNavigationView navigation = findViewById(R.id.navigation);

        navigation.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment fragment = null;
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                dayFragment = new DayFragment();

                                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.frameLayout, dayFragment, "DAY_FRAGMENT");
                                fragmentTransaction.commit();

                                bundle = new Bundle();

                                bundle.putString("name", holidayName);
                                dayFragment.setArguments(bundle);

                                fragmentManager.beginTransaction().replace(R.id.frameLayout, dayFragment).commit();
                                break;
                            case R.id.navigation_music:
                                myFragment = new MusicFragment();

                                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.frameLayout, myFragment, "MY_FRAGMENT");
                                fragmentTransaction.commit();

                                bundle = new Bundle();

                                bundle.putString("name", musicName);
                                myFragment.setArguments(bundle);

                                fragmentManager.beginTransaction().replace(R.id.frameLayout, myFragment).commit();
                                break;
                            case R.id.navigation_word:
                                fragment = new WordFragment();
                                break;
                            case R.id.navigation_poetry:
                                fragment = new PoetryFragment();
                                break;
                        }
                        if (fragment != null) {
                            fragmentTransaction = getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.frameLayout, fragment, "MY_FRAGMENT");
                            fragmentTransaction.commit();
                        }
                        return true;
                    }
                });

    }

    private void loadJSON(){
        try{
            if (BuildConfig.THE_MUSIC_DB_API_TOKEN.isEmpty()){
                Toast.makeText(getApplicationContext(),"", Toast.LENGTH_LONG).show();
                //pd.dismiss();
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

                    musicName= tracks1.get(0).getName();


                }

                @Override
                public void onFailure(Call<MusicResponse> call, Throwable t){
                    Log.d("----", t.getMessage());
                    Toast.makeText(main.this,"-", Toast.LENGTH_LONG).show();
                }
            });
        }catch (Exception e){
            Log.d("-", e.getMessage());
            Toast.makeText(this, "/", Toast.LENGTH_LONG).show();
        }
    }

    private void loadJSON2(){
        try{
            if (BuildConfig.THE_HOLIDAY_DB_API_TOKEN.isEmpty()){
                Toast.makeText(getApplicationContext(),"", Toast.LENGTH_LONG).show();
                //pd.dismiss();
                return;
            }
            Client_Holiday Client_Holiday = new Client_Holiday();
            Service_Holiday apiService = Client_Holiday.getClient().create(Service_Holiday.class);
            Call<HolidayResponse> call = apiService.getHolidays( BuildConfig.THE_HOLIDAY_DB_API_TOKEN, "KZ","2016", "12");
            call.enqueue(new Callback<HolidayResponse>(){
                @Override
                public void onResponse(Call<HolidayResponse> call, Response<HolidayResponse> response) {
                    holidays1 = response.body().getHolidays();

                    holidayName = holidays1.get(0).getName();
                    Log.d("as","adad");
                }

                @Override
                public void onFailure(Call<HolidayResponse> call, Throwable t) {
                    Log.d("----", t.getMessage());
                    Toast.makeText(main.this,"-", Toast.LENGTH_LONG).show();
                }

            });
        }catch (Exception e){
            Log.d("-", e.getMessage());
            Toast.makeText(this, "/", Toast.LENGTH_LONG).show();
        }
    }
}
