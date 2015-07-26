package com.sample.myapplication.network;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

/**
 * Created by kalen on 15/7/24.
 */
public class NetworkRequest {
    public static final String API_URL = "http://118.244.236.9/edrive_interface/api";


    public static Interfaces github;


    public static Interfaces getInstance() {
        if (github == null) {
            RestAdapter restAdapter = new RestAdapter.Builder().setProfiler(new DRProfiler()).setRequestInterceptor(interceptor).setEndpoint(API_URL).build();
            restAdapter.setLogLevel(RestAdapter.LogLevel.FULL);
            github = restAdapter.create(Interfaces.class);
        }
        return github;

    }


    private static RequestInterceptor interceptor = new RequestInterceptor() {
        @Override
        public void intercept(RequestFacade request) {
            request.addQueryParam("platform", "android");
        }
    };


}
