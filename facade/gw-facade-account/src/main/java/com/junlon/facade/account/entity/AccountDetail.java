package com.junlon.facade.account.entity;

import com.junlon.common.base.entity.BaseEntity;

/**
 *
 * @description: 账户明细实体类
 * @author: huang.jin
 * @date: 2017年9月18日 下午6:07:08
 * @version: 1.0
 *
 */
public class AccountDetail extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	//columns START
	/**
	 * 交易发生时间
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
	 * 账号
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
	 * 余额
	 */
	private java.math.BigDecimal balance;
	/**
	 * 不可用余额(可结+可垫+不可垫冻结金额)
	 */
	private java.math.BigDecimal unbalance;
	/**
	 * 可结算金额
	 */
	private java.math.BigDecimal availablesettamount;
	/**
	 * 未结算金额
	 */
	private java.math.BigDecimal unsettleAmount;
	/**
	 * 风控冻结金额
	 */
	private java.math.BigDecimal rsmAmount;
	/**
	 * 可结算冻结金额
	 */
	private java.math.BigDecimal availablesettamountFrozen;
	/**
	 * 变动金额
	 */
	private java.math.BigDecimal alterAmount;
	/**
	 * 余额变动金额
	 */
	private java.math.BigDecimal alterBalance;
	/**
	 * 不可用金额变动金额
	 */
	private java.math.BigDecimal alterUnbalance;
	/**
	 * 可结算变动金额
	 */
	private java.math.BigDecimal alterAvailablesettamount;
	/**
	 * 变动未结算金额
	 */
	private java.math.BigDecimal alterUnsettleAmount;
	/**
	 * 变动风控金额
	 */
	private java.math.BigDecimal alterRsmAmount;
	/**
	 * 变动可垫资金额
	 */
	private java.math.BigDecimal alterAdvanceAmount;
	/**
	 * 变动不可垫资金额
	 */
	private java.math.BigDecimal alterUnadvanceAmount;
	/**
	 * 可结算冻结金额变动金额
	 */
	private java.math.BigDecimal alterAvailablesettamountFrozen;
	/**
	 * 变动类型(AccountAlterTypeEnum)
	 */
	private Integer alterType;
	/**
	 * 手续费
	 */
	private java.math.BigDecimal fee;
	/**
	 * 123:增加 321:减少
	 */
	private Integer fundDirection;
	/**
	 * 备注
	 */
	private java.lang.String remark;
	//columns END

	public AccountDetail(){
	}

	/**
	 * 交易发生时间
	 */
	public void setTrxTime(java.util.Date value) {
		this.trxTime = value;
	}
	/**
	 * 交易发生时间
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
	 * 账号
	 */
	public void setAccountNo(java.lang.String value) {
		this.accountNo = value;
	}
	/**
	 * 账号
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
	 * 余额
	 */
	public void setBalance(java.math.BigDecimal value) {
		this.balance = value;
	}
	/**
	 * 余额
	 */
	public java.math.BigDecimal getBalance() {
		return this.balance;
	}
	/**
	 * 不可用金额(可结+可垫+不可垫冻结金额)
	 */
	public void setUnbalance(java.math.BigDecimal value) {
		this.unbalance = value;
	}
	/**
	 * 不可用金额(可结+可垫+不可垫冻结金额)
	 */
	public java.math.BigDecimal getUnbalance() {
		return this.unbalance;
	}
	/**
	 * 可结算金额
	 */
	public void setAvailablesettamount(java.math.BigDecimal value) {
		this.availablesettamount = value;
	}
	/**
	 * 可结算金额
	 */
	public java.math.BigDecimal getAvailablesettamount() {
		return this.availablesettamount;
	}
	/**
	 * 待结算金额
	 */
	public void setUnsettleAmount(java.math.BigDecimal value) {
		this.unsettleAmount = value;
	}
	/**
	 * 待结算金额
	 */
	public java.math.BigDecimal getUnsettleAmount() {
		return this.unsettleAmount;
	}
	/**
	 * 风控冻结金额
	 */
	public void setRsmAmount(java.math.BigDecimal value) {
		this.rsmAmount = value;
	}
	/**
	 * 风控冻结金额
	 */
	public java.math.BigDecimal getRsmAmount() {
		return this.rsmAmount;
	}
	/**
	 * 可结算冻结金额
	 */
	public void setAvailablesettamountFrozen(java.math.BigDecimal value) {
		this.availablesettamountFrozen = value;
	}
	/**
	 * 可结算冻结金额
	 */
	public java.math.BigDecimal getAvailablesettamountFrozen() {
		return this.availablesettamountFrozen;
	}
	/**
	 * 变动金额
	 */
	public void setAlterAmount(java.math.BigDecimal value) {
		this.alterAmount = value;
	}
	/**
	 * 变动金额
	 */
	public java.math.BigDecimal getAlterAmount() {
		return this.alterAmount;
	}
	/**
	 * 余额变动金额
	 */
	public void setAlterBalance(java.math.BigDecimal value) {
		this.alterBalance = value;
	}
	/**
	 * 余额变动金额
	 */
	public java.math.BigDecimal getAlterBalance() {
		return this.alterBalance;
	}
	/**
	 * 不可用金额变动金额
	 */
	public void setAlterUnbalance(java.math.BigDecimal value) {
		this.alterUnbalance = value;
	}
	/**
	 * 不可用金额变动金额
	 */
	public java.math.BigDecimal getAlterUnbalance() {
		return this.alterUnbalance;
	}
	/**
	 * 可结算变动金额
	 */
	public void setAlterAvailablesettamount(java.math.BigDecimal value) {
		this.alterAvailablesettamount = value;
	}
	/**
	 * 可结算变动金额
	 */
	public java.math.BigDecimal getAlterAvailablesettamount() {
		return this.alterAvailablesettamount;
	}
	/**
	 * 变动未结算金额
	 */
	public void setAlterUnsettleAmount(java.math.BigDecimal value) {
		this.alterUnsettleAmount = value;
	}
	/**
	 * 变动未结算金额
	 */
	public java.math.BigDecimal getAlterUnsettleAmount() {
		return this.alterUnsettleAmount;
	}
	/**
	 * 变动风控金额
	 */
	public void setAlterRsmAmount(java.math.BigDecimal value) {
		this.alterRsmAmount = value;
	}
	/**
	 * 变动风控金额
	 */
	public java.math.BigDecimal getAlterRsmAmount() {
		return this.alterRsmAmount;
	}
	/**
	 * 变动可垫资金额
	 */
	public void setAlterAdvanceAmount(java.math.BigDecimal value) {
		this.alterAdvanceAmount = value;
	}
	/**
	 * 变动可垫资金额
	 */
	public java.math.BigDecimal getAlterAdvanceAmount() {
		return this.alterAdvanceAmount;
	}
	/**
	 * 变动不可垫资金额
	 */
	public void setAlterUnadvanceAmount(java.math.BigDecimal value) {
		this.alterUnadvanceAmount = value;
	}
	/**
	 * 变动不可垫资金额
	 */
	public java.math.BigDecimal getAlterUnadvanceAmount() {
		return this.alterUnadvanceAmount;
	}
	/**
	 * 可结算冻结金额变动金额
	 */
	public void setAlterAvailablesettamountFrozen(java.math.BigDecimal value) {
		this.alterAvailablesettamountFrozen = value;
	}
	/**
	 * 可结算冻结金额变动金额
	 */
	public java.math.BigDecimal getAlterAvailablesettamountFrozen() {
		return this.alterAvailablesettamountFrozen;
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

}

