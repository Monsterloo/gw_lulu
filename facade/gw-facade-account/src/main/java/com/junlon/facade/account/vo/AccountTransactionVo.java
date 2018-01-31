package com.junlon.facade.account.vo;


import com.junlon.facade.account.enums.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 交易命令参数vo
 * 
 * @author Administrator
 * 
 */
public class AccountTransactionVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2451289258390618916L;

	/**
	 * 交易时间
	 */
	protected Date createTime = new Date();

	/**
	 * 资金方向
	 */
	private AccountFundDirectionEnum accountFundDirection;

	/**
	 * 交易码
	 */
	private AccountTradeTypeEnum tradeType;

	/**
	 * 用户编号
	 */
	private String userNo;

	/**
	 * 手续费
	 */
	private double fee = 0D;

	/**
	 * 发生金额
	 */
	private double amount = 0D;

	/**
	 * 垫资金额
	 */
	private double payForSubAmount = 0D;

	/**
	 * 冻结金额
	 */
	private double frezonAmount = 0D;

	/**
	 * 解冻金额
	 */
	private double unFrezonAmount = 0D;
	
	/**
	 * 可结算金额
	 */
	private double settleAmount = 0D;
	
	/**
	 * 非垫资金额
	 */
	private double unadvanceAmount = 0D;

	/**
	 * 业务请求标识号,
	 */
	private String requestNo;

	/**
	 * 描述
	 */
	private String desc;

	/**
	 * 风险预存期天数
	 */
	private Integer riskDay;

	/**
	 * 是否设置可出款金额为等于可用余额，默认是不同步
	 */
	private Integer isSyncCanOutAmount = PublicStatusEnum.INACTIVE.getValue();

	/**
	 * 调整可出款金额的类型
	 */
	private Integer adjustCanOutType;
	
	/**
	 * 子商户号
	 */
	private String subUserNo;

	/**
	 * 是否需要退回处理，默认为false（请勿改变此默认值）
	 */
	private boolean isNeedRefund = false;
	/**
	 * 需要退回的金额，默认为0(请勿改变此默认值）
	 */
	private double refundAmount = 0D;

	/**
	 * 出款冻结时账户金额的使用类型，默认是使用可结算金额（请勿改变此默认值）
	 */
	private AmountTypeEnum amountType = AmountTypeEnum.SETTLE_AMOUNT;

	/**
	 * 是否属于未进行账户金额冻结的虚拟账户转账（请勿改变此默认值）
	 */
	private boolean isAccountTransferUnDoFrozen = false;

	/**
	 * 额外的信息，适用于打款重试等情况
	 */
	private String extraKey = "";

	/**
     * 子商户交易类型，目前只在子商户结算打款时用到
	 */
	private AccountSubTradeTypeEnum subTradeType = null;
	
	/**
	 * 子商户手续费
	 */
	private double feeSub = 0D;
	
	/**
	 * 子商户交易金额
	 */
	private double amountSub = 0D;

	/**
	 * 子商户冻结金额
	 */
	private double frozenAmountSub = 0D;

	/**
	 * 子商户解冻金额
	 */
	private double unFrozenAmountSub = 0D;
	

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public AccountFundDirectionEnum getAccountFundDirection() {
		return accountFundDirection;
	}

	public void setAccountFundDirection(AccountFundDirectionEnum accountFundDirection) {
		this.accountFundDirection = accountFundDirection;
	}

	public AccountTradeTypeEnum getTradeType() {
		return tradeType;
	}

	public void setTradeType(AccountTradeTypeEnum tradeType) {
		this.tradeType = tradeType;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	/**
	 * 解冻金额
	 */
	public double getUnFrezonAmount() {
		return unFrezonAmount;
	}

	/**
	 * 解冻金额，可不填
	 */
	public void setUnFrezonAmount(double unFrezonAmount) {
		this.unFrezonAmount = unFrezonAmount;
	}

	/**
	 * 冻结金额
	 */
	public double getFrezonAmount() {
		return frezonAmount;
	}

	/**
	 * 冻结金额，可不填
	 */
	public void setFrezonAmount(double frezonAmount) {
		this.frezonAmount = frezonAmount;
	}

	/**
	 * 风险预存期天数
	 */
	public Integer getRiskDay() {
		return riskDay;
	}

	/**
	 * 风险预存期天数，可不填
	 */
	public void setRiskDay(Integer riskDay) {
		this.riskDay = riskDay;
	}

	/**
	 * 垫资金额
	 * 
	 * @return
	 */
	public double getPayForSubAmount() {
		return payForSubAmount;
	}

	/**
	 * 垫资金额
	 * 
	 * @return
	 */
	public void setPayForSubAmount(double payForSubAmount) {
		this.payForSubAmount = payForSubAmount;
	}

	/**
	 * 是否同步重置可出款金额
	 * @return
	 */
	public Integer getSyncCanOutAmount() {
		return isSyncCanOutAmount;
	}

	/**
	 * 是否同步重置可出款金额
	 * @return
	 */
	public void setSyncCanOutAmount(Integer syncCanOutAmount) {
		isSyncCanOutAmount = syncCanOutAmount;
	}

	/**
	 * 调整可出款金额的类型
	 * @return
	 */
	public Integer getAdjustCanOutType() {
		return adjustCanOutType;
	}

	/**
	 * 调整可出款金额的类型
	 * @return
	 */
	public void setAdjustCanOutType(Integer adjustCanOutType) {
		this.adjustCanOutType = adjustCanOutType;
	}

	public String getSubUserNo() {
		return subUserNo;
	}

	public void setSubUserNo(String subUserNo) {
		this.subUserNo = subUserNo;
	}

	public double getSettleAmount() {
		return settleAmount;
	}

	public void setSettleAmount(double settleAmount) {
		this.settleAmount = settleAmount;
	}

	public double getUnadvanceAmount() {
		return unadvanceAmount;
	}

	public void setUnadvanceAmount(double unadvanceAmount) {
		this.unadvanceAmount = unadvanceAmount;
	}

	public AmountTypeEnum getAmountType() {
		return this.amountType;
	}

	public void setAmountType(AmountTypeEnum amountType) {
		this.amountType = amountType;
	}

	public boolean isNeedRefund() {
		return isNeedRefund;
	}

	public void setNeedRefund(boolean needRefund) {
		isNeedRefund = needRefund;
	}

	public String getExtraKey() {
		return extraKey;
	}

	public void setExtraKey(String extraKey) {
		this.extraKey = extraKey;
	}

	public AccountSubTradeTypeEnum getSubTradeType() {
		return subTradeType;
	}

	public void setSubTradeType(AccountSubTradeTypeEnum subTradeType) {
		this.subTradeType = subTradeType;
	}

	public double getFeeSub() {
		return feeSub;
	}

	public void setFeeSub(double feeSub) {
		this.feeSub = feeSub;
	}

	public double getAmountSub() {
		return amountSub;
	}

	public void setAmountSub(double amountSub) {
		this.amountSub = amountSub;
	}

	public double getFrozenAmountSub() {
		return frozenAmountSub;
	}

	public void setFrozenAmountSub(double frozenAmountSub) {
		this.frozenAmountSub = frozenAmountSub;
	}

	public double getUnFrozenAmountSub() {
		return unFrozenAmountSub;
	}

	public void setUnFrozenAmountSub(double unFrozenAmountSub) {
		this.unFrozenAmountSub = unFrozenAmountSub;
	}

	public boolean isAccountTransferUnDoFrozen() {
		return isAccountTransferUnDoFrozen;
	}

	public void setAccountTransferUnDoFrozen(boolean accountTransferUnDoFrozen) {
		isAccountTransferUnDoFrozen = accountTransferUnDoFrozen;
	}

	public double getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(double refundAmount) {
		this.refundAmount = refundAmount;
	}
}
