package com.sample.myapplication.ntools;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.widget.Toast;

/**
 * @author 柏江龙
 * @ClassName Tools
 * @Description 系统工具类
 * @date 2015-4-11
 */
public class NetworkTools {

    /**
     * 检查网络连接状态
     *
     * @return
     */
    public static boolean checkNetwork(Context context) {
        ConnectivityManager con = (ConnectivityManager) context.getSystemService(Activity.CONNECTIVITY_SERVICE);
        boolean wifi = con.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
        boolean internet = con.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting();
        if (wifi | internet) {
            return true;
        } else {
            Toast.makeText(context,
                    "亲，网络连了么？", Toast.LENGTH_LONG)
                    .show();
        }
        return false;
    }
}
