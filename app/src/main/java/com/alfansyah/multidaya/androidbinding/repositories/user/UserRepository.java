package com.alfansyah.multidaya.androidbinding.repositories.user;

import com.alfansyah.multidaya.androidbinding.utils.ClientUtil;

public class UserRepository {
    private static final String BASE_URL = "https://reqres.in/api/";

    public UserService service;

    public UserRepository() {
        service = ClientUtil.client(UserService.class, BASE_URL);
    }
}
