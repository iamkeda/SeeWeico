package com.kd.seeweico.common.setting;

import android.content.Context;
import android.content.res.Resources;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Exchanger;

/**
 * Created by KD on 2016/6/15.
 */
public class SettingXmlParser {
    private static final String TAG = SettingXmlParser.class.getSimpleName();

    private SettingXmlParser() {}

    public static Map<String, Setting> parseSettings(Context context, String fileName) {
        HashMap settingMap = new HashMap();
        ArrayList settingArray = new ArrayList();
        ArrayList settingExtras = null;
        Setting readSetting = null;
        SettingArray readSettingArray = null;
        SettingExtra readSettingExtra = null;
        XmlPullParser xmlResParser = null;

        try {
            String packageName = context.getPackageName();
            Resources resources  = context.getPackageManager().getResourcesForApplication(packageName);
            int setting = resources.getIdentifier(fileName, "raw", packageName);
            xmlResParser = Xml.newPullParser();
            xmlResParser.setInput(resources.openRawResource(setting), "utf-8");

            for (int type = xmlResParser.getEventType(); type != 1; type = xmlResParser.next()) {
                switch (type) {
                    case 2:
                        if ("setting-array".equals(xmlResParser.getName())) {
                            readSettingArray = new SettingArray();
                            readSettingArray.setType(xmlResParser.getAttributeValue((String)null, "type"));
                            readSettingArray.setIndex(Integer.parseInt(xmlResParser.getAttributeValue((String)null, "index")));
                        }

                        if ("setting".equals(xmlResParser.getName())) {
                            readSetting = new Setting();
                            readSetting.setType(xmlResParser.getAttributeValue((String)null, "type"));
                        }

                        if ("extras".equals(xmlResParser.getName())) {
                            settingExtras = new ArrayList();
                        }

                        if ("extra".equals(xmlResParser.getName())) {
                            readSettingExtra = new SettingExtra();
                            readSettingExtra.setType(xmlResParser.getAttributeValue((String)null, "type"));
                        }

                        if ("des".equals(xmlResParser.getName())) {
                            if (readSettingExtra != null) {
                                readSettingExtra.setDescription(xmlResParser.nextText());
                            } else if (readSetting != null) {
                                readSetting.setDescription(xmlResParser.nextText());
                            } else if (readSettingArray != null) {
                                readSettingArray.setDescription(xmlResParser.nextText());
                            }
                        }

                        if("values".equals(xmlResParser.getName())) {
                            if (readSettingExtra != null) {
                                readSettingExtra.setValue(xmlResParser.nextText());
                            } else if (readSetting != null) {
                                readSetting.setValue(xmlResParser.nextText());
                            }
                        }
                        break;
                    case 3:
                        if ("setting".equals(xmlResParser.getName())) {
                            if (readSetting != null) {
                                if (readSettingArray != null) {
                                    readSettingArray.getSettingArray().add(readSetting);
                                } else {
                                    settingMap.put(readSetting.getType(), readSetting);
                                }
                            }
                            readSetting = null;
                        }

                        if ("setting-array".equals(xmlResParser.getName())) {
                            settingArray.add(readSettingArray);
                            readSettingArray = null;

                        }

                        if ("extras".equals(xmlResParser.getName())) {
                            if (readSetting != null) {
                                Iterator iterator = settingExtras.iterator();
                                while (iterator.hasNext()) {
                                    SettingExtra extra = (SettingExtra) iterator.next();
                                    readSetting.getExtras().put(extra.getType(), extra);
                                }
                            }
                            settingExtras = null;
                        }

                        if ("extra".equals(xmlResParser.getName())) {
                            settingExtras.add(readSettingExtra);
                            readSettingExtra = null;
                        }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        Iterator iterator = settingArray.iterator();
        while (iterator.hasNext()) {
            SettingArray array = (SettingArray) iterator.next();
            if (array.getSettingArray().size() > array.getIndex()) {
                Setting setting1 = (Setting) array.getSettingArray().get(array.getIndex());
                setting1.setType(array.getType());
                settingMap.put(setting1.getType(), setting1);
            }
        }
        return settingMap;
    }

}
