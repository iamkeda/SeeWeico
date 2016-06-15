package com.kd.seeweico.common.context;

import android.app.Application;
import android.os.Handler;

import com.kd.seeweico.common.utils.ActivityHelper;
import com.squareup.okhttp.OkHttpClient;

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

    }

    public void setOkhttpClient(int connTimeOut, int socketTimeout) {
        if (this.mOkHttpClient != null) {
            this.mOkHttpClient.setConnectTimeout((long)connTimeOut, TimeUnit.MILLISECONDS);
            this.mOkHttpClient.setReadTimeout((long)socketTimeout, TimeUnit.MILLISECONDS);
        }
    }
}
