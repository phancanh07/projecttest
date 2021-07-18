package com.example.projecttest.bai2;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class PostTask extends AsyncTask<String, Integer, String> {
    TextView textView;

    public PostTask(TextView textView) {
        this.textView = textView;
    }

    String link = "https://jsonplaceholder.typicode.com/posts";

    @Override
    protected String doInBackground(String... strings) {
        String data = "";
        String tittle = "HI";
        String body = "PHAN CANH";
        String id = "123";
        try {
            URL url = new URL(link);
            HttpURLConnection httpURLConnection = (HttpURLConnection)
                    url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            //Content-Type: application/x-www-form-urlencoded
            httpURLConnection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            // khoi tao param
            StringBuilder params = new StringBuilder();

            params.append("title");
            params.append("=");
            params.append(tittle);

            params.append("&");
            params.append("body");
            params.append("=");
            params.append(body);

            params.append("&");
            params.append("userId");
            params.append("=");
            params.append(id);

            OutputStream os = httpURLConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter
                    (new OutputStreamWriter(os, "UTF-8"));

            // dua param vao body cua request
            writer.append(params);

            // giai phong bo nho
            writer.flush();
            // ket thuc truyen du lieu vao output
            writer.close();
            os.close();

            // lay du lieu tra ve
            StringBuilder response = new StringBuilder();

            InputStream inputStream = httpURLConnection.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }

            return response.toString();

        } catch (Exception e) {
            Log.e("ABC", e.getMessage());
        }
        return data;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONObject jsonObject = new JSONObject(s);
            String titel = jsonObject.getString("title");
            textView.setText(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
