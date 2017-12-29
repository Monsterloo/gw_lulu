package com.junlon.common.base.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: LuJunLang
 * @Description: 通知状态枚举类
 * @Date: 2017/12/27
 */

public enum NotifyStatusEnum {

    CREATED("通知记录已创建", 100),
    FAILED("通知失败", 101),
    SUCCESS("通知成功", 102);

    //描述
    private String desc;

    //枚举值
    private int value;

    //构造函数
    private NotifyStatusEnum(String desc,int value) {
        this.desc = desc;
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static List toList(){
        NotifyStatusEnum[] ary = NotifyStatusEnum.values();
        List list = new ArrayList();
        for(int i=0;i<ary.length;i++){
            Map<String,String> map = new HashMap<String,String>();
            map.put("value",String.valueOf(ary[i].getValue()));
            map.put("desc", ary[i].getDesc());
            list.add(map);
        }
        return list;
    }
}
