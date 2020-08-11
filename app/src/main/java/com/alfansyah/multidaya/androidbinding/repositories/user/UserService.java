package com.alfansyah.multidaya.androidbinding.repositories.user;

import com.alfansyah.multidaya.androidbinding.models.DataItem;
import com.alfansyah.multidaya.androidbinding.models.DataUser;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {
    @GET("users")
    Call<DataUser> getUsers(@Query("?page") int page);

}
