package com.junlon.facade.account.enums;

/**
 * Created by chenyf on 2017/8/1.
 */
public enum AmountTypeEnum {
    /**
     * 只使用可结算金额
     */
    SETTLE_AMOUNT("可结算金额", 1),

    /**
     * 只使用可垫资金额
     */
    ADVANCE_AMOUNT("可垫资金额", 2),

    /**
     * 使用可结算金额+可垫资金额
     */
    SETTLE_AND_ADVANCE_AMOUNT("可结算加可垫金额", 3),

    /**
     * 使用可用余额，即：可结+可垫+不可垫
     */
    AVAILABLE_AMOUNT("可用余额", 4);

    /** 枚举值 */
    private int value;

    /** 描述 */
    private String desc;

    private AmountTypeEnum(String desc, int value) {
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
}
