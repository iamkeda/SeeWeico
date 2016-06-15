package com.kd.seeweico.common.setting;

import com.kd.seeweico.common.context.GlobalApplication;

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

}
