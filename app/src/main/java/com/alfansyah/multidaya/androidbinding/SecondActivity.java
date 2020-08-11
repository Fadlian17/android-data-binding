package com.alfansyah.multidaya.androidbinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.alfansyah.multidaya.androidbinding.adapters.UsersAdapter;
import com.alfansyah.multidaya.androidbinding.models.DataUser;
import com.alfansyah.multidaya.androidbinding.repositories.user.UserRepository;
import com.alfansyah.multidaya.androidbinding.repositories.user.UserService;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity {

    ProgressBar pbLoading;
    TextView tvEmail, tvFullName;
    ImageView ivProfile;
    EditText etSearch;
    RecyclerView rvUsers;
    RecyclerView.Adapter adapter;
    UserService service;
    UsersAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);


        pbLoading = findViewById(R.id.pbLoading);
        tvEmail = findViewById(R.id.tvEmail);
        tvFullName = findViewById(R.id.tvFullName);
        rvUsers = findViewById(R.id.rvUsers);
        ivProfile = findViewById(R.id.ivProfile);
        etSearch = findViewById(R.id.etSearch);

        usersAdapter = new UsersAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvUsers.setLayoutManager(layoutManager);

        UserRepository userRepository = new UserRepository();

        searchData();


        userRepository.service.getUsers(1).enqueue(new Callback<DataUser>() {
            @Override
            public void onResponse(Call<DataUser> call, Response<DataUser> response) {
                showLoading(false);
                if(response.isSuccessful()){
                    if (response.body() != null) {
                        String jsonResponse = new Gson().toJson(response.body());
                        usersAdapter.setUsersAdapter(SecondActivity.this, response.body().getData());
                        rvUsers.setAdapter(usersAdapter);

                    }
                }
            }

            @Override
            public void onFailure(Call<DataUser> call, Throwable t) {
                t.printStackTrace();
//                showLoading(false);

                Toast.makeText(SecondActivity   .this, "Error\n"+t.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }


    private void searchData(){
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                usersAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                usersAdapter.getFilter().filter(charSequence);

            }

            @Override
            public void afterTextChanged(Editable editable) {
                usersAdapter.getFilter().filter(editable);
            }
        });
    }

    private void showLoading(boolean isLoading) {
        if (isLoading) {
            pbLoading.setVisibility(View.VISIBLE);
        } else {
            pbLoading.setVisibility(View.GONE);
        }
    }
}