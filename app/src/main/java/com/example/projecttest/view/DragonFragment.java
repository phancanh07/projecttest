package com.example.projecttest.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projecttest.IonItemClick;
import com.example.projecttest.R;
import com.example.projecttest.adapter.BookAdapter;
import com.example.projecttest.databinding.FragmentDragonBinding;
import com.example.projecttest.model.Book;
import com.example.projecttest.modelView.BookModelView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DragonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DragonFragment extends Fragment implements IonItemClick {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    BookModelView bookModelView;
    BookAdapter bookAdapter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DragonFragment() {

    }

    public static DragonFragment newInstance(String param1, String param2) {
        DragonFragment fragment = new DragonFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentDragonBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dragon, container, false);
        View view = binding.getRoot();
        bookAdapter = new BookAdapter(getActivity());

        bookModelView = ViewModelProviders.of(this).get(BookModelView.class);
        bookModelView.getBook("boruto");
        bookModelView.getListLiveData().observe(getViewLifecycleOwner(), new Observer<List<Book>>() {
            @Override
            public void onChanged(List<Book> books) {
                bookAdapter.setBooks(books);
            }
        });
        bookAdapter.setIonItemClick(this::clickId);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        binding.rvBook.setLayoutManager(manager);
        binding.rvBook.setAdapter(bookAdapter);

        return view;
    }


    @Override
    public void clickId(Book book) {
        bookModelView.getCharacter(book);
    }
}