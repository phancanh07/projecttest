package com.example.projecttest.retrofit;

import com.example.projecttest.model.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IBookApi {
    @GET("api/quotes/anime")
    Call<List<Book>> getBook(@Query("title") String title);

}
