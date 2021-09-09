package com.android.example.beeline.models;

import android.widget.ImageView;

import java.io.Serializable;

public class Tarif implements Serializable {
    private String textTarif;
    private String imgTarif;
    private String moneyTxt;
    private String callTxt;
    private String netTxt;
    private String messTxt;

    public Tarif(String textTarif, String imgTarif, String moneyTxt, String callTxt, String netTxt, String messTxt) {
        this.textTarif = textTarif;
        this.imgTarif = imgTarif;
        this.moneyTxt = moneyTxt;
        this.callTxt = callTxt;
        this.netTxt = netTxt;
        this.messTxt = messTxt;
    }

    public String getTextTarif() {
        return textTarif;
    }

    public void setTextTarif(String textTarif) {
        this.textTarif = textTarif;
    }

    public String getImgTarif() {
        return imgTarif;
    }

    public void setImgTarif(String imgTarif) {
        this.imgTarif = imgTarif;
    }

    public String getMoneyTxt() {
        return moneyTxt;
    }

    public void setMoneyTxt(String moneyTxt) {
        this.moneyTxt = moneyTxt;
    }

    public String getCallTxt() {
        return callTxt;
    }

    public void setCallTxt(String callTxt) {
        this.callTxt = callTxt;
    }

    public String getNetTxt() {
        return netTxt;
    }

    public void setNetTxt(String netTxt) {
        this.netTxt = netTxt;
    }

    public String getMessTxt() {
        return messTxt;
    }

    public void setMessTxt(String messTxt) {
        this.messTxt = messTxt;
    }
}
