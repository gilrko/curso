package com.example.javier.consumoapp.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by javier on 17/06/17.
 */

public class ApiController {
    public static final String URL = "http://jsonplaceholder.typicode.com/posts/1";

    public ApiController(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .build();

        IApi service = retrofit.create(IApi.class);

        Call<List<Post>> posts = service.listPost();
        posts.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> lista = response.body();
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }
}
