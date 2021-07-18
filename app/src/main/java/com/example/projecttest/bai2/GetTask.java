package com.example.projecttest.bai2;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class GetTask extends AsyncTask<String, Integer, String> {
    private TextView textView;

    public GetTask(TextView textView) {
        this.textView = textView;
    }

    String link = "https://jsonplaceholder.typicode.com/todos/1";

    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url = new URL(link);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            Scanner scanner = new Scanner(httpsURLConnection.getInputStream());

            String data = "";
            while (scanner.hasNext()) {
                data += scanner.nextLine();
                Log.d("TAG", data);

            }
            return data;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONArray jsonArray = new JSONArray(s);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String titel = jsonObject.getString("title");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        textView.setText(s);
    }
}
