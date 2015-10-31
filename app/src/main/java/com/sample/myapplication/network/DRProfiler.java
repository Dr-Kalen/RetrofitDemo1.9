package com.sample.myapplication.network;

import android.app.Activity;
import android.os.Handler;
import android.widget.Toast;

import com.sample.myapplication.ntools.NetworkTools;

import retrofit.Profiler;

/**
 * Created by kalen on 15/7/25.
 */
public class DRProfiler implements Profiler {

    public Activity getActivity() {
        return DRApplication.getInstance().getActivity();
    }

//    private ProgressDialog dialog;

    @Override
    public Object beforeCall() {


        handler.post(new Runnable() {
            @Override
            public void run() {
                Activity context = getActivity();
                if (context == null) {
                    return;
                }
                if (!NetworkTools.checkNetwork(context)) {
                    Toast.makeText(context, "网络失败", Toast.LENGTH_SHORT).show();
                }

//                Toast.makeText(context, "before", Toast.LENGTH_SHORT).show();
//                dialog = ProgressDialog.show(context, "提示", "正在加载..", false);
            }
        });
        return null;
    }

    private Handler handler = new Handler();


    @Override
    public void afterCall(RequestInformation requestInfo, long elapsedTime, int statusCode, Object beforeCallData) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Activity context = getActivity();
                if (context == null) {
                    return;
                }
//                Toast.makeText(context, "after", Toast.LENGTH_SHORT).show();
//                dialog.dismiss();
            }
        });

    }
}
