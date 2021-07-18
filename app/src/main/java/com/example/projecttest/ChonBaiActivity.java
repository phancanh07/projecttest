package com.example.projecttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projecttest.bai1.Bai3Activity;
import com.example.projecttest.bai1.Bai4Activity;
import com.example.projecttest.bai1.MainActivity;
import com.example.projecttest.bai1.SplassActivity;

public class ChonBaiActivity extends AppCompatActivity implements View.OnClickListener {
    private AppCompatButton bai1, bai2, bai3, bai4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_bai);
        bai1 = findViewById(R.id.bai1);
        bai2 = findViewById(R.id.bai2);
        bai3 = findViewById(R.id.bai3);
        bai4 = findViewById(R.id.bai4);
        bai1.setOnClickListener(this::onClick);
        bai2.setOnClickListener(this::onClick);
        bai3.setOnClickListener(this::onClick);
        bai4.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bai1:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.bai2:
                startActivity(new Intent(this, SplassActivity.class));
                break;
            case R.id.bai3:
                startActivity(new Intent(this, Bai3Activity.class));
                break;
            case R.id.bai4:
                startActivity(new Intent(this, Bai4Activity.class));
                break;

        }
    }
}