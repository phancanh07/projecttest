package com.example.projecttest.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projecttest.IonItemClick;
import com.example.projecttest.R;
import com.example.projecttest.adapter.BookAdapter;
import com.example.projecttest.databinding.FragmentConanBinding;
import com.example.projecttest.model.Book;
import com.example.projecttest.modelView.BookModelView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ConanFragment extends Fragment implements IonItemClick {


    BookAdapter bookAdapter;
    BookModelView bookModelView;

    public ConanFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookAdapter = new BookAdapter(getActivity());
        bookModelView = ViewModelProviders.of(this).get(BookModelView.class);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentConanBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_conan, container, false);
        View view = binding.getRoot();
        bookModelView.getBook("cat");
        bookModelView.getListLiveData().observe(getViewLifecycleOwner(), new Observer<List<Book>>() {
            @Override
            public void onChanged(List<Book> books) {
                bookAdapter.setBooks(books);
            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        binding.rvConan.setLayoutManager(manager);
        binding.rvConan.setAdapter(bookAdapter);
        binding.rvConan.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        bookAdapter.setIonItemClick(this::clickId);
        return view;
    }


    @Override
    public void clickId(Book book) {
        bookModelView.getCharacter(book);
    }
}