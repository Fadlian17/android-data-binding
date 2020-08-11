package com.alfansyah.multidaya.androidbinding.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public abstract class BaseViewModel extends ViewModel {

    protected MutableLiveData<String> error = new MutableLiveData<>();
    protected MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    public MutableLiveData<String> getError() {
        return error;
    }

    public void setError(MutableLiveData<String> error) {
        this.error = error;
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public void setIsLoading(MutableLiveData<Boolean> isLoading) {
        this.isLoading = isLoading;
    }
}
