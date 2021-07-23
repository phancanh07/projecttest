package com.example.projecttest.room.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Observable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.projecttest.ClickItemStudent;
import com.example.projecttest.R;
import com.example.projecttest.adapter.SinhVienAdapter;
import com.example.projecttest.databinding.ActivitySinhVienBinding;
import com.example.projecttest.model.Book;
import com.example.projecttest.model.Result;
import com.example.projecttest.modelView.StudentViewModel;
import com.example.projecttest.retrofit.BookRetrofit;
import com.example.projecttest.retrofit.Movie;
import com.example.projecttest.room.service.SinhVien;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SinhVienActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivitySinhVienBinding binding;
    StudentModel studentModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sinh_vien);
        studentModel = ViewModelProviders.of(this).get(StudentModel.class);
        binding.btnAdd.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        SinhVien sinhVien = new SinhVien();
        sinhVien.setSchool(binding.school.getText().toString());
        sinhVien.setName(binding.tensinhvien.getText().toString());
        sinhVien.setAge(Integer.parseInt(binding.age.getText().toString()));
        binding.setSinhVien(sinhVien);
        studentModel.addList(sinhVien);
    }


}