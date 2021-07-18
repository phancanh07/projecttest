package com.example.projecttest.mvvm;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel extends ViewModel {
    private MutableLiveData<List<User>> listMutableLiveData;
    private List<User> list;

    public UserViewModel() {
        listMutableLiveData = new MutableLiveData<>();
        initData();
    }

    private void initData() {
        list = new ArrayList<>();
        listMutableLiveData.setValue(list);

    }

    public MutableLiveData<List<User>> getListMutableLiveData() {
        return listMutableLiveData;
    }


    public void addUser(User user) {
        list.add(user);
        listMutableLiveData.setValue(list);
    }
}
