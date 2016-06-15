package com.kd.seeweico.common.context;

import android.app.Application;
import android.os.Environment;
import android.os.Handler;

import com.kd.seeweico.common.setting.SettingUtility;
import com.kd.seeweico.common.utils.ActivityHelper;
import com.kd.seeweico.common.utils.SDcardUtils;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by KD on 2016/6/15.
 */
public class GlobalApplication extends Application {
    private static GlobalApplication mGlobalApplication;
    public static final int CONN_TIMEOUT = 30000;
    public static final int READ_TIMEOUT = 30000;
    private OkHttpClient mOkHttpClient;
    Handler mHandler = new Handler() {};
    public GlobalApplication() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mGlobalApplication = this;
        this.mOkHttpClient = new OkHttpClient();
        this.setOkhttpClient(CONN_TIMEOUT, READ_TIMEOUT);
        ActivityHelper.config(this);
        SettingUtility.setSettingUtility();
    }

    public static GlobalApplication getInstance() {
        return mGlobalApplication;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public String getAppPath() {
        if ("android".equals(SettingUtility.getStringSetting("root_path"))) {
            File file = getInstance().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            return file != null ? file.getAbsolutePath() + File.separator : this.getCacheDir().getAbsolutePath() + File.separator;
        } else {
            return SDcardUtils.getSDcardPath();
        }
    }

    public void setOkhttpClient(int connTimeOut, int socketTimeout) {
        if (this.mOkHttpClient != null) {
            this.mOkHttpClient.setConnectTimeout((long)connTimeOut, TimeUnit.MILLISECONDS);
            this.mOkHttpClient.setReadTimeout((long)socketTimeout, TimeUnit.MILLISECONDS);
        }
    }

}
