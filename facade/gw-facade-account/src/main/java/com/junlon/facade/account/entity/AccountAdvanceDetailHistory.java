/*
 * Powered By [joinPay.com]
 */

package com.junlon.facade.account.entity;


import com.junlon.common.base.entity.BaseEntity;

/**
 * 垫资账户明细的历史记录表
 */
public class AccountAdvanceDetailHistory extends BaseEntity {

	private static final long serialVersionUID = 1L;

	//columns START
	/**
	 * 迁移时间(即本条记录的创建时间)
	 */
	private java.util.Date migrationTime;

	/**
	 * 交易时间
	 */
	private java.util.Date trxTime;

	/**
	 * 交易日期
	 */
	private java.util.Date trxDate;

	/**
	 * 账户交易类型(AccountTradeTypeEnum)
	 */
	private Integer accountTrxType;

	/**
	 * 交易流水号
	 */
	private String requestNo;

	/**
	 * 账户号
	 */
	private String accountNo;

	/**
	 * 用户号
	 */
	private String userNo;

	/**
	 * 账户类型(AccountTypeEnum)
	 */
	private Integer accountType;

	/**
	 * 最大垫资额度
	 */
	private java.math.BigDecimal maxAdvanceAmount;

	/**
	 * 当前垫资额度
	 */
	private java.math.BigDecimal currentAdvanceAmount;

	/**
	 * 已用垫资额度
	 */
	private java.math.BigDecimal availableAdvanceAmount;

	/**
	 * 已用垫资额度
	 */
	private java.math.BigDecimal usedAdvanceAmount;

	/**
	 * 垫资冻结额度
	 */
	private java.math.BigDecimal advanceFrozenAmount;

	/**
	 * 垫资比例
	 */
	private java.math.BigDecimal advanceScale;

	/**
	 * 手续费
	 */
	private java.math.BigDecimal fee;

	/**
	 * 123:增加 321:减少
	 */
	private Integer fundDirection;

	/**
	 * 变动类型(AccountAlterTypeEnum)
	 */
	private Integer alterType;

	/**
	 * 交易金额
	 */
	private java.math.BigDecimal alterAmount;

	/**
	 * 最大垫资额度变动金额
	 */
	private java.math.BigDecimal alterMaxAdvanceAmount;

	/**
	 * 当前垫资额度变动金额
	 */
	private java.math.BigDecimal alterCurrentAdvanceAmount;

	/**
	 * 已用垫资额度变动金额
	 */
	private java.math.BigDecimal alterUsedAdvanceAmount;

	/**
	 * 垫资冻结额度变动金额
	 */
	private java.math.BigDecimal alterAdvanceFrozenAmount;

	/**
	 * 各当日累计金额字段的变动金额(收单/冻结/退回)
	 */
	private java.math.BigDecimal alterAmountForGrandTotal;

	/**
	 * 当日累计收单金额
	 */
	private java.math.BigDecimal grandTotalReceiveAmount;

	/**
	 * 当日累计冻结金额
	 */
	private java.math.BigDecimal grandTotalFrozenAmount;

	/**
	 * 当日累计退回金额
	 */
	private java.math.BigDecimal grandTotalReturnAmount;

	/**
	 * 可垫资当日累计的变动金额(可垫冻结/可垫退回)
	 */
	private java.math.BigDecimal alterAmountForAvailableGrandTotal;

	/**
	 * 当日累计可垫资冻结金额
	 */
	private java.math.BigDecimal grandTotalAvailableFrozenAmount;

	/**
	 * 当日累计可垫资退回金额
	 */
	private java.math.BigDecimal grandTotalAvailableReturnAmount;

	/**
	 * 清算阶段(1=不可清算 2=未清算 3=已清算)
	 */
	private Integer clearStage;

	/**
	 * 清算编号
	 */
	private String clearNo;

	/**
	 * 备注
	 */
	private String remark;

	//columns END

	/**
	 * 迁移时间(即本条记录的创建时间)
	 */
	public void setMigrationTime(java.util.Date migrationTime) {
		this.migrationTime = migrationTime;
	}
	/**
	 * 迁移时间(即本条记录的创建时间)
	 */
	public java.util.Date getMigrationTime() {
		return this.migrationTime;
	}

	/**
	 * 交易时间
	 */
	public void setTrxTime(java.util.Date trxTime) {
		this.trxTime = trxTime;
	}
	/**
	 * 交易时间
	 */
	public java.util.Date getTrxTime() {
		return this.trxTime;
	}

	/**
	 * 交易日期
	 */
	public void setTrxDate(java.util.Date trxDate) {
		this.trxDate = trxDate;
	}
	/**
	 * 交易日期
	 */
	public java.util.Date getTrxDate() {
		return this.trxDate;
	}

	/**
	 * 账户交易类型(AccountTradeTypeEnum)
	 */
	public void setAccountTrxType(Integer accountTrxType) {
		this.accountTrxType = accountTrxType;
	}
	/**
	 * 账户交易类型(AccountTradeTypeEnum)
	 */
	public Integer getAccountTrxType() {
		return this.accountTrxType;
	}

	/**
	 * 交易流水号
	 */
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}
	/**
	 * 交易流水号
	 */
	public String getRequestNo() {
		return this.requestNo;
	}

	/**
	 * 账户号
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	/**
	 * 账户号
	 */
	public String getAccountNo() {
		return this.accountNo;
	}

	/**
	 * 用户号
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	/**
	 * 用户号
	 */
	public String getUserNo() {
		return this.userNo;
	}

	/**
	 * 账户类型(AccountTypeEnum)
	 */
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
	/**
	 * 账户类型(AccountTypeEnum)
	 */
	public Integer getAccountType() {
		return this.accountType;
	}

	/**
	 * 最大垫资额度
	 */
	public void setMaxAdvanceAmount(java.math.BigDecimal maxAdvanceAmount) {
		this.maxAdvanceAmount = maxAdvanceAmount;
	}
	/**
	 * 最大垫资额度
	 */
	public java.math.BigDecimal getMaxAdvanceAmount() {
		return this.maxAdvanceAmount;
	}

	/**
	 * 当前垫资额度
	 */
	public void setCurrentAdvanceAmount(java.math.BigDecimal currentAdvanceAmount) {
		this.currentAdvanceAmount = currentAdvanceAmount;
	}
	/**
	 * 当前垫资额度
	 */
	public java.math.BigDecimal getCurrentAdvanceAmount() {
		return this.currentAdvanceAmount;
	}

	/**
	 * 已用垫资额度
	 */
	public void setAvailableAdvanceAmount(java.math.BigDecimal availableAdvanceAmount) {
		this.availableAdvanceAmount = availableAdvanceAmount;
	}
	/**
	 * 已用垫资额度
	 */
	public java.math.BigDecimal getAvailableAdvanceAmount() {
		return this.availableAdvanceAmount;
	}

	/**
	 * 已用垫资额度
	 */
	public void setUsedAdvanceAmount(java.math.BigDecimal usedAdvanceAmount) {
		this.usedAdvanceAmount = usedAdvanceAmount;
	}
	/**
	 * 已用垫资额度
	 */
	public java.math.BigDecimal getUsedAdvanceAmount() {
		return this.usedAdvanceAmount;
	}

	/**
	 * 垫资冻结额度
	 */
	public void setAdvanceFrozenAmount(java.math.BigDecimal advanceFrozenAmount) {
		this.advanceFrozenAmount = advanceFrozenAmount;
	}
	/**
	 * 垫资冻结额度
	 */
	public java.math.BigDecimal getAdvanceFrozenAmount() {
		return this.advanceFrozenAmount;
	}

	/**
	 * 垫资比例
	 */
	public void setAdvanceScale(java.math.BigDecimal advanceScale) {
		this.advanceScale = advanceScale;
	}
	/**
	 * 垫资比例
	 */
	public java.math.BigDecimal getAdvanceScale() {
		return this.advanceScale;
	}

	/**
	 * 手续费
	 */
	public void setFee(java.math.BigDecimal fee) {
		this.fee = fee;
	}
	/**
	 * 手续费
	 */
	public java.math.BigDecimal getFee() {
		return this.fee;
	}

	/**
	 * 123:增加 321:减少
	 */
	public void setFundDirection(Integer fundDirection) {
		this.fundDirection = fundDirection;
	}
	/**
	 * 123:增加 321:减少
	 */
	public Integer getFundDirection() {
		return this.fundDirection;
	}

	/**
	 * 变动类型(AccountAlterTypeEnum)
	 */
	public void setAlterType(Integer alterType) {
		this.alterType = alterType;
	}
	/**
	 * 变动类型(AccountAlterTypeEnum)
	 */
	public Integer getAlterType() {
		return this.alterType;
	}

	/**
	 * 交易金额
	 */
	public void setAlterAmount(java.math.BigDecimal alterAmount) {
		this.alterAmount = alterAmount;
	}
	/**
	 * 交易金额
	 */
	public java.math.BigDecimal getAlterAmount() {
		return this.alterAmount;
	}

	/**
	 * 最大垫资额度变动金额
	 */
	public void setAlterMaxAdvanceAmount(java.math.BigDecimal alterMaxAdvanceAmount) {
		this.alterMaxAdvanceAmount = alterMaxAdvanceAmount;
	}
	/**
	 * 最大垫资额度变动金额
	 */
	public java.math.BigDecimal getAlterMaxAdvanceAmount() {
		return this.alterMaxAdvanceAmount;
	}

	/**
	 * 当前垫资额度变动金额
	 */
	public void setAlterCurrentAdvanceAmount(java.math.BigDecimal alterCurrentAdvanceAmount) {
		this.alterCurrentAdvanceAmount = alterCurrentAdvanceAmount;
	}
	/**
	 * 当前垫资额度变动金额
	 */
	public java.math.BigDecimal getAlterCurrentAdvanceAmount() {
		return this.alterCurrentAdvanceAmount;
	}

	/**
	 * 已用垫资额度变动金额
	 */
	public void setAlterUsedAdvanceAmount(java.math.BigDecimal alterUsedAdvanceAmount) {
		this.alterUsedAdvanceAmount = alterUsedAdvanceAmount;
	}
	/**
	 * 已用垫资额度变动金额
	 */
	public java.math.BigDecimal getAlterUsedAdvanceAmount() {
		return this.alterUsedAdvanceAmount;
	}

	/**
	 * 垫资冻结额度变动金额
	 */
	public void setAlterAdvanceFrozenAmount(java.math.BigDecimal alterAdvanceFrozenAmount) {
		this.alterAdvanceFrozenAmount = alterAdvanceFrozenAmount;
	}
	/**
	 * 垫资冻结额度变动金额
	 */
	public java.math.BigDecimal getAlterAdvanceFrozenAmount() {
		return this.alterAdvanceFrozenAmount;
	}

	/**
	 * 各当日累计金额字段的变动金额(收单/冻结/退回)
	 */
	public void setAlterAmountForGrandTotal(java.math.BigDecimal alterAmountForGrandTotal) {
		this.alterAmountForGrandTotal = alterAmountForGrandTotal;
	}
	/**
	 * 各当日累计金额字段的变动金额(收单/冻结/退回)
	 */
	public java.math.BigDecimal getAlterAmountForGrandTotal() {
		return this.alterAmountForGrandTotal;
	}

	/**
	 * 当日累计收单金额
	 */
	public void setGrandTotalReceiveAmount(java.math.BigDecimal grandTotalReceiveAmount) {
		this.grandTotalReceiveAmount = grandTotalReceiveAmount;
	}
	/**
	 * 当日累计收单金额
	 */
	public java.math.BigDecimal getGrandTotalReceiveAmount() {
		return this.grandTotalReceiveAmount;
	}

	/**
	 * 当日累计冻结金额
	 */
	public void setGrandTotalFrozenAmount(java.math.BigDecimal grandTotalFrozenAmount) {
		this.grandTotalFrozenAmount = grandTotalFrozenAmount;
	}
	/**
	 * 当日累计冻结金额
	 */
	public java.math.BigDecimal getGrandTotalFrozenAmount() {
		return this.grandTotalFrozenAmount;
	}

	/**
	 * 当日累计退回金额
	 */
	public void setGrandTotalReturnAmount(java.math.BigDecimal grandTotalReturnAmount) {
		this.grandTotalReturnAmount = grandTotalReturnAmount;
	}
	/**
	 * 当日累计退回金额
	 */
	public java.math.BigDecimal getGrandTotalReturnAmount() {
		return this.grandTotalReturnAmount;
	}

	/**
	 * 可垫资当日累计的变动金额(可垫冻结/可垫退回)
	 */
	public void setAlterAmountForAvailableGrandTotal(java.math.BigDecimal alterAmountForAvailableGrandTotal) {
		this.alterAmountForAvailableGrandTotal = alterAmountForAvailableGrandTotal;
	}
	/**
	 * 可垫资当日累计的变动金额(可垫冻结/可垫退回)
	 */
	public java.math.BigDecimal getAlterAmountForAvailableGrandTotal() {
		return this.alterAmountForAvailableGrandTotal;
	}

	/**
	 * 当日累计可垫资冻结金额
	 */
	public void setGrandTotalAvailableFrozenAmount(java.math.BigDecimal grandTotalAvailableFrozenAmount) {
		this.grandTotalAvailableFrozenAmount = grandTotalAvailableFrozenAmount;
	}
	/**
	 * 当日累计可垫资冻结金额
	 */
	public java.math.BigDecimal getGrandTotalAvailableFrozenAmount() {
		return this.grandTotalAvailableFrozenAmount;
	}

	/**
	 * 当日累计可垫资退回金额
	 */
	public void setGrandTotalAvailableReturnAmount(java.math.BigDecimal grandTotalAvailableReturnAmount) {
		this.grandTotalAvailableReturnAmount = grandTotalAvailableReturnAmount;
	}
	/**
	 * 当日累计可垫资退回金额
	 */
	public java.math.BigDecimal getGrandTotalAvailableReturnAmount() {
		return this.grandTotalAvailableReturnAmount;
	}

	/**
	 * 清算阶段(1=不可清算 2=未清算 3=已清算)
	 */
	public void setClearStage(Integer clearStage) {
		this.clearStage = clearStage;
	}
	/**
	 * 清算阶段(1=不可清算 2=未清算 3=已清算)
	 */
	public Integer getClearStage() {
		return this.clearStage;
	}

	/**
	 * 清算编号
	 */
	public void setClearNo(String clearNo) {
		this.clearNo = clearNo;
	}
	/**
	 * 清算编号
	 */
	public String getClearNo() {
		return this.clearNo;
	}

	/**
	 * 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 备注
	 */
	public String getRemark() {
		return this.remark;
	}




}
