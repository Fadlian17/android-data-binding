package com.alfansyah.multidaya.androidbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class UserActivity extends AppCompatActivity {
    TextView tvEmail, tvFullName;
    ImageView ivProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        tvEmail = findViewById(R.id.tvEmail);
        tvFullName = findViewById(R.id.tvFullName);
        ivProfile = findViewById(R.id.ivProfile);

        Bundle extras = getIntent().getExtras();
        tvFullName.setText(extras.getString("name_users"));
        tvEmail.setText(extras.getString("email_users"));
        Glide.with(getApplicationContext()).load(extras.getString("image_users"))
                .apply(RequestOptions.centerCropTransform()).into(ivProfile);

    }
}