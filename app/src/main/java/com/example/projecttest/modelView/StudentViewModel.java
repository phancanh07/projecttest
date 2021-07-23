package com.example.projecttest.modelView;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.projecttest.room.SinhVienDatabase;
import com.example.projecttest.room.service.SinhVien;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class StudentViewModel extends AndroidViewModel {
    public StudentViewModel(@NonNull Application application) {
        super(application);
    }
//    private MutableLiveData<List<SinhVien>> mutableLiveData;
//    private SinhVienDatabase sinhVienDatabas;
//    List<SinhVien> list;
//
//    public StudentViewModel(Application application) {
//        super(application);
//        mutableLiveData = new MutableLiveData<>();
//        sinhVienDatabas = SinhVienDatabase.getInstance(application);
//        mutableLiveData.setValue(sinhVienDatabas.sinhVienDAO().getAllstudent());
//    }
//
//    public MutableLiveData<List<SinhVien>> getMutableLiveData() {
//        return mutableLiveData;
//    }
//
//    public void addUser(SinhVien sinhVien) {
//        sinhVienDatabas.sinhVienDAO().insertStudent(sinhVien);
//        mutableLiveData.setValue(sinhVienDatabas.sinhVienDAO().getAllstudent());
//    }
//
//    public void deleteAll() {
//        sinhVienDatabas.sinhVienDAO().deleteAll();
//        mutableLiveData.setValue(sinhVienDatabas.sinhVienDAO().getAllstudent());
//    }
//
//    public void delteItem(SinhVien sinhVien) {
//        sinhVienDatabas.sinhVienDAO().deleteItem(sinhVien);
//        mutableLiveData.setValue(sinhVienDatabas.sinhVienDAO().getAllstudent());
//    }
//
//
//    public void updateSV(SinhVien sinhVien) {
//        sinhVienDatabas.sinhVienDAO().Update(sinhVien);
//        mutableLiveData.setValue(sinhVienDatabas.sinhVienDAO().getAllstudent());
//    }
}
