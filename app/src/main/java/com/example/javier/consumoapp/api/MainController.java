package com.example.javier.consumoapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by javier on 17/06/17.
 */

public class MainController {
    public static final String URL = "http://jsonplaceholder.typicode.com/";

    private static final MainController ourInstance = new MainController();
    private static Retrofit mRetrofit;

    public static MainController getInstance(){ return ourInstance; }

    private MainController()
    {
         mRetrofit = new Retrofit.Builder()
                .baseUrl(URL)
                 .addConverterFactory(GsonConverterFactory.create())
                .build();


    }

    public  <T> T createService(Class<T>service){
        return mRetrofit.create(service);
    }

}
