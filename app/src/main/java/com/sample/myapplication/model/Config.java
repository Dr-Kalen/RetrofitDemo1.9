package com.sample.myapplication.model;

/**
 * Created by kalen on 15/7/24.
 */
public class Config {


    public Data data;

    public String message;

    class Data {

        String title;

        String content;

        @Override
        public String toString() {
            return title + ", " + content;
        }

    }

    @Override
    public String toString() {
        return data + ", " + message;
    }

}
