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
            "x-rapidapi-key:5b90733f73mshe1559e97ef4741fp15bd94jsn69f1be1d4946",
            "x-rapidapi-host:imdb8.p.rapidapi.com"
    })
//    Call<List<Book>> getBook(@Query("title") String title);

    @GET("title/find")
    Call<Example> getMovie(@Query("q") String title);
}
