package com.sample.myapplication.model;

import com.sample.myapplication.network.ParamName;

/**
 * Created by kalen on 15/7/24.
 */
public class Product {

    String addressName;

    String studentSex;

    @ParamName("studentUrl")
    String url;

    @Override
    public String toString() {
        return url + ", " + addressName;
    }


}
