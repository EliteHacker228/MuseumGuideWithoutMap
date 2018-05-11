package com.example.max.mainwindow.museumpackage;

import android.graphics.Bitmap;

public class Museum {
    //Класс музея
    String mname;
    String adress;
    String phone;
    String URL;
    String website;
    String trivia;
    Bitmap poster;


    public Museum(String mname, String adress, String phone, String URL, String website, String trivia) {
        this.mname = mname;
        this.adress = adress;
        this.phone = phone;
        this.URL = URL;
        this.website = website;
        this.trivia=trivia;
    }



    public Bitmap getPoster() {
        return poster;
    }

    public void setPoster(Bitmap poster) {
        this.poster = poster;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }


    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTrivia() {
        return trivia;
    }

    public void setTrivia(String trivia) {
        this.trivia = trivia;
    }
}
