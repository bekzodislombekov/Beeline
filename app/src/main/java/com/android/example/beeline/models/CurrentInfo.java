package com.android.example.beeline.models;

public class CurrentInfo {
    private int img;
    private String des;
    private String money;

    public CurrentInfo(int img, String des, String money) {
        this.img = img;
        this.des = des;
        this.money = money;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
