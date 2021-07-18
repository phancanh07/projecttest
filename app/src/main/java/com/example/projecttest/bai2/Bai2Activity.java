package com.example.projecttest.bai2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.projecttest.R;

public class Bai2Activity extends AppCompatActivity {
    AppCompatButton btn_get, btn_post;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        btn_get = findViewById(R.id.btn_get);
        btn_post = findViewById(R.id.btn_post);
        textView = findViewById(R.id.txt_txt);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext()).setSmallIcon(R.drawable.ic_launcher_background).setContentTitle("THÔNG BÁO");
        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PostTask postTask = new PostTask(textView);
                postTask.execute();
            }
        });
        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetTask getTask = new GetTask(textView);
                getTask.execute();
            }
        });

    }
}