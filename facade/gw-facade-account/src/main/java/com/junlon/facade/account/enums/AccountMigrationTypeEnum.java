package com.junlon.facade.account.enums;

/**
 * 
 * @描述: 账户迁移类型
 * @author: chenyf on 2018-01-02
 */
public enum AccountMigrationTypeEnum {

	/**
	 * 主账户明细
	 */
	MAIN_ACCOUNT_DETAIL("主账户明细", 1),

	/**
	 * 垫资账户明细
	 */
	ADVANCE_ACCOUNT_DETAIL("垫资账户明细", 2);

	/** 枚举值 */
	private int value;

	/** 描述 */
	private String desc;

	private AccountMigrationTypeEnum(String desc, int value) {
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

	public static AccountMigrationTypeEnum getEnum(int value) {
		AccountMigrationTypeEnum resultEnum = null;
		AccountMigrationTypeEnum[] enumAry = AccountMigrationTypeEnum.values();
		for (int i = 0; i < enumAry.length; i++) {
			if (enumAry[i].getValue() == value) {
				resultEnum = enumAry[i];
				break;
			}
		}
		return resultEnum;
	}
}
