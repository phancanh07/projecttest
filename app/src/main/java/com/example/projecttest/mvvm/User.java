package com.example.projecttest.mvvm;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.projecttest.BR;

public class User extends BaseObservable {
    private String userName;
    private String chat;

    public User(String userName, String chat) {
        this.userName = userName;
        this.chat = chat;
    }

    public User() {

    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    @Bindable
    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }

    @Bindable
    public String getChat() {
        return chat;
    }

    @Bindable
    public void setChat(String chat) {
        this.chat = chat;
        notifyPropertyChanged(BR.chat);
    }
}
