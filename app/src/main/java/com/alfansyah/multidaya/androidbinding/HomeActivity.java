package com.alfansyah.multidaya.androidbinding;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    Button btnOne, btnTwo;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sharedPreferences = getSharedPreferences(SplashActivity.sharedPreference, Context.MODE_PRIVATE);
        showTerms();
        btnOne = (Button) findViewById(R.id.nb_one);
        btnTwo = (Button) findViewById(R.id.nb_two);

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showTerms() {
        View termsView;
        LayoutInflater inflater;


        inflater = getLayoutInflater();
        termsView = inflater.inflate(R.layout.dialog_custome, null);

        AlertDialog alertDialog = new AlertDialog.Builder(HomeActivity.this).create();
        alertDialog.setTitle("SYARAT DAN KETENTUAN");
        alertDialog.setView(termsView);

        alertDialog.show();
    }
}