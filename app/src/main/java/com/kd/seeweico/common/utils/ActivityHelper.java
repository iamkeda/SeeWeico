package com.kd.seeweico.common.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by KD on 2016/6/15.
 */
public class ActivityHelper {
    public static final String KEY = "com.kd.seeweico.activity_key";
    private static Context mContext;
    private ActivityHelper() {
    }

    public static void config(Context context) {
        mContext = context;
    }

    public static String getShareData(String key) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, 0);
        return sp.getString(key, "");
    }

    public static String getShareData(String key, String defValue) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, 0);
        return sp.getString(key, defValue);
    }

    public static int getIntShareData(String key) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, 0);
        return sp.getInt(key, 0);
    }

    public static int getIntShareData(String key, int defVALUE) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, 0);
        return sp.getInt(key, defVALUE);
    }

    public static boolean getBooleanShareData(String key) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, 0);
        return sp.getBoolean(key, false);
    }

    public static boolean getBooleanShareData(String key, boolean defValue) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, 0);
        return sp.getBoolean(key, defValue);
    }

    public static void putShareData(String key, String value) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void putIntShareData(String key, int value) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static void putBooleanShareData(String key, boolean value) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static void putSetShareData(String key, Set<String> value) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putStringSet(key, value);
        editor.commit();
    }

    public static Set<String> getSetShareData(String key) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, 0);
        return sp.getStringSet(key, new HashSet<String>());
    }
}
