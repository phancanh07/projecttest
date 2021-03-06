package com.example.projecttest.retrofit;

import com.example.projecttest.model.Book;
import com.example.projecttest.model.Example;
import com.example.projecttest.model.Result;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface Movie {
    @Headers({
            "x-rapidapi-key:b7e8a17869msh6e5c22f43627820p13e688jsna8896ebf1115",
            "x-rapidapi-host:imdb8.p.rapidapi.com"
    })
//    Call<List<Book>> getBook(@Query("title") String title);

    @GET("title/find")
    Call<Example> getMovie(@Query("q") String title);
}
