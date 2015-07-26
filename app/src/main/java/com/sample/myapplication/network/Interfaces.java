package com.sample.myapplication.network;

import com.sample.myapplication.model.Config;
import com.sample.myapplication.model.Product;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by kalen on 15/7/26.
 */
public interface Interfaces {

    public static final String NAME = "name";


    @GET("/config/info")
    Config configInfo(@Query(NAME) String name, @Query("age") int age);

    @GET("/teacher/studentproduct/list?productType=1&teacherId=1266&page=1&rows=10")
    void list(Callback<BaseSequenceType<Product>> callback);

}
