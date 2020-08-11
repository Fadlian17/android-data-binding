package com.alfansyah.multidaya.androidbinding.repositories.post;

import com.alfansyah.multidaya.androidbinding.repositories.user.UserService;
import com.alfansyah.multidaya.androidbinding.utils.ClientUtil;

public class PostRepository {
    private static final String BASE_URL = "http://jsonplaceholder.typicode.com/";

    public UserService service;

    public PostRepository() {
        service = ClientUtil.client(UserService.class, BASE_URL);
    }
}
