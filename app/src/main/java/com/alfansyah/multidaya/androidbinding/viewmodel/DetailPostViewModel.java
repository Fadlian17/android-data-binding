package com.alfansyah.multidaya.androidbinding.viewmodel;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.alfansyah.multidaya.androidbinding.models.DataPost;

public class DetailPostViewModel extends ViewModel {
    public ObservableField<DataPost> post = new ObservableField<>();

    public DetailPostViewModel(DataPost dataPost){
        post.set(dataPost);
    }
}
