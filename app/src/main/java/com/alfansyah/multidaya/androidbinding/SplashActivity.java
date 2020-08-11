package com.alfansyah.multidaya.androidbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {
    int waktu_loading = 3000;
    SharedPreferences sharedPreferences;
    private static final String SESSION_TERMS = "session_terms";
    public static Boolean terms = false;
    public static Boolean session = false;
    public static final String sharedPreference  = "myshared";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sharedPreferences = getSharedPreferences(sharedPreference, Context.MODE_PRIVATE);

        session = sharedPreferences.getBoolean(SESSION_TERMS, false);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
                boolean agreed = prefs.getBoolean("agreed", false);
                if (!agreed) {
                    Intent registerIntent = new Intent(SplashActivity.this, HomeActivity.class);
                    SplashActivity.this.startActivity(registerIntent);
                    finish();
                } else {
                    //setelah loading maka akan langsung berpindah ke home activity
                    Intent home=new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(home);
                    finish();
                }
            }
        }, waktu_loading);


    }

}