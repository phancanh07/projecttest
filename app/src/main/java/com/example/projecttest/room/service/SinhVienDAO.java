package com.example.projecttest.room.service;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.projecttest.room.service.SinhVien;

import java.util.List;

@Dao
public interface SinhVienDAO {
    @Query("SELECT * FROM SinhVien")
    List<SinhVien> getAllstudent();

    @Insert
    void insertStudent(SinhVien sinhVien);

    @Query("DELETE FROM SinhVien")
    void deleteAll();

    @Delete()
    void deleteItem(SinhVien sinhVien);

    @Update()
    void Update(SinhVien sinhVien);
}
