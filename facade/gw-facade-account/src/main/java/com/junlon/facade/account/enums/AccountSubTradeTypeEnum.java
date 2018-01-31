package com.junlon.facade.account.enums;

/**
 * Created by jo on 2017/8/23.
 */
public enum AccountSubTradeTypeEnum {

    SETTLE_REMIT("子商户结算打款", 1);



    /** 描述 */
    private String desc;
    /** 枚举值 */
    private int value;

    private AccountSubTradeTypeEnum(String desc, int value) {
        this.desc = desc;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
