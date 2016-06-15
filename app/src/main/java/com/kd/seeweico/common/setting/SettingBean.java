package com.kd.seeweico.common.setting;

import java.io.Serializable;

/**
 * Created by KD on 2016/6/15.
 */
public class SettingBean implements Serializable {
    private static final long serialVersionUID = 7483184197629466333L;
    private String description;
    private String type;
    private String value;

    SettingBean() {
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
