package com.example.projecttest.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecttest.IonItemClick;
import com.example.projecttest.R;
import com.example.projecttest.databinding.ItemBookBinding;
import com.example.projecttest.model.Book;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookAdapterHoder> {
    private List<Book> books;
    IonItemClick ionItemClick;
    Context context;

    public BookAdapter(Context context) {
        this.context = context;

    }

    public void setIonItemClick(IonItemClick ionItemClick) {
        this.ionItemClick = ionItemClick;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    @Override
    public BookAdapterHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemBookBinding itemBookBinding = ItemBookBinding.inflate(layoutInflater, parent, false);
        return new BookAdapterHoder(itemBookBinding);
    }

    @Override
    public void onBindViewHolder(BookAdapterHoder holder, int position) {
        Book book = books.get(position);
        holder.itemBookBinding.setBook(book);
        holder.itemBookBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        if (books != null) {
            return books.size();
        }
        return 0;
    }

    public class BookAdapterHoder extends RecyclerView.ViewHolder {
        ItemBookBinding itemBookBinding;

        public BookAdapterHoder(ItemBookBinding itemBookBinding) {
            super(itemBookBinding.getRoot());
            this.itemBookBinding = itemBookBinding;
            itemBookBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ionItemClick.clickId(books.get(getAdapterPosition()));
                }
            });
        }
    }


}
