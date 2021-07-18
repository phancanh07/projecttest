package com.example.projecttest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projecttest.R;
import com.example.projecttest.databinding.ItemBookBinding;
import com.example.projecttest.databinding.ItemMovieBinding;
import com.example.projecttest.model.Result;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieAdapterHolder> {
    private List<Result> list;
    private Context context;

    public void setList(List<Result> list) {
        this.list = list;
    }

    public MovieAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MovieAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MovieAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieAdapterHolder holder, int position) {
        Result result = list.get(position);
        holder.textView.setText(result.getTitle() + "");
        holder.textView1.setText(result.getYear() + "");
        if (result.getImage() != null) {
            Glide.with(context).load(result.getImage().getUrl()).into(holder.imageView);
        }

    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class MovieAdapterHolder extends RecyclerView.ViewHolder {
        private TextView textView, textView1;
        private ImageView imageView;

        public MovieAdapterHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.tenphim);
            textView1 = view.findViewById(R.id.txt_year);
            imageView = view.findViewById(R.id.img_movie);
        }
    }
}
