package com.junlon.facade.account.entity;


import com.junlon.common.base.entity.BaseEntity;
import com.junlon.common.base.utils.number.AmountUtil;

import java.math.BigDecimal;

/**
 *
 * @description: 垫资账户明细实体类
 * @author:      huang.jin
 * @date:        2017年9月18日 下午6:03:52
 * @version:     1.0
 *
 */
public class AccountAdvanceDetail extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	//columns START
	
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
	private java.lang.String requestNo;
	/**
	 * 账户号
	 */
	private java.lang.String accountNo;
	/**
	 * 用户号
	 */
	private java.lang.String userNo;
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
	 * 可垫资额度
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
	 * 各累计金额字段的变动金额(收单/冻结/退回)
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
	private java.lang.String clearNo;
	/**
	 * 备注
	 */
	private java.lang.String remark;
	//columns END

	public AccountAdvanceDetail(){
	}

	/**
	 * 交易时间
	 */
	public void setTrxTime(java.util.Date value) {
		this.trxTime = value;
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
	public void setTrxDate(java.util.Date value) {
		this.trxDate = value;
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
	public void setAccountTrxType(Integer value) {
		this.accountTrxType = value;
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
	public void setRequestNo(java.lang.String value) {
		this.requestNo = value;
	}
	/**
	 * 交易流水号
	 */
	public java.lang.String getRequestNo() {
		return this.requestNo;
	}
	/**
	 * 账户号
	 */
	public void setAccountNo(java.lang.String value) {
		this.accountNo = value;
	}
	/**
	 * 账户号
	 */
	public java.lang.String getAccountNo() {
		return this.accountNo;
	}
	/**
	 * 用户号
	 */
	public void setUserNo(java.lang.String value) {
		this.userNo = value;
	}
	/**
	 * 用户号
	 */
	public java.lang.String getUserNo() {
		return this.userNo;
	}
	/**
	 * 账户类型(AccountTypeEnum)
	 */
	public void setAccountType(Integer value) {
		this.accountType = value;
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
	public void setMaxAdvanceAmount(java.math.BigDecimal value) {
		this.maxAdvanceAmount = value;
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
	public void setCurrentAdvanceAmount(java.math.BigDecimal value) {
		this.currentAdvanceAmount = value;
	}
	/**
	 * 当前垫资额度
	 */
	public java.math.BigDecimal getCurrentAdvanceAmount() {
		return this.currentAdvanceAmount;
	}
	/**
	 * 可垫资额度
	 */
	public void setAvailableAdvanceAmount(java.math.BigDecimal value) {
		this.availableAdvanceAmount = value;
	}
	/**
	 * 可垫资额度
	 */
	public java.math.BigDecimal getAvailableAdvanceAmount() {
		return this.availableAdvanceAmount;
	}
	/**
	 * 已用垫资额度
	 */
	public void setUsedAdvanceAmount(java.math.BigDecimal value) {
		this.usedAdvanceAmount = value;
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
	public void setAdvanceFrozenAmount(java.math.BigDecimal value) {
		this.advanceFrozenAmount = value;
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
	public void setAdvanceScale(java.math.BigDecimal value) {
		this.advanceScale = value;
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
	public void setFee(java.math.BigDecimal value) {
		this.fee = value;
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
	public void setFundDirection(Integer value) {
		this.fundDirection = value;
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
	public void setAlterType(Integer value) {
		this.alterType = value;
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
	public void setAlterAmount(java.math.BigDecimal value) {
		this.alterAmount = value;
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
	public void setAlterMaxAdvanceAmount(java.math.BigDecimal value) {
		this.alterMaxAdvanceAmount = value;
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
	public void setAlterCurrentAdvanceAmount(java.math.BigDecimal value) {
		this.alterCurrentAdvanceAmount = value;
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
	public void setAlterUsedAdvanceAmount(java.math.BigDecimal value) {
		this.alterUsedAdvanceAmount = value;
	}
	/**
	 * 已用垫资额度变动金额
	 */
	public java.math.BigDecimal getAlterUsedAdvanceAmount() {
		return this.alterUsedAdvanceAmount;
	}
	/**
	 * 可垫资冻结额度变动金额
	 */
	public void setAlterAdvanceFrozenAmount(java.math.BigDecimal value) {
		this.alterAdvanceFrozenAmount = value;
	}
	/**
	 * 可垫资冻结额度变动金额
	 */
	public java.math.BigDecimal getAlterAdvanceFrozenAmount() {
		return this.alterAdvanceFrozenAmount;
	}
	/**
	 * 各累计金额字段的变动金额(收单/冻结/退回)
	 */
	public void setAlterAmountForGrandTotal(java.math.BigDecimal value) {
		this.alterAmountForGrandTotal = value;
	}
	/**
	 * 各累计金额字段的变动金额(收单/冻结/退回)
	 */
	public java.math.BigDecimal getAlterAmountForGrandTotal() {
		return this.alterAmountForGrandTotal;
	}
	/**
	 * 当日累计收单金额
	 */
	public void setGrandTotalReceiveAmount(java.math.BigDecimal value) {
		this.grandTotalReceiveAmount = value;
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
	public void setGrandTotalFrozenAmount(java.math.BigDecimal value) {
		this.grandTotalFrozenAmount = value;
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
	public void setGrandTotalReturnAmount(java.math.BigDecimal value) {
		this.grandTotalReturnAmount = value;
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
	public void setAlterAmountForAvailableGrandTotal(java.math.BigDecimal value) {
		this.alterAmountForAvailableGrandTotal = value;
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
	public void setGrandTotalAvailableFrozenAmount(java.math.BigDecimal value) {
		this.grandTotalAvailableFrozenAmount = value;
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
	public void setGrandTotalAvailableReturnAmount(java.math.BigDecimal value) {
		this.grandTotalAvailableReturnAmount = value;
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
	public void setClearStage(Integer value) {
		this.clearStage = value;
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
	public void setClearNo(java.lang.String value) {
		this.clearNo = value;
	}
	/**
	 * 清算编号
	 */
	public java.lang.String getClearNo() {
		return this.clearNo;
	}
	/**
	 * 备注
	 */
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	/**
	 * 备注
	 */
	public java.lang.String getRemark() {
		return this.remark;
	}
	
	/**
	 * 
	 * @description:    计算当日累计收单金额
	 * @param amount    收单金额     
	 * @author:         huang.jin
	 * @date:           2017年9月25日 上午9:14:49
	 *
	 */
	public void calGrandTotalReceiveAmount(BigDecimal amount) {
		
		// 当日累计金额 = 当日累计金额 + 收单金额
		this.grandTotalReceiveAmount = AmountUtil.add(this.grandTotalReceiveAmount, amount);
	}
	
	/**
	 * 
	 * @description:        计算当日累计冻结金额
	 * @param frozenAmount  冻结金额      
	 * @author:             huang.jin
	 * @date:               2017年9月25日 上午9:17:39
	 *
	 */
	public void calGrandTotalFrozenAmount(BigDecimal frozenAmount) {
		
		// 当日累计冻结金额 = 当日累计冻结金额 + 冻结金额
		this.grandTotalFrozenAmount = AmountUtil.add(this.grandTotalFrozenAmount, frozenAmount);
	}
	
	/**
	 * 
	 * @description:        计算当日累计退回金额 
	 * @param returnAmount  退回金额       
	 * @author:             huang.jin
	 * @date:               2017年9月25日 上午9:20:24
	 *
	 */
	public void calGrandTotalReturnAmount(BigDecimal returnAmount) {
		
		// 当日累计退回金额 = 当日累计退回金额 + 退回金额
		this.grandTotalReturnAmount = AmountUtil.add(this.grandTotalReturnAmount, returnAmount);
	}
	
	/**
	 * 
	 * @description:                  计算当日累计可垫资冻结金额
	 * @param availableFrozenAmount   可垫资冻结金额     
	 * @author:                       huang.jin
	 * @date:                         2017年9月25日 上午9:25:25
	 *
	 */
	public void calGrandTotalAvailableFrozenAmount(BigDecimal availableFrozenAmount) {
		
		// 当日累计可垫资冻结金额 = 当日累计可垫资冻结金额 + 可垫资冻结金额
		this.grandTotalAvailableFrozenAmount = AmountUtil.add(this.grandTotalAvailableFrozenAmount, availableFrozenAmount);
	}
	
	/**
	 * 
	 * @description:                 计算当日累计可垫资退回金额
	 * @param availableReturnAmount  可垫资退回金额
	 * @author:                      huang.jin
	 * @date:                        2017年9月25日 上午9:28:14
	 *
	 */
	public void calGrandTotalAvailableReturnAmount(BigDecimal availableReturnAmount) {
		
		// 当日累计可垫资退回金额 = 当日累计可垫资退回金额 + 可垫资退回金额
		this.grandTotalAvailableReturnAmount = AmountUtil.add(this.grandTotalAvailableReturnAmount, availableReturnAmount);
	}

}

