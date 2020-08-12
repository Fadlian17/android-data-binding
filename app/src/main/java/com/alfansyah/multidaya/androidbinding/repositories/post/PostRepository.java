package com.alfansyah.multidaya.androidbinding.repositories.post;

import com.alfansyah.multidaya.androidbinding.repositories.user.UserService;
import com.alfansyah.multidaya.androidbinding.utils.ClientUtil;

public class PostRepository {
    public static PostService client() {
        return ClientUtil.client(PostService.class,"http://jsonplaceholder.typicode.com/");
    }
}
