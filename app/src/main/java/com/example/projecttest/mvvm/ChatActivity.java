package com.example.projecttest.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.projecttest.R;
import com.example.projecttest.bai1.OnProgressListener;
import com.example.projecttest.databinding.ActivityChatBinding;

import java.util.List;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private AppCompatButton button;
    private UserAdapter userAdapter;
    private UserViewModel userViewModel;
    private EditText editText1, editText2;
    private ActivityChatBinding activityChatBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityChatBinding = DataBindingUtil.setContentView(this, R.layout.activity_chat);
        recyclerView = findViewById(R.id.recyclerView);
        button = findViewById(R.id.btn_click);
        button.setOnClickListener(this::onClick);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getListMutableLiveData().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                userAdapter = new UserAdapter(users);
                recyclerView.setAdapter(userAdapter);
            }
        });
    }

    private void addUser() {
        User user = new User();
        activityChatBinding.setUser(user);
        userViewModel.addUser(user);
    }

    @Override
    public void onClick(View v) {
        addUser();
    }
}