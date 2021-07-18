package com.example.projecttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.LinearLayout;

import com.example.projecttest.adapter.BookAdapter;
import com.example.projecttest.adapter.ViewPager;
import com.example.projecttest.databinding.ActivityBookBinding;
import com.example.projecttest.databinding.ActivityChatBinding;
import com.example.projecttest.model.Book;
import com.example.projecttest.modelView.BookModelView;

import java.util.List;

public class BookActivity extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBookBinding activityBookBinding = ActivityBookBinding.inflate(getLayoutInflater());
        setContentView(activityBookBinding.getRoot());
        viewPager = new ViewPager(getSupportFragmentManager());
        activityBookBinding.viewpager.setAdapter(viewPager);
    }
}