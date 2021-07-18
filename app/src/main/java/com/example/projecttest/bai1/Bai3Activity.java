package com.example.projecttest.bai1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projecttest.R;

public class Bai3Activity extends AppCompatActivity implements View.OnClickListener ,Listesner{
    TextView textView;
    AppCompatButton button;
    ImageView imageView;
    private  static String URL = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Cristiano_Ronaldo_2018.jpg/200px-Cristiano_Ronaldo_2018.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        imageView = findViewById(R.id.imageebai3);
        button = findViewById(R.id.load3);
        textView = findViewById(R.id.textView3);
        button.setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View v) {
        new Task3(this,this).execute(URL);
    }

    @Override
    public void onImageLoad(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }

    @Override
    public void onError() {

    }
}