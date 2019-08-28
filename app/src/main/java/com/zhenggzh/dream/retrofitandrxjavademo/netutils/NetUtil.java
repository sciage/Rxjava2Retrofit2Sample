package com.zhenggzh.dream.retrofitandrxjavademo.netutils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.zhenggzh.dream.retrofitandrxjavademo.app.BaseApplication;


/**
 * Created by 眼神 on 2018/3/27.
 * 网络请求工具类
 */
public class NetUtil {

    /**
     * Determine if there is a network connection
     *
     * @return
     */
    public static boolean isNetworkConnected() {

        ConnectivityManager mConnectivityManager = (ConnectivityManager) BaseApplication.appContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mNetworkInfo = mConnectivityManager
                .getActiveNetworkInfo();
        if (mNetworkInfo != null) {
            return mNetworkInfo.isAvailable();
        }

        return false;
    }

    /**
     * Determine if the WIFI network is available
     *
     * @param context
     * @return
     */
    public static boolean isWifiConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) BaseApplication.appContext
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mWiFiNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (mWiFiNetworkInfo != null) {
                return mWiFiNetworkInfo.isAvailable();
            }
        }
        return false;
    }


    public static boolean isWiFiActive() {
        ConnectivityManager connectivity = (ConnectivityManager) BaseApplication.appContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getTypeName().equals("WIFI") && info[i].isConnected()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Get the type information of the current network connection
     *
     * @return
     */
    public static int getConnectedType() {
        if (BaseApplication.appContext != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) BaseApplication.appContext
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null && mNetworkInfo.isAvailable()) {
                return mNetworkInfo.getType();
            }
        }
        return -1;
    }
}
