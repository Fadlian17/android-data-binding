package com.alfansyah.multidaya.androidbinding.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alfansyah.multidaya.androidbinding.models.DataPost;
import com.alfansyah.multidaya.androidbinding.repositories.post.PostRepository;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {

    private MutableLiveData<ArrayList<DataPost>> posts = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private MutableLiveData<String> error = new MutableLiveData<>();
    private ArrayList<DataPost> temp = new ArrayList<>();

    public PostViewModel() {
        fetchPosts();
    }

    private void fetchPosts() {
        isLoading.setValue(true);

        PostRepository.client().getPosts().enqueue(new Callback<ArrayList<DataPost>>() {
            @Override
            public void onResponse(Call<ArrayList<DataPost>> call, Response<ArrayList<DataPost>> response) {
                if (response.isSuccessful()) {
                    posts.setValue(response.body());

                    temp = posts.getValue();
                } else {
                    error.setValue(response.message());
                }

                isLoading.setValue(false);
            }

            @Override
            public void onFailure(Call<ArrayList<DataPost>> call, Throwable t) {
                t.printStackTrace();

                error.setValue(t.getMessage());

                isLoading.setValue(false);
            }
        });

    }

    //search by name
    public void searchPost(CharSequence s) {
        ArrayList<DataPost> postModels = new ArrayList<>();

        if (posts.getValue() != null) {
            for (DataPost post : temp) {
                if (post.getTitle().toLowerCase().contains(s) ||
                        post.getBody().toLowerCase().contains(s)) {

                    postModels.add(post);
                }
            }

            posts.setValue(postModels);
        }
    }

    public LiveData<ArrayList<DataPost>> getPosts() {
        return posts;
    }

    public LiveData<String> getError() {
        return error;
    }

    public LiveData<Boolean> isLoading() {
        return isLoading;
    }
}
