package com.example.projecttest.modelView;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.projecttest.model.Book;
import com.example.projecttest.model.BookRespository;

import java.util.List;

public class BookModelView extends ViewModel {
    private BookRespository bookRespository;
    private LiveData<List<Book>> listLiveData;

    public BookModelView() {
        initData();
    }

    private void initData() {
        bookRespository = new BookRespository();
        listLiveData = bookRespository.getBookLiveData();
    }

    public void getBook(String title) {
        bookRespository.getAllBook(title);
    }

    public LiveData<List<Book>> getListLiveData() {
        return listLiveData;
    }

    public void getCharacter(Book book) {
        Log.d("TAG", book.getCharacter());
    }


}















