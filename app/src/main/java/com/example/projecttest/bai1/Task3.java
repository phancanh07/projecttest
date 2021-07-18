package com.example.projecttest.bai1;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.URL;

public class Task3 extends AsyncTask<String, Void, Bitmap> {
    private Listesner listesner;
    ProgressDialog dialog;

    public Task3(Listesner listesner, Context context) {
        this.listesner = listesner;
        dialog = new ProgressDialog(context);
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        try{
            return BitmapFactory.decodeStream((InputStream) new URL(strings[0]).getContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog.setMessage("DOWLOAD IMAGE...");
        dialog.show();
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
        if (bitmap != null) {
            listesner.onImageLoad(bitmap);
        }
        else {
            listesner.onError();
        }
    }
}
