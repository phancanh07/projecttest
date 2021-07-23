package com.example.projecttest.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;


import java.util.List;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Result extends BaseObservable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("principals")
    @Expose
    private List<Principal> principals = null;
    @SerializedName("runningTimeInMinutes")
    @Expose
    private Integer runningTimeInMinutes;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("titleType")
    @Expose
    private String titleType;
    @SerializedName("year")
    @Expose
    private Integer year;

    @Bindable
    public String getId() {
        return id;
    }

    @Bindable
    public void setId(String id) {
        this.id = id;

    }

    @Bindable
    public Image getImage() {
        return image;
    }

    @Bindable
    public void setImage(Image image) {
        this.image = image;

    }

    @Bindable
    public List<Principal> getPrincipals() {
        return principals;
    }

    @Bindable
    public void setPrincipals(List<Principal> principals) {
        this.principals = principals;

    }

    @Bindable
    public Integer getRunningTimeInMinutes() {
        return runningTimeInMinutes;
    }

    @Bindable
    public void setRunningTimeInMinutes(Integer runningTimeInMinutes) {
        this.runningTimeInMinutes = runningTimeInMinutes;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

}