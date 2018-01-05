package com.example.javier.consumoapp.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by javier on 17/06/17.
 */

public interface IApi {
    @GET("posts/")
    Call<List<Post>>listPost();

    @GET("posts/{id}")
    Call<Post> post(@Path("id") int idPost);

}
