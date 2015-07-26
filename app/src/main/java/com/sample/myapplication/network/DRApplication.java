package com.sample.myapplication.network;

import android.app.Activity;
import android.app.Application;

import java.lang.ref.WeakReference;

/**
 * Created by kalen on 15/7/25.
 */
public class DRApplication extends Application {

    private static DRApplication application;

    public DRApplication(){
        application = this;
    }
    public static DRApplication getInstance(){
        return application;
    }

    private  WeakReference<Activity> mRef;


    public void setCurrentActivity(Activity activity){
        mRef = new WeakReference<Activity>(activity);
    }




    public Activity getActivity() {
        return mRef.get();
    }

}
