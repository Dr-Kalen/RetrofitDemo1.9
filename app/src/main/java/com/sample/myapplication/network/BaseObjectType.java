package com.sample.myapplication.network;

/**
 * Created by kalen on 15/8/18.
 */
public class BaseObjectType<T> extends BaseHeader {

    public T data;

    public  T getObject(){
        return data;
    }

}
