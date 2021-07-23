package com.example.projecttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.projecttest.adapter.MovieAdapter;
import com.example.projecttest.databinding.ActivityMovieBinding;
import com.example.projecttest.databinding.ActivitySinhVienBinding;
import com.example.projecttest.model.Example;
import com.example.projecttest.model.Result;
import com.example.projecttest.retrofit.BookRetrofit;
import com.example.projecttest.retrofit.Movie;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieActivity extends AppCompatActivity {
    ActivityMovieBinding movieBinding;
    MovieAdapter movieAdapter;
    LinearLayoutManager manager;
    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movieBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie);
        movieAdapter = new MovieAdapter(this);
        manager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        movieBinding.rvMovie.setLayoutManager(manager);
        movieBinding.rvMovie.setHasFixedSize(false);
        movie = BookRetrofit.getClient().create(Movie.class);
        movieBinding.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movie.getMovie(movieBinding.txtMovie.getText().toString()).enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        movieAdapter.setList(response.body().getResults());
                        movieBinding.rvMovie.setAdapter(movieAdapter);
                    }

                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                        Log.d("TAG", t.getMessage());
                    }
                });
            }
        });
    }
}