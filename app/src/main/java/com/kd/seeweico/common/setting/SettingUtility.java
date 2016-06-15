package com.kd.seeweico.common.setting;

import com.kd.seeweico.common.context.GlobalApplication;
import com.kd.seeweico.common.utils.ActivityHelper;
import com.kd.seeweico.common.utils.SDcardUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by KD on 2016/6/15.
 */
public class SettingUtility {
    private static Map<String, Setting> settingMap = new HashMap<>();

    private SettingUtility() {}

    public static void setSettingUtility() {
        addSettings("actions");
        addSettings("settings");
        if (SDcardUtils.hasSdcardAndCanWrite()) {
            File rootFile = new File(GlobalApplication.getInstance().getAppPath());
            if (!rootFile.exists()) {
                rootFile.mkdirs();
            }
            File jsonFIle = new File(rootFile.getAbsolutePath() + File.separator + getPermanentSettingAsStr("com_m_common_json", "files"));
            if (!jsonFIle.exists()) {
                jsonFIle.mkdirs();
            }
            File imageFile = new File(rootFile.getAbsolutePath() + File.separator + getPermanentSettingAsStr("com_m_common_images", "images"));
            if (!imageFile.exists()) {
                imageFile.mkdirs();
            }
        }
    }

    public static void addSettings(String xmlName) {
        Map newSettingMap = SettingXmlParser.parseSettings(GlobalApplication.getInstance(), xmlName);
        Set ketSet = newSettingMap.keySet();
        Iterator iterator = ketSet.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            Setting setting = (Setting) newSettingMap.get(key);
            settingMap.put(key, setting);
        }
    }

    public static boolean getBooleanSetting(String key) {
        return settingMap.containsKey(key) ? Boolean.parseBoolean((settingMap.get(key)).getValue()) : false;
    }

    public static int getIntSetting(String key) {
        return settingMap.containsKey(key) ? Integer.parseInt((settingMap.get(key)).getValue()) : -1;
    }

    public static String getStringSetting(String key) {
        return settingMap.containsKey(key) ? settingMap.get(key).getValue() : null;
    }

    public static Setting getSetting(String key) {
        return settingMap.containsKey(key) ? settingMap.get(key) :null;
    }

    public static void setPermanentSetting(String key, boolean value) {
        ActivityHelper.putBooleanShareData(key, value);
    }

    public static boolean getPermanentSettingAsBool(String key, boolean def) {
        return ActivityHelper.getBooleanShareData(key, def);
    }

    public static void setPermanentSetting(String key, int value) {
        ActivityHelper.putIntShareData(key, value);
    }

    public static int getPermanentSettingAsInt(String key, int def) {
        return ActivityHelper.getIntShareData(key, def);
    }

    public static void setPermanentSetting(String key, String value) {
        ActivityHelper.putShareData(key, value);
    }

    public static String getPermanentSettingAsStr(String key, String def) {
        return ActivityHelper.getShareData(key, def);
    }
}
