package com.example.projecttest.bai1;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Task extends AsyncTask<String, String, String> {
    String resg;
    ProgressDialog dialog;
    TextView textView;
    EditText editText;
    Context context;

    public Task( TextView textView, EditText editText, Context context) {
        this.resg = resg;
        this.textView = textView;
        this.editText = editText;
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {
        publishProgress("Sleeping...");
        try {
            int time = Integer.parseInt(strings[0]) * 1000;
            Thread.sleep(time);
            resg = "Slept for " + strings[0] + "second";
        } catch (Exception e) {
            e.printStackTrace();
            resg = e.getMessage();
        }
        return resg;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = ProgressDialog.show(context, "ProgessDialog", "Wait for" + editText.getText().toString() + "SECOND");
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
        textView.setText(s);
    }
}

