package com.alfansyah.multidaya.androidbinding.repositories.post;


import com.alfansyah.multidaya.androidbinding.models.DataPost;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {
    @GET("posts")
    Call<ArrayList<DataPost>> getPosts();
}
