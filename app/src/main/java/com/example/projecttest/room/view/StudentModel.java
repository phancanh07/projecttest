package com.example.projecttest.room.view;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.projecttest.room.service.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class StudentModel extends ViewModel {
    private MutableLiveData<List<SinhVien>> listMutableLiveData;
    private List<SinhVien> list;

    public StudentModel() {
        list = new ArrayList<>();
        listMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<SinhVien>> getMutableLiveData() {
        return listMutableLiveData;
    }

    public void addList(SinhVien sinhVien) {
        list.add(sinhVien);
        listMutableLiveData.postValue(list);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
