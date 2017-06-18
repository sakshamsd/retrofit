package com.example.admin.retrofit.adapter;

import android.widget.EditText;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Admin on 5/21/2017.
 */

public class datalist implements Serializable {

    @SerializedName("name")
    String name;
    @SerializedName("address")
    String address;
    @SerializedName("mobile")
    String mobile;
    @SerializedName("email")
    String email;

    /*public datalist(String name, String address, String mobile, String email) {
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
    }*/


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
