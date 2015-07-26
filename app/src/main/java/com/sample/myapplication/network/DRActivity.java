package com.sample.myapplication.network;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by kalen on 15/7/25.
 */
public class DRActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DRApplication.getInstance().setCurrentActivity(this);
    }


}
