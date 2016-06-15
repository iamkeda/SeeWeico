package com.kd.seeweico.common.utils;

import android.os.Environment;
import android.os.StatFs;

/**
 * Created by KD on 2016/6/15.
 */
public class SDcardUtils {
    public SDcardUtils() {}

    public static boolean hasSDcard() {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            return true;
        } else {
            return false;
        }
    }

    public static String getSDcardPath() {
        return hasSDcard() ? Environment.getExternalStorageDirectory().getAbsolutePath() : "/sdcard/";
    }

    private static boolean sdcardCanWrite() {
        return Environment.getExternalStorageDirectory().canWrite();
    }

    public static boolean hasSdcardAndCanWrite() {
        return hasSDcard() && sdcardCanWrite();
    }

    public long getSDcardAvalilableStore() {
        if (hasSdcardAndCanWrite()) {
            String path = getSDcardPath();
            if (path != null) {
                StatFs statFs = new StatFs(path);
                long blocSize = statFs.getBlockSizeLong();
                long availaBlock = statFs.getAvailableBlocksLong();
                return availaBlock * blocSize;
            }
        }
        return 0L;
    }
}
