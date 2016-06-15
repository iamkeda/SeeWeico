package com.kd.seeweico.common.setting;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by KD on 2016/6/15.
 */
public class Setting extends SettingBean implements Serializable {
    private static final long serialVersionUID = 1399762922574268795L;
    private Map<String, SettingExtra> extras = new HashMap<>();

    public Setting() {}

    public Map<String, SettingExtra> getExtras() {
        return this.extras;
    }

    public void setExtras(Map<String, SettingExtra> extras) {
        this.extras = extras;
    }

    public Setting copy() {
        return JSON.parseObject(JSON.toJSONString(this), Setting.class);
    }
}
