package com.example.projecttest.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projecttest.IonItemClick;
import com.example.projecttest.R;
import com.example.projecttest.adapter.BookAdapter;
import com.example.projecttest.databinding.FragmentCatBinding;
import com.example.projecttest.model.Book;
import com.example.projecttest.modelView.BookModelView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CatFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    BookAdapter bookAdapter;
    BookModelView bookModelView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CatFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CatFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CatFragment newInstance(String param1, String param2) {
        CatFragment fragment = new CatFragment();
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
        FragmentCatBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cat, container, false);
        View view = binding.getRoot();
        bookAdapter = new BookAdapter(getActivity());

        bookModelView = ViewModelProviders.of(this).get(BookModelView.class);
        bookModelView.getListLiveData().observe(getViewLifecycleOwner(), new Observer<List<Book>>() {
            @Override
            public void onChanged(List<Book> books) {
                bookAdapter.setBooks(books);
            }
        });
        bookModelView.getBook("doraemon");
        binding.rvCat.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        binding.rvCat.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        binding.rvCat.setAdapter(bookAdapter);
        bookAdapter.setIonItemClick(new IonItemClick() {
            @Override
            public void clickId(Book book) {
                bookModelView.getCharacter(book);
            }
        });
        return view;
    }

}