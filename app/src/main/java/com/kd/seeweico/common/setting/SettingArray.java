package com.kd.seeweico.common.setting;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KD on 2016/6/15.
 */
public class SettingArray extends SettingBean implements Serializable {
    private static final long serialVersionUID = -6146779641644156283L;
    private List<Setting> settingArray = new ArrayList<>();
    private int index;

    public SettingArray() {}

    public List<Setting> getSettingArray() {
        return this.settingArray;
    }

    public void setSettingArray(List<Setting> settingArray) {
        this.settingArray = settingArray;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
