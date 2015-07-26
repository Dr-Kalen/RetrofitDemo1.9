package com.sample.myapplication.network;

import java.util.List;

/**
 * Created by kalen on 15/7/25.
 */
public class BaseSequenceType <T>  extends BaseHeader{


    private List<T> data;

    public List<T> getList(){
        return data;
    }


}
