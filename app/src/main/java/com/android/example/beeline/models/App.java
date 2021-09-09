package com.android.example.beeline.models;

import android.media.Image;

import java.util.List;

public class App {
    private String name;
    private String des;
    private List<String> imageList;

    public App(String name, String des, List<String> imageList) {
        this.name = name;
        this.des = des;
        this.imageList = imageList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }
}
