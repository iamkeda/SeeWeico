package com.kd.seeweico.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.kd.seeweico.common.context.GlobalApplication;

/**
 * Created by KD on 2016/6/15.
 */
public class SystemUtils {
    private static int screenWidth;
    private static int sreenHeight;
    private static float density;
    private static final String STATUS_BAR_HEIGHT_RES_NAME = "status_bar_height";
    private static final String NAV_BAR_HEIGHT_RES_NAME = "navigation_bar_height";
    private static final String NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME = "navigation_bar_height_landscape";
    private static final String SHOW_NAV_BAR_RES_NAME = "config_show_navigation_bar";
    private static final String NAV_BAR_WIDTH_RES_NAME = "navigation_bar_width";

    public SystemUtils() {}
    public static enum NetworkType {
        none,
        mobile,
        wifi;
        private NetworkType() {

        }
    }

    public static SystemUtils.NetworkType getNetworkType() {
        ConnectivityManager connectivityManager = (ConnectivityManager) GlobalApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null) {
            switch (networkInfo.getType()) {
                case 0:
                    return NetworkType.mobile;
                case 1:
                    return NetworkType.wifi;
            }
        }
        return NetworkType.none;
    }

}
