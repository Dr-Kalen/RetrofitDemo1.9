package com.sample.myapplication.model;

/**
 * Created by kalen on 15/7/24.
 */
public class Product {

    String addressName;

    String studentSex;

    String studentUrl;

    @Override
    public String toString() {
        return studentUrl + ", " + addressName;
    }


}
