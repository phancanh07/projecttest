package com.example.projecttest.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.projecttest.model.Book;
import com.example.projecttest.retrofit.BookRetrofit;
import com.example.projecttest.retrofit.IBookApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookRespository {

    private IBookApi iBookApi;
    private MutableLiveData<List<Book>> bookMutableLiveData;

    public BookRespository() {
        bookMutableLiveData = new MutableLiveData<>();
        iBookApi = BookRetrofit.getClient().create(IBookApi.class);
    }

    public void getAllBook(String title) {
        iBookApi.getBook(title).enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if (response != null) {
                    bookMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                bookMutableLiveData.postValue(null);
            }
        });
    }


    public LiveData<List<Book>> getBookLiveData() {
        return bookMutableLiveData;
    }
}
