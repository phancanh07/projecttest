package com.example.projecttest.bai1;

import android.os.AsyncTask;
import android.util.Log;

public class MyTask extends AsyncTask<String, Integer, String> implements OnProgressListener {
    OnProgressListener onProgressListener;

    public void setOnProgressListener(OnProgressListener onProgressListener) {
        this.onProgressListener = onProgressListener;
    }

    //phương thức thraect
    @Override
    protected String doInBackground(String... strings) {
        for (int i = 0; i < 100; i++) {
            onProgressListener.OnProgress(i);
            try {
                Thread.sleep(10);
                Log.d("TAG", "lêu lêu1");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Log.d("TAG", "lêu lêu2");
        return null;
    }

    //kết thúc thresh
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d("TAG", "lêu lêu kết thúc");
    }

    //cập nhật tiến trình
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.d("TAG", "lêu lêu cập nhật" +values +"ádas");
    }

    //hàm dc chạy trc khi start
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d("TAG", "lêu lêu bắt đầu");
    }

    @Override
    public void OnProgress(int progess) {

    }
}
