package com.junlon.facade.account.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 变动类型枚举类
 * 
 * Created by jo on 2017/9/5.
 */
public enum AccountAlterTypeEnum {
    /**
     * 交易入账
     */
    CREDIT("交易入账", 1),

    /**
     * 出款冻结
     */
    DEBIT_FROZEN("出款冻结", 2),

    /**
     * 出款扣款
     */
    DEBIT_OUT("出款扣款", 3),

    /**
     * 出款退回
     */
    DEBIT_RETURN("出款退回", 4),
    
    /**
     * 待清算入账
     */
    BOOKED_WAIT_TO_CLEAR("待清算入账", 5),
    
    /**
     * 可结算入账
     */
    BOOKED_ALLOW_SETTLE("可结算入账", 6);

    /** 枚举值 */
    private int value;

    /** 描述 */
    private String desc;

    private AccountAlterTypeEnum(String desc, int value) {
        this.value = value;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    /**
     * 根据枚举值获取枚举属性.
     *
     * @param value
     *            枚举值.
     * @return enum 枚举属性.
     */
    public static AccountAlterTypeEnum getEnum(int value) {
        AccountAlterTypeEnum resultEnum = null;
        AccountAlterTypeEnum[] enumAry = AccountAlterTypeEnum.values();
        for (int num = 0; num < enumAry.length; num++) {
            if (enumAry[num].getValue() == value) {
                resultEnum = enumAry[num];
                break;
            }
        }
        return resultEnum;
    }

    /**
     * 将枚举类转换为map.
     *
     * @return Map<key, Map<attr, value>>
     */
    public static Map<String, Map<String, Object>> toMap() {
        AccountAlterTypeEnum[] ary = AccountAlterTypeEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
        for (int num = 0; num < ary.length; num++) {
            Map<String, Object> map = new HashMap<String, Object>();
            String key = String.valueOf(getEnum(ary[num].getValue()));
            map.put("value", ary[num].getValue());
            map.put("desc", ary[num].getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    /**
     * 将枚举类转换为list.
     *
     * @return List<Map<String, Object>> list.
     */
    public static List<Map<String, Object>> toList() {
        AccountAlterTypeEnum[] ary = AccountAlterTypeEnum.values();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < ary.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("value", ary[i].getValue());
            map.put("desc", ary[i].getDesc());
            list.add(map);
        }
        return list;
    }
}
