package com.sample.myapplication.network;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Field;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by kalen on 15/7/24.
 */
public class NetworkRequest {
    public static final String API_URL = "http://118.244.236.9/edrive_interface/api";


    public static Interfaces github;


    public static Interfaces getInstance() {
        if (github == null) {
            GsonBuilder builder = new GsonBuilder();
            builder.setFieldNamingStrategy(new AnnotateNaming());
            Gson gson = builder.create();


            RestAdapter restAdapter = new RestAdapter.Builder().setProfiler(new DRProfiler()).setRequestInterceptor(interceptor).setEndpoint(API_URL).setConverter(new GsonConverter(gson)).build();
            restAdapter.setLogLevel(RestAdapter.LogLevel.FULL);
            github = restAdapter.create(Interfaces.class);
        }
        return github;

    }


    private static class AnnotateNaming implements FieldNamingStrategy {

        @Override
        public String translateName(Field field) {
            ParamName a = field.getAnnotation(ParamName.class);
            return a != null ? a.value() : FieldNamingPolicy.IDENTITY.translateName(field);
        }
    }



    private static RequestInterceptor interceptor = new RequestInterceptor() {
        @Override
        public void intercept(RequestFacade request) {
            request.addQueryParam("platform", "android");
        }
    };


}
