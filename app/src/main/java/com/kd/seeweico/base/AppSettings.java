package com.kd.seeweico.base;

import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.preference.Preference;
import android.preference.PreferenceManager;

import com.kd.seeweico.R;
import com.kd.seeweico.common.context.GlobalApplication;
import com.kd.seeweico.common.utils.ActivityHelper;
import com.kd.seeweico.common.utils.SystemUtils;

/**
 * Created by KD on 2016/6/15.
 */
public class AppSettings {
    public static final int[] countArr = {20, 50, 100};
    public static final int REQUEST_DATA_DELAY = 500;
    public static int getPublishDelay() {
        return 5 * 1000;
    }

    //网络请求延时
    public static boolean isNetworkDelay() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return sp.getBoolean("pNetWorkDelay", false);
    }

    //通知设置
    public static boolean isNotifyEnable() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return sp.getBoolean("com.kd.seeweico.NOTIFICATION", true);
    }

    //提及评论提醒
    public static boolean isNotifyCommentMention() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return sp.getBoolean("pCommentMention", true);
    }

    //提及微博提醒
    public static boolean isNotifyStatusMention() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return sp.getBoolean("pStatusMention", true);
    }

    //粉丝提醒
    public static boolean isNotifyFollower() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return sp.getBoolean("pFollower", true);
    }

    //评论提醒
    public static boolean isNotifyComment() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return sp.getBoolean("pComment", true);
    }

    //私信提醒
    public static boolean isNotifyDm() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return sp.getBoolean("pDm", true);
    }

    //声音提醒
    public static boolean isNotifySound() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return sp.getBoolean("pNotifySound", true);
    }

    //振动提醒
    public static boolean isNotifyVibrate() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return sp.getBoolean("pNotifyVibrate", true);
    }

    //LED灯提醒
    public static boolean isNotifyLed() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return sp.getBoolean("pNotifyLed", true);
    }

    //夜间免打扰
    public static boolean isNotifyNightClose() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return sp.getBoolean("pNightClose", true);
    }

    //发送成功震动反馈
    public static boolean isSendVibrate() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return sp.getBoolean("pSendVibrate", true);
    }

    //未读小时间隔时间
    public static int getUnreadinterval() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        int value = Integer.parseInt(sp.getString("pInterval", "0"));
        String[] Arr = GlobalApplication.getInstance().getResources().getStringArray(R.array.prefValues);
        int interval = 60;
        switch (Integer.parseInt(Arr[value])) {
            case 0:
                interval = 60;
                break;
            case 1:
                interval = 50 * 5;
                break;
            case 2:
                interval = 60 * 15;
                break;
            case 3:
                interval = 60 * 60;
                break;
        }
        return interval;
    }

    //上传图片质量设置
    public static boolean getUploadImageSetting() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return sp.getBoolean("pAppResident", true);
    }

    //应用常驻内存
    public static boolean isAppResident() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return sp.getBoolean("pAppResident", true);
    }

    //微博加载数量
    public static int getTimelineCount() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        int index = Integer.parseInt(sp.getString("pTimelineCount", "0"));

        int count = countArr[0];
        if (index == 3) {
            if (SystemUtils.getNetworkType() == SystemUtils.NetworkType.wifi) {
                count = 100;
            }
        } else {
            count = countArr[index];
        }
        return count;
    }

    //评论加载数量
    public static int getCommnetCount() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        int index = Integer.parseInt(sp.getString("pCommentCoutn", "0"));
        int count = 50;
        if (index == 3) {
            if (SystemUtils.getNetworkType() == SystemUtils.NetworkType.wifi) {
                count = 100;
            } else {
                count = countArr[index];
            }
        }
        return count;
    }

    //图片加载模式
    public static int getPictureLoadMode() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return Integer.parseInt(sp.getString("pPicMode", "2"));
    }

    //默认加载原图
    public static boolean isLoadOrignPic() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return sp.getBoolean("pLoadOrignPic", false);
    }

    //是否使用默认浏览器
    public static boolean isInnerBrower() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return sp.getBoolean("pInnerBrower", true);
    }

    //正文字体大小
    private static int[] txtSizeArr = new int[] {R.dimen.sp_12, R.dimen.sp_13, R.dimen.sp_14, R.dimen.sp_15,
        R.dimen.sp_16, R.dimen.sp_17, R.dimen.sp_18, R.dimen.sp_19, R.dimen.sp_20};
    public static int getTextSize() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        int value = Integer.parseInt(sp.getString("pTextSize", "4"));
        return GlobalApplication.getInstance().getResources().getDimensionPixelSize(txtSizeArr[value]);
    }

    //无图模式
    private static boolean isPicNone() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return sp.getBoolean("pNonePic", false);
    }

    //是否显示备注
    public static boolean isShowRemark() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return sp.getBoolean("pShowRemark", true);
    }

    //显示高清图像
    public static boolean isHDProfile() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return sp.getBoolean("pHDProfile", true);
    }

    //如果是获取历史数据，则历史数据的时间大于这个时间，将缓存刷新
    public static int getRefreshInterval() {
        if (isDebug())
            return 30 * 1000;

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        int value = Integer.parseInt(prefs.getString("pCacheValidity", "1"));

        switch (value) {
            case 0:
                return 30 * 1000;
            case 1:
                return 20 * 60 * 1000;
            case 2:
                return 12 * 60 * 60 * 1000;
            case 3:
                return 24 * 60 * 60 * 1000;
            case 4:
                return Integer.MAX_VALUE;
            default:
                return 1 * 60 * 60 * 1000;
        }
    }

    //开发者测试模式
    public static boolean isDebug() {
        //自动刷新时间为30s
        //屏幕旋转,打开音效
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return sp.getBoolean("pDebug", false);
    }

    //关闭缓存
    public static boolean isDisableCache() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return sp.getBoolean("pDisableCache", false);
    }

    //撤销发布
    public static boolean isSendDelay() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return sp.getBoolean("pSendDelay", false);
    }

    //分享照片时旋转90度
    public static boolean isRotatePic() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return sp.getBoolean("pRotatePic", false);
    }

    public static String getImageSavePath() {
        return ActivityHelper.getShareData("com.kd.seeweico.images", "Images");
    }

    public static void setImageSavePath(String path) {
        ActivityHelper.putShareData("com.kd.seeweico.images", path);
    }

    //手势返回对象设置
    public static int getSwipebackEdgeMode() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return Integer.parseInt(sp.getString("pSwipebackEdgeMode", "0"));
    }

    //首页fab按钮功能
    public static int getFabButtonType() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return Integer.parseInt(sp.getString("pFabPosition", "1"));
    }

    public static int getThemeColor() {
        return ActivityHelper.getIntShareData("Theme_index", -1);
    }

    public static void setThemeColor(int theme) {
        ActivityHelper.putIntShareData("Theme_index", theme);
    }

    //开启高清图已下载提示
    public static boolean isDownloadHDpic() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return sp.getBoolean("pDownloadHPpic", true);
    }

    //离线微博大小
    public static int getOfflineStatusSize() {
        int[] values = new int[] {50, 100, 200};
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        int index = Integer.parseInt(sp.getString("pOfflineStatusSize", "0"));
        return values[index];
    }

    //同时离线中图
    public static boolean isLoadOfflineMidPic() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return sp.getBoolean("pLoadMidPicture", true);
    }

    //同时离线图片线程大小
    public static int offlinePicTaskSize() {
        int[] value = new int[] {10, 20, 30, 50};
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        int index = Integer.parseInt(sp.getString("pOfflinePicTaskCount", "2"));
        return  value[index];
    }

    //屏幕旋转
    public static boolean isScreenRotate() {
        if (isDebug()) {
            return  true;
        }
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(GlobalApplication.getInstance());
        return sp.getBoolean("pScreenRotate", false);
    }

    //测试用，验证通知模块时，不自动清除数据
    public static boolean ignoreUnread() {
        return false;
    }
}
