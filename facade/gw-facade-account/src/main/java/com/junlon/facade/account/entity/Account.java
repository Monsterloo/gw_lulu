/**
 * 
 */
package com.junlon.facade.account.entity;

import com.junlon.common.base.entity.BaseEntity;
import com.junlon.common.base.exceptions.AccountBizException;
import com.junlon.common.base.utils.number.AmountUtil;
import com.junlon.facade.account.enums.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author Administrator
 * 
 */
public class Account extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = LoggerFactory.getLogger(Account.class);

	/**
	 * 账户编号
	 */
	private String accountNo;
	/**
	 * 用户编号
	 */
	private String userNo;
	/**
	 * 账户状态
	 */
	private Integer status;
	/**
	 * 账户余额
	 */
	private Double balance = 0D;
	/**
	 * 不可用余额
	 */
	private Double unBalance = 0D;
	/**
	 * 保证金
	 */
	private Double securityMoney = 0D;
	/**
	 * 账户类型
	 */
	private Integer accountType;
	/**
	 * 最后更新时间
	 */
	private Date lastTime = new Date();
	/**
	 * 可结算金额
	 */
	private Double availableSettAmount = 0D;
	/**
	 * 可结算金额（旧）
	 */
	private Double availableSettAmountOld = 0D;

	/**
	 * 可出款金额
	 */
	private Double currentCanOutAmount = 0D;

	/**
	 * 会计科目代码
	 */
	private String accountTitleNo;

	/**
	 * 最大垫资比例
	 */
	private Double maxPayForSubScale = 0D;

	/**
	 * 当前出款累计金额
	 */
	private Double currentDebitAddUpAmount = 0D;

	/**
	 * 当前收款累计金额
	 */
	private Double currentCreditAddUpAmount = 0D;

	/**
	 * 当前出款累计金额临时
	 */
	private Double currentDebitAddUpAmountTemp = 0D;

	/**
	 * 当前收款累计金额临时
	 */
	private Double currentCreditAddUpAmountTemp = 0D;
	
	/**
	 * 未结算金额(待清算金额)
	 */
	private java.math.BigDecimal unsettleAmount = BigDecimal.ZERO;

	/**
	 * 风控冻结金额
	 */
	private java.math.BigDecimal rsmAmount = BigDecimal.ZERO;

	/**
	 * 可结算冻结金额
	 */
	private java.math.BigDecimal availablesettamountFrozen = BigDecimal.ZERO;

	/**
	 * 是否使用新账务处理逻辑(100=是 101=否)
	 */
	private Integer isNewAccountLogic = PublicStatusEnum.ACTIVE.getValue();

	private TempAccount tempAccount;

	/**
	 *
	 * @description:    复制账户的值到tempAccount对象的临时属性中
	 * @author:         huang.jin
	 * @date:           2017年10月9日 上午10:28:51
	 *
	 */
	public void copyValueOfAccount() {
		if(null == tempAccount) {
			tempAccount = new TempAccount();
		}

		tempAccount.availableSettAmount = AmountUtil.bigDecimalFormat(this.availableSettAmount);
		tempAccount.availablesettamountFrozen = AmountUtil.bigDecimalFormat(this.availablesettamountFrozen);
		tempAccount.balance = AmountUtil.bigDecimalFormat(this.balance);
		tempAccount.currentCanOutAmount = AmountUtil.bigDecimalFormat(this.currentCanOutAmount);
		tempAccount.rsmAmount = AmountUtil.bigDecimalFormat(this.rsmAmount);
		tempAccount.unBalance = AmountUtil.bigDecimalFormat(this.unBalance);
		tempAccount.unsettleAmount = AmountUtil.bigDecimalFormat(this.unsettleAmount);
	}

	public Account() {}

	public TempAccount getTempAccount() {

		return tempAccount;
	}

	public void setTempAccount(TempAccount tempAccount) {
		this.tempAccount = tempAccount;
	}

	/**
	 * 账户编号
	 *
	 * @return
	 */
	public String getAccountNo() {
		return accountNo.trim();
	}

	/**
	 * 账户编号
	 *
	 * @param accountNo
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	/**
	 * 余额
	 *
	 * @return
	 */
	public Double getBalance() {
		return balance;
	}

	/**
	 * 余额
	 *
	 * @return
	 */
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	/**
	 * 不可用余额
	 *
	 * @return
	 */
	public Double getUnBalance() {
		return unBalance;
	}

	/**
	 * 不可用余额
	 *
	 * @return
	 */
	public void setUnBalance(Double unBalance) {
		this.unBalance = unBalance;
	}

	/**
	 * 保证金
	 *
	 * @return
	 */
	public Double getSecurityMoney() {
		return securityMoney;
	}

	/**
	 * 保证金
	 *
	 * @return
	 */
	public void setSecurityMoney(Double securityMoney) {
		this.securityMoney = securityMoney;
	}

	/**
	 * 账户状态
	 *
	 * @return
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 账户状态
	 *
	 * @return
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 账户类型
	 *
	 * @return
	 */

	public Integer getAccountType() {
		return accountType;
	}

	/**
	 * 账户类型
	 *
	 * @param accountType
	 */
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	/**
	 * 最后更新时间
	 *
	 * @return
	 */
	public Date getLastTime() {
		return lastTime;
	}

	/**
	 * 最后更新时间
	 *
	 * @return
	 */
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	/**
	 * 会计科目代码
	 *
	 * @return
	 */
	public String getAccountTitleNo() {
		return accountTitleNo;
	}

	/**
	 * 会计科目代码
	 *
	 * @param accountTitleNo
	 */
	public void setAccountTitleNo(String accountTitleNo) {
		this.accountTitleNo = accountTitleNo;
	}

	/**
	 * 可结算金额
	 *
	 * @return
	 */
	public Double getAvailableSettAmount() {
		return availableSettAmount;
	}

	/**
	 * 可结算金额
	 *
	 * @return
	 */
	public void setAvailableSettAmount(Double availableSettAmount) {
 		if (AmountUtil.bigger(availableSettAmount, this.balance)) {
			log.info("===>可结算:availableSettAmount：,账户余额:"+availableSettAmount,this.balance);
			this.availableSettAmount = this.getAvailableBalance();
		}else if (AmountUtil.bigger(availableSettAmount, this.getAvailableBalance())) {
			log.info("当前可结算大于可用余额时===>可结算:availableSettAmount："+availableSettAmount);
			this.availableSettAmount = this.getAvailableBalance();
		} else {
			this.availableSettAmount = availableSettAmount;
		}
	}

	public Double getAvailableSettAmountOld() {
		return availableSettAmountOld;
	}

	public void setAvailableSettAmountOld(Double availableSettAmountOld) {
		this.availableSettAmountOld = availableSettAmountOld;
	}

	/**
	 * 可出款金额
	 * @return
	 */
	public Double getCurrentCanOutAmount() {
		return currentCanOutAmount;
	}

	/**
	 * 可出款金额
	 * @return
	 */
	public void setCurrentCanOutAmount(Double currentCanOutAmount) {
		this.currentCanOutAmount = currentCanOutAmount;
	}

	/**
	 * 最大垫资比例
	 *
	 * @return
	 */
	public Double getMaxPayForSubScale() {
		return maxPayForSubScale;
	}

	/**
	 * 最大垫资比例
	 *
	 * @param maxPayForSubScale
	 */
	public void setMaxPayForSubScale(Double maxPayForSubScale) {
		this.maxPayForSubScale = maxPayForSubScale;
	}

	/**
	 * 当前出款累计金额
	 */
	public Double getCurrentDebitAddUpAmount() {
		return currentDebitAddUpAmount;
	}

	/**
	 * 当前出款累计金额
	 */
	public void setCurrentDebitAddUpAmount(Double currentDebitAddUpAmount) {
		this.currentDebitAddUpAmount = currentDebitAddUpAmount;
	}

	/**
	 * 当前收款累计金额
	 */
	public Double getCurrentCreditAddUpAmount() {
		return currentCreditAddUpAmount;
	}

	/**
	 * 当前收款累计金额
	 */
	public void setCurrentCreditAddUpAmount(Double currentCreditAddUpAmount) {
		this.currentCreditAddUpAmount = currentCreditAddUpAmount;
	}

	/**
	 * 当前出款累计金额临时
	 */
	public Double getCurrentDebitAddUpAmountTemp() {
		return currentDebitAddUpAmountTemp;
	}

	/**
	 * 当前出款累计金额临时
	 */
	public void setCurrentDebitAddUpAmountTemp(Double currentDebitAddUpAmountTemp) {
		this.currentDebitAddUpAmountTemp = currentDebitAddUpAmountTemp;
	}

	/**
	 * 当前收款累计金额临时
	 */
	public Double getCurrentCreditAddUpAmountTemp() {
		return currentCreditAddUpAmountTemp;
	}

	/**
	 * 当前收款累计金额临时
	 */
	public void setCurrentCreditAddUpAmountTemp(Double currentCreditAddUpAmountTemp) {
		this.currentCreditAddUpAmountTemp = currentCreditAddUpAmountTemp;
	}

	/**
	 * 未结算金额
	 */
	public java.math.BigDecimal getUnsettleAmount() {
		return unsettleAmount;
	}

	/**
	 * 未结算金额
	 */
	public void setUnsettleAmount(java.math.BigDecimal unsettleAmount) {
		this.unsettleAmount = unsettleAmount;
	}

	/**
	 * 风控冻结金额
	 */
	public java.math.BigDecimal getRsmAmount() {
		return rsmAmount;
	}

	/**
	 * 风控冻结金额
	 */
	public void setRsmAmount(java.math.BigDecimal rsmAmount) {
		this.rsmAmount = rsmAmount;
	}

	/**
	 * 可结算冻结金额
	 */
	public java.math.BigDecimal getAvailablesettamountFrozen() {
		return availablesettamountFrozen;
	}

	/**
	 * 可结算冻结金额
	 */
	public void setAvailablesettamountFrozen(
			java.math.BigDecimal availablesettamountFrozen) {
		this.availablesettamountFrozen = availablesettamountFrozen;
	}

	/**
	 * 是否使用新账务处理
	 * @see com.junlon.facade.account.vo.AccountAmountVo#isUseNewAccountLogic()
	 * @return
	 */
	public boolean isUseNewAccountLogic(){
		return this.isNewAccountLogic != null && this.isNewAccountLogic == PublicStatusEnum.ACTIVE.getValue();
	}

	/**
	 * 存入
	 *
	 * @param amount
	 */
	public void credit(Double amount) {
		if (this.status.intValue() == AccountStatusEnum.INACTIVE.getValue()
				|| this.status.intValue() == AccountStatusEnum.CANCELLED.getValue()
				|| this.status.intValue() == AccountStatusEnum.INACTIVE_FREEZE_CREDIT.getValue()) {
			throw AccountBizException.ACCOUNT_STATUS_IS_INACTIVE.newInstance("账户状态异常,用户编号{%s},账户状态{%s}", userNo, this.status.intValue())
					.print();
		}
		this.lastTime = new Date();
		this.setBalance(AmountUtil.add(this.balance, amount));
	}

	/**
	 * 支出
	 *
	 * @param amount
	 * @param accountTradeTypeType
	 */
	public void debit(Double amount, AccountTradeTypeEnum accountTradeTypeType) {
		if (this.status.intValue() == AccountStatusEnum.INACTIVE.getValue()
				|| this.status.intValue() == AccountStatusEnum.CANCELLED.getValue()
				|| this.status.intValue() == AccountStatusEnum.INACTIVE_FREEZE_DEBIT.getValue()) {
			throw AccountBizException.ACCOUNT_STATUS_IS_INACTIVE.newInstance("账户状态异常,用户编号{%s},账户状态{%s}", userNo,
					this.status.intValue()).print();
		}

		if (! this.availableBalanceIsEnough(amount)) {
			throw AccountBizException.ACCOUNT_AVAILABLEBALANCE_IS_NOT_ENOUGH.newInstance("账户状态异常,用户编号{%s},amount{%s},可用余额{%s}",
					userNo, amount, this.getAvailableBalance()).print();
		}
		this.lastTime = new Date();
		this.setBalance(AmountUtil.sub(this.balance, amount));
		this.setAvailableSettAmount(AmountUtil.sub(this.availableSettAmount, amount)); // 可结算金额减少
		if(this.isBackupAccount()) {//如果是备付金账户，需要扣减相应的可出款金额
			this.setCurrentCanOutAmount(AmountUtil.sub(this.currentCanOutAmount, amount));
		}
	}

	/**
	 * 资金冻结
	 *
	 * @param frozenAmount			冻结金额
	 * @param payForSubAmount		垫资金额
	 * @param accountTradeTypeType	账户类型
	 */
	public void frozen(Double frozenAmount, Double payForSubAmount, AccountTradeTypeEnum accountTradeTypeType, AccountSubTradeTypeEnum subTradeType) {
		if (this.status.intValue() == AccountStatusEnum.INACTIVE.getValue()
				|| this.status.intValue() == AccountStatusEnum.INACTIVE_FREEZE_DEBIT.getValue()) {
			throw AccountBizException.ACCOUNT_STATUS_IS_INACTIVE.newInstance("账户状态异常,用户编号{%s},账户状态{%s}", userNo,
					this.status.intValue()).print();
		}

		if (!this.availableBalanceIsEnough(frozenAmount)) {
			throw AccountBizException.ACCOUNT_AVAILABLEBALANCE_IS_NOT_ENOUGH.print();
		}
		//如果是子商户结算，需要判断可结算金额是否充足
		if(subTradeType != null && subTradeType.getValue()==AccountSubTradeTypeEnum.SETTLE_REMIT.getValue()){
			if(AmountUtil.bigger(frozenAmount, this.getAvailableSettAmount())){
				throw AccountBizException.ACCOUNT_SETTLE_AMOUNT_LARGER.print();
			}
		}
		if(this.isBackupAccount() && ! this.availableCanOutAmountIsEnough(frozenAmount)) {//如果是备付金账户，需要判断可出款金额是否充足
			throw AccountBizException.ACCOUNT_CANOUT_AMOUNT_NOT_ENOUGH.print();
		}
		this.lastTime = new Date();
		this.setUnBalance(AmountUtil.add(this.unBalance, frozenAmount));//不可用金额增加
		this.setAvailableSettAmount(AmountUtil.sub(this.availableSettAmount, AmountUtil.sub(frozenAmount, payForSubAmount))); // 可结算金额减少
	}

	/**
	 * 资金解冻
	 *
	 * @param frozenAmount			冻结金额
	 * @param payForSubAmount		垫资金额
	 * @param accountTradeTypeType	账户类型
	 */
	public void unFrozen(Double frozenAmount, Double payForSubAmount, AccountTradeTypeEnum accountTradeTypeType) {
		if (AmountUtil.bigger(frozenAmount, this.unBalance)) {
			String message = "userNo="+this.userNo+",accountNo="+this.accountNo+",frozenAmount="+frozenAmount+",unBalance="+this.unBalance;
			throw AccountBizException.ACCOUNT_UN_FROZEN_AMOUNT_OUTLIMIT.print(message);
		}
		this.lastTime = new Date();
		this.setUnBalance(AmountUtil.sub(this.unBalance, frozenAmount));
		this.setAvailableSettAmount(AmountUtil.add(this.availableSettAmount, AmountUtil.sub(frozenAmount, payForSubAmount))); // 可结算金额增加
	}

	/**
	 * 获取可用余额: 账户余额 - 不可用金额
	 *
	 * @return
	 */
	public Double getAvailableBalance() {
		return AmountUtil.sub(this.balance, this.unBalance);
	}

	/**
	 * 获取实际可用的可出款金额: 可出款金额  - 不可用金额
	 * @return
	 */
	public Double getAvailableCanOut(){
		double canOut = this.currentCanOutAmount==null ? 0.0 : this.currentCanOutAmount;
		return AmountUtil.sub(canOut, this.unBalance);
	}

	/**
	 * 获取最大垫资金额：累计收款金额 * 最大垫资比例 - 累计出款金额
	 *
	 * @return
	 */
	public Double getMaxPayForSubAmount() {
		return AmountUtil.roundDown(AmountUtil.sub(AmountUtil.mul(this.currentCreditAddUpAmount, this.maxPayForSubScale),
				this.currentDebitAddUpAmount));
	}

	/**
	 * 获取最大可结算金额
	 * 		1.如果可结算金额字段小于0，则返回 可结算金额 + 累计出款金额 + 最大垫资金额，即等于：可结算金额 + 累计出款金额 + (累计收款金额 * 最大垫资比例 - 累计出款金额)
	 * 		2.如果 累计出款金额 大于 (累计收款金额 * 最大垫资比例)，则等于 可结算金额
	 * 		3.其他情况则等于：可结算金额 + 最大垫资金额，即等于：可结算金额 + (累计收款金额 * 最大垫资比例 - 累计出款金额)
	 *
	 * @return
	 */
	public Double getMaxAvailableSettAmount() {
//		if (AmountUtil.bigger(0D, this.availableSettAmount)) {
//			return AmountUtil.add(AmountUtil.add(this.availableSettAmount, this.currentDebitAddUpAmount), this.getMaxPayForSubAmount());
//		} else {
			// 冻结
//			if (AmountUtil.bigger(this.currentDebitAddUpAmount, AmountUtil.mul(this.currentCreditAddUpAmount, this.maxPayForSubScale))) {
//				return this.availableSettAmount;
//			}
//			return AmountUtil.add(this.availableSettAmount, this.getMaxPayForSubAmount());
//		}
		return AmountUtil.add(this.availableSettAmount, this.getMaxPayForSubAmount());
	}

	/**
	 * 验证可用余额是否足够
	 *
	 * @param amount
	 * @return
	 */
	public boolean availableBalanceIsEnough(double amount) {
		if (AmountUtil.greaterThanOrEqualTo(this.getAvailableBalance(), amount)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.print(AmountUtil.sub(800, -200));
	}

	/**
	 * 判断当前账户是否是备付金账户
	 * @return
	 */
	public boolean isBackupAccount(){
		return this.accountType.intValue() == AccountTypeEnum.PRIVATE.getValue();
	}

	/**
	 * 判断可出款金额是否足够
	 * @param amount
	 * @return
	 */
	public boolean availableCanOutAmountIsEnough(double amount) {
		if (AmountUtil.greaterThanOrEqualTo(this.getAvailableCanOut(), amount)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 是否使用新账务处理逻辑(100=是 101=否)
	 * @return
	 */
	public Integer getIsNewAccountLogic() {
		return isNewAccountLogic;
	}
	/**
	 * 是否使用新账务处理逻辑(100=是 101=否)
	 * @param isNewAccountLogic
	 */
	public void setIsNewAccountLogic(Integer isNewAccountLogic) {
		this.isNewAccountLogic = isNewAccountLogic;
	}

	/**
	 *
	 * @description:  存储账户临时值
	 * @author:       huang.jin
	 * @date:         2017年9月26日 下午4:46:43
	 * @version:      1.0
	 *
	 */
	public class TempAccount {

		private java.math.BigDecimal balance = BigDecimal.ZERO;
		private java.math.BigDecimal unBalance = BigDecimal.ZERO;
		private java.math.BigDecimal availableSettAmount = BigDecimal.ZERO;
		private java.math.BigDecimal currentCanOutAmount = BigDecimal.ZERO;
		private java.math.BigDecimal unsettleAmount = BigDecimal.ZERO;
		private java.math.BigDecimal rsmAmount = BigDecimal.ZERO;
		private java.math.BigDecimal availablesettamountFrozen = BigDecimal.ZERO;
		private java.math.BigDecimal alterAdvanceAmount = BigDecimal.ZERO;    // 可垫资金额的变化金额
		private java.math.BigDecimal alterUnAdvanceAmount = BigDecimal.ZERO;  // 不可垫资金额的变化金额

		public java.math.BigDecimal getBalance() {
			return balance;
		}
		public void setBalance(java.math.BigDecimal balance) {
			this.balance = balance;
		}
		public java.math.BigDecimal getUnBalance() {
			return unBalance;
		}
		public void setUnBalance(java.math.BigDecimal unBalance) {
			this.unBalance = unBalance;
		}
		public java.math.BigDecimal getAvailableSettAmount() {
			return availableSettAmount;
		}
		public void setAvailableSettAmount(java.math.BigDecimal availableSettAmount) {
			this.availableSettAmount = availableSettAmount;
		}
		public java.math.BigDecimal getCurrentCanOutAmount() {
			return currentCanOutAmount;
		}
		public void setCurrentCanOutAmount(java.math.BigDecimal currentCanOutAmount) {
			this.currentCanOutAmount = currentCanOutAmount;
		}
		public java.math.BigDecimal getUnsettleAmount() {
			return unsettleAmount;
		}
		public void setUnsettleAmount(java.math.BigDecimal unsettleAmount) {
			this.unsettleAmount = unsettleAmount;
		}
		public java.math.BigDecimal getRsmAmount() {
			return rsmAmount;
		}
		public void setRsmAmount(java.math.BigDecimal rsmAmount) {
			this.rsmAmount = rsmAmount;
		}
		public java.math.BigDecimal getAvailablesettamountFrozen() {
			return availablesettamountFrozen;
		}
		public void setAvailablesettamountFrozen(java.math.BigDecimal availablesettamountFrozen) {
			this.availablesettamountFrozen = availablesettamountFrozen;
		}
		public java.math.BigDecimal getAlterAdvanceAmount() {
			return alterAdvanceAmount;
		}
		public void setAlterAdvanceAmount(java.math.BigDecimal alterAdvanceAmount) {
			this.alterAdvanceAmount = alterAdvanceAmount;
		}
		public java.math.BigDecimal getAlterUnAdvanceAmount() {
			return alterUnAdvanceAmount;
		}
		public void setAlterUnAdvanceAmount(java.math.BigDecimal alterUnAdvanceAmount) {
			this.alterUnAdvanceAmount = alterUnAdvanceAmount;
		}
	}
	
}
