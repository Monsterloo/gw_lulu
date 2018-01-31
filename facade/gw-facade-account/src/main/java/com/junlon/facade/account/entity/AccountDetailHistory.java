/*
 * Powered By [joinPay.com]
 */

package com.junlon.facade.account.entity;


import com.junlon.common.base.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 主账户明细表的历史记录
 */
public class AccountDetailHistory extends BaseEntity {

	private static final long serialVersionUID = 1L;

	//columns START
	/**
	 * 迁移时间(即本条记录的创建时间)
	 */
	private java.util.Date migrationTime;

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
	private String requestNo;

	/**
	 * 账号
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
	 * 余额
	 */
	private java.math.BigDecimal balance;

	/**
	 * 不可用金额(可结+可垫+不可垫冻结金额)
	 */
	private java.math.BigDecimal unbalance;

	/**
	 * 可结算金额
	 */
	private java.math.BigDecimal availablesettamount;

	/**
	 * 待结算金额
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
	 * 交易发生时间
	 */
	public void setTrxTime(java.util.Date trxTime) {
		this.trxTime = trxTime;
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
	 * 账号
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	/**
	 * 账号
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
	 * 余额
	 */
	public void setBalance(java.math.BigDecimal balance) {
		this.balance = balance;
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
	public void setUnbalance(java.math.BigDecimal unbalance) {
		this.unbalance = unbalance;
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
	public void setAvailablesettamount(java.math.BigDecimal availablesettamount) {
		this.availablesettamount = availablesettamount;
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
	public void setUnsettleAmount(java.math.BigDecimal unsettleAmount) {
		this.unsettleAmount = unsettleAmount;
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
	public void setRsmAmount(java.math.BigDecimal rsmAmount) {
		this.rsmAmount = rsmAmount;
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
	public void setAvailablesettamountFrozen(java.math.BigDecimal availablesettamountFrozen) {
		this.availablesettamountFrozen = availablesettamountFrozen;
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
	public void setAlterAmount(java.math.BigDecimal alterAmount) {
		this.alterAmount = alterAmount;
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
	public void setAlterBalance(java.math.BigDecimal alterBalance) {
		this.alterBalance = alterBalance;
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
	public void setAlterUnbalance(java.math.BigDecimal alterUnbalance) {
		this.alterUnbalance = alterUnbalance;
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
	public void setAlterAvailablesettamount(java.math.BigDecimal alterAvailablesettamount) {
		this.alterAvailablesettamount = alterAvailablesettamount;
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
	public void setAlterUnsettleAmount(java.math.BigDecimal alterUnsettleAmount) {
		this.alterUnsettleAmount = alterUnsettleAmount;
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
	public void setAlterRsmAmount(java.math.BigDecimal alterRsmAmount) {
		this.alterRsmAmount = alterRsmAmount;
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
	public void setAlterAdvanceAmount(java.math.BigDecimal alterAdvanceAmount) {
		this.alterAdvanceAmount = alterAdvanceAmount;
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
	public void setAlterUnadvanceAmount(java.math.BigDecimal alterUnadvanceAmount) {
		this.alterUnadvanceAmount = alterUnadvanceAmount;
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
	public void setAlterAvailablesettamountFrozen(java.math.BigDecimal alterAvailablesettamountFrozen) {
		this.alterAvailablesettamountFrozen = alterAvailablesettamountFrozen;
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

	public static List<AccountDetail> convertToAccountDetail(List<AccountDetailHistory> detailHistoryList){
		List<AccountDetail> detailList = new ArrayList<AccountDetail>();
		if(detailHistoryList == null || detailHistoryList.size() == 0){
			return detailList;
		}

		for(AccountDetailHistory detailHistory : detailHistoryList){
			AccountDetail detail = new AccountDetail();
			detail.setId(detailHistory.getId());
			detail.setCreateTime(detailHistory.getCreateTime());
			detail.setTrxTime(detailHistory.getTrxTime());
			detail.setTrxDate(detailHistory.getTrxDate());
			detail.setAccountTrxType(detailHistory.getAccountTrxType());
			detail.setRequestNo(detailHistory.getRequestNo());
			detail.setAccountNo(detailHistory.getAccountNo());
			detail.setUserNo(detailHistory.getUserNo());
			detail.setAccountType(detailHistory.getAccountType());
			detail.setBalance(detailHistory.getBalance());
			detail.setUnbalance(detailHistory.getUnbalance());
			detail.setAvailablesettamount(detailHistory.getAvailablesettamount());
			detail.setUnsettleAmount(detailHistory.getUnsettleAmount());
			detail.setRsmAmount(detailHistory.getRsmAmount());
			detail.setAvailablesettamountFrozen(detailHistory.getAvailablesettamountFrozen());
			detail.setAlterAmount(detailHistory.getAlterAmount());
			detail.setAlterBalance(detailHistory.getAlterBalance());
			detail.setAlterUnbalance(detailHistory.getAlterUnbalance());
			detail.setAvailablesettamountFrozen(detailHistory.getAvailablesettamountFrozen());
			detail.setAlterAvailablesettamount(detailHistory.getAlterAvailablesettamount());
			detail.setAlterUnsettleAmount(detailHistory.getAlterUnsettleAmount());
			detail.setAlterRsmAmount(detailHistory.getAlterRsmAmount());
			detail.setAlterAdvanceAmount(detailHistory.getAlterAdvanceAmount());
			detail.setAlterUnadvanceAmount(detailHistory.getAlterUnadvanceAmount());
			detail.setAlterAvailablesettamountFrozen(detailHistory.getAlterAvailablesettamountFrozen());
			detail.setAlterType(detailHistory.getAlterType());
			detail.setFee(detailHistory.getFee());
			detail.setFundDirection(detailHistory.getFundDirection());
			detail.setRemark(detailHistory.getRemark());
			detailList.add(detail);
		}
		return detailList;
	}
}
