package com.junlon.facade.account.entity;


import com.junlon.common.base.entity.BaseEntity;
import com.junlon.common.base.exceptions.AccountAdvanceBizException;
import com.junlon.common.base.utils.number.AmountUtil;

import java.math.BigDecimal;

/**
 * 
 *
 * @description: 垫资账户实体类
 * @author: huang.jin
 * @date: 2017年9月18日 下午6:00:51
 * @version: 1.0
 *
 */
public class AccountAdvance extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	//columns START
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
	 * 最大垫资额度
	 */
	private java.math.BigDecimal maxAdvanceAmount = BigDecimal.ZERO;
	/**
	 * 当前垫资额度
	 */
	private java.math.BigDecimal currentAdvanceAmount = BigDecimal.ZERO;
	/**
	 * 可用垫资额度(可为负数)
	 */
	private java.math.BigDecimal availableAdvanceAmount = BigDecimal.ZERO;
	/**
	 * 已用可垫资额度(已成功出款)
	 */
	private java.math.BigDecimal usedAdvanceAmount = BigDecimal.ZERO;
	/**
	 * 可垫资冻结额度
	 */
	private java.math.BigDecimal advanceFrozenAmount = BigDecimal.ZERO;
	/**
	 * 垫资比例
	 */
	private java.math.BigDecimal advanceScale = BigDecimal.ZERO;
	/**
	 * 当日累计收单金额
	 */
	private java.math.BigDecimal grandTotalReceiveAmount = BigDecimal.ZERO;
	/**
	 * 当日累计冻结金额
	 */
	private java.math.BigDecimal grandTotalFrozenAmount = BigDecimal.ZERO;
	/**
	 * 当日累计可垫资冻结金额
	 */
	private java.math.BigDecimal grandTotalAvailableFrozenAmount = BigDecimal.ZERO;
	/**
	 * 当日累计退回金额
	 */
	private java.math.BigDecimal grandTotalReturnAmount = BigDecimal.ZERO;
	/**
	 * 当日累计可垫资退回金额
	 */
	private java.math.BigDecimal grandTotalAvailableReturnAmount = BigDecimal.ZERO;
	/**
	 * 最近清零日期
	 */
	private java.util.Date lastClearDate;
	/**
	 * 最近日汇总日期
	 */
	private java.util.Date lastDailyCollectDate;

	/**
	 * 更新者
	 */
	private java.lang.String updator;
	//columns END

	private TempAccountAdvance tempAccountAdvance;

	/**
	 *
	 * @description:    复制垫资账户的值到临时值中
	 * @author:         huang.jin
	 * @date:           2017年10月9日 上午10:28:14
	 *
	 */
	public void copyValueOfAccountAdvance() {
		if(null == tempAccountAdvance) {
			tempAccountAdvance = new TempAccountAdvance();
		}

		// 存储垫资账户的临时值
		tempAccountAdvance.maxAdvanceAmount = AmountUtil.bigDecimalFormat(this.maxAdvanceAmount);
		tempAccountAdvance.advanceFrozenAmount = AmountUtil.bigDecimalFormat(this.advanceFrozenAmount);
		tempAccountAdvance.availableAdvanceAmount = AmountUtil.bigDecimalFormat(this.availableAdvanceAmount);
		tempAccountAdvance.currentAdvanceAmount = AmountUtil.bigDecimalFormat(this.currentAdvanceAmount);
		tempAccountAdvance.grandTotalAvailableFrozenAmount = AmountUtil.bigDecimalFormat(this.grandTotalAvailableFrozenAmount);
		tempAccountAdvance.grandTotalAvailableReturnAmount = AmountUtil.bigDecimalFormat(this.grandTotalAvailableReturnAmount);
		tempAccountAdvance.grandTotalFrozenAmount = AmountUtil.bigDecimalFormat(this.grandTotalFrozenAmount);
		tempAccountAdvance.grandTotalReceiveAmount = AmountUtil.bigDecimalFormat(this.grandTotalReceiveAmount);
		tempAccountAdvance.grandTotalReturnAmount = AmountUtil.bigDecimalFormat(this.grandTotalReturnAmount);
		tempAccountAdvance.usedAdvanceAmount = AmountUtil.bigDecimalFormat(this.usedAdvanceAmount);
	}

	public AccountAdvance(){}

	public TempAccountAdvance getTempAccountAdvance() {

		return tempAccountAdvance;
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
	 * 可用垫资额度(可为负数)
	 */
	public void setAvailableAdvanceAmount(java.math.BigDecimal value) {
		this.availableAdvanceAmount = value;
	}
	/**
	 * 可用垫资额度(可为负数)
	 */
	public java.math.BigDecimal getAvailableAdvanceAmount() {
		return this.availableAdvanceAmount;
	}
	/**
	 * 当日累计已用可垫资额度(已成功出款)
	 */
	public void setUsedAdvanceAmount(java.math.BigDecimal value) {
		this.usedAdvanceAmount = value;
	}
	/**
	 * 当日累计已用可垫资额度(已成功出款)
	 */
	public java.math.BigDecimal getUsedAdvanceAmount() {
		return this.usedAdvanceAmount;
	}
	/**
	 * 可垫资冻结额度
	 */
	public void setAdvanceFrozenAmount(java.math.BigDecimal value) {
		this.advanceFrozenAmount = value;
	}
	/**
	 * 可垫资冻结额度
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
	 * 最近清零日期
	 */
	public void setLastClearDate(java.util.Date value) {
		this.lastClearDate = value;
	}
	/**
	 * 最近清零日期
	 */
	public java.util.Date getLastClearDate() {
		return this.lastClearDate;
	}
	/**
	 * 最近日汇总日期
	 */
	public void setLastDailyCollectDate(java.util.Date value) {
		this.lastDailyCollectDate = value;
	}
	/**
	 * 最近日汇总日期
	 */
	public java.util.Date getLastDailyCollectDate() {
		return this.lastDailyCollectDate;
	}

	public java.lang.String getUpdator() {
		return updator;
	}

	public void setUpdator(java.lang.String updator) {
		this.updator = updator;
	}

	/**
	 *
	 * @description:                 调整最高垫资额度
	 * @param maxModifyAdvanceAmount 待调整的最高垫资额度
	 * @author: huang.jin
	 * @date: 2017年9月21日 下午2:07:52
	 *
	 */
	public void adjustMaxAdvanceAmount(BigDecimal maxModifyAdvanceAmount) {

		if(AmountUtil.bigger(maxModifyAdvanceAmount.doubleValue(), BigDecimal.ZERO.doubleValue())) {
			this.maxAdvanceAmount = maxModifyAdvanceAmount;
		} else {
			throw AccountAdvanceBizException.ACCOUNT_ADVANCE_MAX_AMOUNT_LESS_ZERO;
		}
	}

	/**
	 *
	 * @description: 计算当前垫资额度
	 * @author: huang.jin
	 * @date: 2017年9月21日 上午10:38:38
	 *
	 */
	public void calCurrentAdvanceAmount() {

		BigDecimal tempValue = AmountUtil.mul(this.grandTotalReceiveAmount, this.advanceScale);  // 当日累计收款 * 垫资比例

		/*
		 * 如果最高垫资额度 < tempValue，则当前垫资额度 = 最大垫资额度，
		 * 如果最高垫资额度 >= tempValue，则当前垫资额度 = tempValue(当日累计收款 * 垫资比例)
		 */
		if(AmountUtil.lessThan(this.maxAdvanceAmount.doubleValue(), tempValue.doubleValue())) {
			this.currentAdvanceAmount = this.maxAdvanceAmount;
		} else {
			this.currentAdvanceAmount = tempValue;
		}
	}

	/**
	 *
	 * @description:    计算可用垫资额度
	 * @author: huang.jin
	 * @date: 2017年9月21日 上午11:12:45
	 *
	 */
	public void calAvaliableAdvanceAmount() {

		// 可用垫资额度=当前垫资额度+当日累计退回_可垫资-当日累计冻结_可垫资
		this.availableAdvanceAmount = AmountUtil.subtract(AmountUtil.add(this.currentAdvanceAmount, this.grandTotalAvailableReturnAmount),
				this.grandTotalAvailableFrozenAmount);
	}

	/**
	 *
	 * @description:        计算已用垫资额度
	 * @param advanceAmount 可用垫资金额_变动
	 * @author: huang.jin
	 * @date: 2017年9月21日 上午11:31:12
	 *
	 */
	public void calUsedAdvanceAmount(BigDecimal advanceAmount) {

		// 已用垫资额度 = 已用垫资额度 + 可用垫资额度_变动（累计当日的已用垫资额度，第二日会进行清零操作）
		this.usedAdvanceAmount = AmountUtil.add(this.usedAdvanceAmount, advanceAmount);
	}

	/**
	 *
	 * @description:        计算当日累计收款金额
	 * @param receiveAmount 收款金额（变动金额）
	 * @author: huang.jin
	 * @date: 2017年9月21日 下午2:17:48
	 *
	 */
	public void calGrandTotalReceiveAmount(BigDecimal receiveAmount) {

		// 当日累计收款金额  = 当日累计收款金额 + 收款金额
		this.grandTotalReceiveAmount = AmountUtil.add(this.grandTotalReceiveAmount, receiveAmount);
	}

	/**
	 *
	 * @description:        计算当日累计冻结金额
	 * @param frozenAmount  冻结金额
	 * @author: huang.jin
	 * @date: 2017年9月21日 下午2:20:11
	 *
	 */
	public void calGrandTotalFrozenAmount(BigDecimal frozenAmount) {

		// 当日累计冻结金额 = 当日累计冻结金额 + 冻结金额
		this.grandTotalFrozenAmount = AmountUtil.add(this.grandTotalFrozenAmount, frozenAmount);
	}

	/**
	 *
	 * @description:                 计算当日累计可垫资冻结金额
	 * @param availableFrozenAmount  可垫资冻结金额
	 * @author: huang.jin
	 * @date: 2017年9月21日 下午2:25:08
	 *
	 */
	public void calGrandTotalAvailableFrozenAmount(BigDecimal availableFrozenAmount) {

		// 当日累计可垫资冻结金额 = 当日累计可垫资冻结金额 + 可垫资冻结金额
		this.grandTotalAvailableFrozenAmount = AmountUtil.add(this.grandTotalAvailableFrozenAmount, availableFrozenAmount);
	}

	/**
	 *
	 * @description:        计算当日累计退回金额
	 * @param returnAmount  退回金额
	 * @author: huang.jin
	 * @date: 2017年9月21日 下午2:28:51
	 *
	 */
	public void calGrandTotalReturnAmount(BigDecimal returnAmount) {

		// 当日累计退回金额 = 当日累计退回金额 + 退回金额
		this.grandTotalReturnAmount = AmountUtil.add(this.grandTotalReturnAmount, returnAmount);
	}

	/**
	 *
	 * @description:                  计算当日累计可垫资退回
	 * @param availableReturnAmount   可垫资退回
	 * @author: huang.jin
	 * @date: 2017年9月21日 下午2:33:18
	 *
	 */
	public void calGrandTotalAvailableReturnAmount(BigDecimal availableReturnAmount) {

		// 当日累计可垫资退回 = 当日累计可垫资退回 + 可垫资退回
		this.grandTotalAvailableReturnAmount = AmountUtil.add(this.grandTotalAvailableReturnAmount, availableReturnAmount);
	}

	/**
	 *
	 * @description:  垫资账户的临时值类
	 * @author:       huang.jin
	 * @date:         2017年9月25日 上午10:33:34
	 * @version:      1.0
	 *
	 */
	public class TempAccountAdvance {
		/**
		 * 最大垫资金额
		 */
		java.math.BigDecimal maxAdvanceAmount = BigDecimal.ZERO;
		/**
		 * 当前垫资额度
		 */
		java.math.BigDecimal currentAdvanceAmount = BigDecimal.ZERO;
		/**
		 * 可用垫资额度(可为负数)
		 */
		java.math.BigDecimal availableAdvanceAmount = BigDecimal.ZERO;
		/**
		 * 已用可垫资额度(已成功出款)
		 */
		java.math.BigDecimal usedAdvanceAmount = BigDecimal.ZERO;
		/**
		 * 可垫资冻结额度
		 */
		java.math.BigDecimal advanceFrozenAmount = BigDecimal.ZERO;
		/**
		 * 当日累计收单金额
		 */
		java.math.BigDecimal grandTotalReceiveAmount = BigDecimal.ZERO;
		/**
		 * 当日累计冻结金额
		 */
		java.math.BigDecimal grandTotalFrozenAmount = BigDecimal.ZERO;
		/**
		 * 当日累计可垫资冻结金额
		 */
		java.math.BigDecimal grandTotalAvailableFrozenAmount = BigDecimal.ZERO;
		/**
		 * 当日累计退回金额
		 */
		java.math.BigDecimal grandTotalReturnAmount = BigDecimal.ZERO;
		/**
		 * 当日累计可垫资退回金额
		 */
		java.math.BigDecimal grandTotalAvailableReturnAmount = BigDecimal.ZERO;

		public java.math.BigDecimal getMaxAdvanceAmount() {
			return maxAdvanceAmount;
		}
		public void setMaxAdvanceAmount(java.math.BigDecimal maxAdvanceAmount) {
			this.maxAdvanceAmount = maxAdvanceAmount;
		}
		public java.math.BigDecimal getCurrentAdvanceAmount() {
			return currentAdvanceAmount;
		}
		public void setCurrentAdvanceAmount(java.math.BigDecimal currentAdvanceAmount) {
			this.currentAdvanceAmount = currentAdvanceAmount;
		}
		public java.math.BigDecimal getAvailableAdvanceAmount() {
			return availableAdvanceAmount;
		}
		public void setAvailableAdvanceAmount(
				java.math.BigDecimal availableAdvanceAmount) {
			this.availableAdvanceAmount = availableAdvanceAmount;
		}
		public java.math.BigDecimal getUsedAdvanceAmount() {
			return usedAdvanceAmount;
		}
		public void setUsedAdvanceAmount(java.math.BigDecimal usedAdvanceAmount) {
			this.usedAdvanceAmount = usedAdvanceAmount;
		}
		public java.math.BigDecimal getAdvanceFrozenAmount() {
			return advanceFrozenAmount;
		}
		public void setAdvanceFrozenAmount(java.math.BigDecimal advanceFrozenAmount) {
			this.advanceFrozenAmount = advanceFrozenAmount;
		}
		public java.math.BigDecimal getGrandTotalReceiveAmount() {
			return grandTotalReceiveAmount;
		}
		public void setGrandTotalReceiveAmount(
				java.math.BigDecimal grandTotalReceiveAmount) {
			this.grandTotalReceiveAmount = grandTotalReceiveAmount;
		}
		public java.math.BigDecimal getGrandTotalFrozenAmount() {
			return grandTotalFrozenAmount;
		}
		public void setGrandTotalFrozenAmount(
				java.math.BigDecimal grandTotalFrozenAmount) {
			this.grandTotalFrozenAmount = grandTotalFrozenAmount;
		}
		public java.math.BigDecimal getGrandTotalAvailableFrozenAmount() {
			return grandTotalAvailableFrozenAmount;
		}
		public void setGrandTotalAvailableFrozenAmount(
				java.math.BigDecimal grandTotalAvailableFrozenAmount) {
			this.grandTotalAvailableFrozenAmount = grandTotalAvailableFrozenAmount;
		}
		public java.math.BigDecimal getGrandTotalReturnAmount() {
			return grandTotalReturnAmount;
		}
		public void setGrandTotalReturnAmount(
				java.math.BigDecimal grandTotalReturnAmount) {
			this.grandTotalReturnAmount = grandTotalReturnAmount;
		}
		public java.math.BigDecimal getGrandTotalAvailableReturnAmount() {
			return grandTotalAvailableReturnAmount;
		}
		public void setGrandTotalAvailableReturnAmount(
				java.math.BigDecimal grandTotalAvailableReturnAmount) {
			this.grandTotalAvailableReturnAmount = grandTotalAvailableReturnAmount;
		}
		
	}
	
}

