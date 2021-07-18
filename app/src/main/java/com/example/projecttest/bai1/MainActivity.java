package com.example.projecttest.bai1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.projecttest.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    AppCompatButton button;
    ImageView imageView;
    TextView textView;
    ProgressDialog dialog;
    Bitmap bitmap = null;
    public static String url = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Cristiano_Ronaldo_2018.jpg/200px-Cristiano_Ronaldo_2018.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imagee);
        button = findViewById(R.id.load);
        button.setOnClickListener(this::onClick);
        textView = findViewById(R.id.textView);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Log.d("TAG","ĐÃ CHẠY0");
            Bundle bundle = msg.getData();
            String s = bundle.getString("KEY");
            textView.setText(s);
            imageView.setImageBitmap(bitmap);
            dialog.dismiss();
        }
    };


    private Bitmap bitmap(String link) {
        try {
            URL url = new URL(link);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.connect();
            InputStream inputStream = httpsURLConnection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void onClick(View v) {
        dialog = ProgressDialog.show(this, "", "DOWLOADING...");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                bitmap = bitmap(url);
                Message message = handler.obtainMessage();
                Bundle bundle = new Bundle();
                String thred = "IMAGE DOWLOAD";
                bundle.putString("KEY", thred);
                message.setData(bundle);
                handler.sendMessage(message);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}