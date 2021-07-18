package com.example.projecttest.room.service;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.projecttest.BR;

@Entity(tableName = "SinhVien")
public class SinhVien extends BaseObservable {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    private String name;
    private int age;
    private String school;

    public SinhVien() {
    }

    public SinhVien(int id, String name, int age, String school) {
        Id = id;
        this.name = name;
        this.age = age;
        this.school = school;
    }

    @Bindable
    public int getId() {
        return Id;
    }

    @Bindable
    public void setId(int id) {
        Id = id;
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public int getAge() {
        return age;
    }

    @Bindable
    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.school);
    }

    @Bindable
    public String getSchool() {
        return school;
    }

    @Bindable
    public void setSchool(String school) {
        this.school = school;
        notifyPropertyChanged(BR.school);
    }
}
