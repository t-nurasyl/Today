package com.example.user2.today;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Thread background = new Thread() {
            public void run() {

                try {
                    sleep(5*1000);

                    Intent i=new Intent(getBaseContext(),main.class);
                    startActivity(i);

                    finish();

                } catch (Exception e) {

                }
            }
        };
        background.start();
    }
    @Override
    protected void onDestroy() {

        super.onDestroy();

    }
}
