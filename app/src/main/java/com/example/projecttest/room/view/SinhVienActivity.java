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

public class SinhVienActivity extends AppCompatActivity implements ClickItemStudent, View.OnClickListener {
    private StudentViewModel sinhVienModelView;
    private SinhVienAdapter sinhVienAdapter;
    private ActivitySinhVienBinding binding;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sinh_vien);
        sinhVienModelView = ViewModelProviders.of(this).get(StudentViewModel.class);
        sinhVienAdapter = new SinhVienAdapter();
        sinhVienModelView.getMutableLiveData().observe(this, new Observer<List<SinhVien>>() {
            @Override
            public void onChanged(List<SinhVien> sinhViens) {
                sinhVienAdapter.setList(sinhViens);
                LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
                binding.rvStudent.setLayoutManager(manager);
                binding.rvStudent.setHasFixedSize(false);
                binding.rvStudent.setAdapter(sinhVienAdapter);

            }
        });
        binding.btnAdd.setOnClickListener(this::onClick);
        sinhVienAdapter.setClickItemStudent(this::clickItem);
        binding.btnDeleteall.setOnClickListener(this::onClick);


    }

    @Override
    public void clickItem(SinhVien sinhVien) {
        sinhVien.setSchool(binding.school.getText().toString());
        sinhVien.setName(binding.tensinhvien.getText().toString());
        sinhVien.setAge(Integer.parseInt(binding.age.getText().toString()));
        sinhVienModelView.updateSV(sinhVien);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                addSv();
                break;
            case R.id.btn_deleteall:
                delete();
                break;
            default:
                break;
        }
    }

    private void delete() {
        sinhVienModelView.deleteAll();
    }

    private void addSv() {
        SinhVien sinhVien = new SinhVien();
        sinhVien.setSchool(binding.school.getText().toString());
        sinhVien.setName(binding.tensinhvien.getText().toString());
        sinhVien.setAge(Integer.parseInt(binding.age.getText().toString()));
        sinhVienModelView.addUser(sinhVien);
    }

}