package com.example.projecttest.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.projecttest.room.service.SinhVien;
import com.example.projecttest.room.service.SinhVienDAO;

//@Database(entities = {SinhVien.class}, version = 1)
public abstract class SinhVienDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "sinhvien.db";
    private static SinhVienDatabase instance;

    public abstract SinhVienDAO sinhVienDAO();

    public static synchronized SinhVienDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), SinhVienDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

}
