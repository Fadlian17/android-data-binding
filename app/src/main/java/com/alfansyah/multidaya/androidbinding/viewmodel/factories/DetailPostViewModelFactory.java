package com.alfansyah.multidaya.androidbinding.viewmodel.factories;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.alfansyah.multidaya.androidbinding.models.DataPost;
import com.alfansyah.multidaya.androidbinding.viewmodel.DetailPostViewModel;

import java.lang.reflect.InvocationTargetException;

public class DetailPostViewModelFactory implements ViewModelProvider.Factory {

    private DataPost dataPost;

    public DetailPostViewModelFactory(DataPost dataPost) {
        this.dataPost = dataPost;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        try {
            return modelClass.getConstructor(DataPost.class).newInstance(dataPost);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return (T) new DetailPostViewModel(new DataPost());
    }
}
