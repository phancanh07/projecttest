package com.example.projecttest.bai1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.projecttest.R;

public class Bai4Activity extends AppCompatActivity implements View.OnClickListener {
    AppCompatButton button;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        editText = findViewById(R.id.txt_sleep);
        textView = findViewById(R.id.slepp);
        button = findViewById(R.id.btn_sleep);
        button.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        Task task = new Task(textView, editText, this);
        String sleeping = editText.getText().toString();
        task.execute(sleeping);
    }
}