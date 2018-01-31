package com.junlon.facade.account.vo;

import com.junlon.common.base.utils.date.DateUtils;
import com.junlon.common.base.utils.number.AmountUtil;
import com.junlon.facade.account.enums.PublicStatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by chenyf on 2017/9/26.
 */
public class AccountAmountVo implements Serializable {
    private static final long serialVersionUID = -6352417258390618916L;
    private transient Logger logger = LoggerFactory.getLogger(this.getClass());



    /**
     * 用户号/商户号
     */
    private String userNo;
    /**
     * 账号
     */
    private String accountNo;
    /**
     * 账户类型：{@link com.junlon.facade.account.enums.AccountTypeEnum}
     */
    private Integer accountType;
    /**
     * tbl_account表的状态：100:激活 101:冻结
     */
    private Integer status;
    /**
     * 余额
     */
    private BigDecimal balance = BigDecimal.ZERO;
    /**
     * 不可用余额（即所有的冻结金额）
     */
    private BigDecimal unBalance = BigDecimal.ZERO;
    /**
     * 可出款金额：只针对通道备付金有用
     */
    private BigDecimal currentCanOutAmount = BigDecimal.ZERO;
    /**
     * 可结算金额
     */
    private BigDecimal availableSettAmount = BigDecimal.ZERO;
    /**
     * 可结算的冻结金额
     */
    private BigDecimal availableSettAmountFrozen = BigDecimal.ZERO;
    /**
     * 未结金额/待清算金额
     */
    private BigDecimal unSettleAmount = BigDecimal.ZERO;
    /**
     * 风控金额
     */
    private BigDecimal rsmAmount = BigDecimal.ZERO;
    /**
     * 是否使用新账务处理逻辑(100=是 101=否)
     */
    private Integer isNewAccountLogic;
    private double currentCreditAddUpAmount;
    /**
     * 当前出款累计金额临时
     */
    private Double currentDebitAddUpAmountTemp = 0D;
    /**
     * 当前收款累计金额临时
     */
    private Double currentCreditAddUpAmountTemp = 0D;
    /**
     * 最大垫资比例
     */
    private Double maxPayForSubScale = 0D;


    /**-----------------------------------以下是垫资账户相关-------------------------------------*/

    /**
     * 最大垫资额度
     */
    private BigDecimal maxAdvanceAmount = BigDecimal.ZERO;
    /**
     * 当前垫资额度
     */
    private BigDecimal currentAdvanceAmount = BigDecimal.ZERO;
    /**
     * 可用垫资额度(可为负数)
     */
    private BigDecimal availableAdvanceAmount = BigDecimal.ZERO;
    /**
     * 已用可垫资额度(已成功出款)
     */
    private BigDecimal usedAdvanceAmount = BigDecimal.ZERO;
    /**
     * 可垫资冻结额度
     */
    private BigDecimal advanceFrozenAmount = BigDecimal.ZERO;
    /**
     * 垫资比例
     */
    private BigDecimal advanceScale = BigDecimal.ZERO;
    /**
     * 当日累计收单金额
     */
    private BigDecimal grandTotalReceiveAmount = BigDecimal.ZERO;
    /**
     * 当日累计冻结金额
     */
    private BigDecimal grandTotalFrozenAmount = BigDecimal.ZERO;
    /**
     * 当日累计可垫资冻结金额
     */
    private BigDecimal grandTotalAvailableFrozenAmount = BigDecimal.ZERO;
    /**
     * 当日累计退回金额
     */
    private BigDecimal grandTotalReturnAmount = BigDecimal.ZERO;
    /**
     * 当日累计可垫资退回金额
     */
    private BigDecimal grandTotalAvailableReturnAmount = BigDecimal.ZERO;

    /**
     * 实际可用的可结算金额临时值
     */
    private BigDecimal usefulAvailableSettAmountTemp = BigDecimal.ZERO;

    /**
     * 实际可用的可垫资金额临时值
     */
    private BigDecimal usefulAvailableAdvanceAmountTemp = BigDecimal.ZERO;

    /**
     * 实际可用的可用余额临时值
     */
    private BigDecimal availableBalanceTemp = BigDecimal.ZERO;

    /**
     * 上一次清零时间
     */
    private Date lastClearDate;

    /**
     * 上一次日汇总时间
     */
    private Date lastDailyCollectDate;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getUnBalance() {
        return unBalance;
    }

    public void setUnBalance(BigDecimal unBalance) {
        this.unBalance = unBalance;
    }

    public BigDecimal getCurrentCanOutAmount() {
        return currentCanOutAmount;
    }

    public void setCurrentCanOutAmount(BigDecimal currentCanOutAmount) {
        this.currentCanOutAmount = currentCanOutAmount;
    }

    public BigDecimal getAvailableSettAmount() {
        return availableSettAmount;
    }

    public void setAvailableSettAmount(BigDecimal availableSettAmount) {
        this.availableSettAmount = availableSettAmount;
    }

    public BigDecimal getAvailableSettAmountFrozen() {
        return availableSettAmountFrozen;
    }

    public void setAvailableSettAmountFrozen(BigDecimal availableSettAmountFrozen) {
        this.availableSettAmountFrozen = availableSettAmountFrozen;
    }

    public BigDecimal getUnSettleAmount() {
        return unSettleAmount;
    }

    public void setUnSettleAmount(BigDecimal unSettleAmount) {
        this.unSettleAmount = unSettleAmount;
    }

    public BigDecimal getRsmAmount() {
        return rsmAmount;
    }

    public void setRsmAmount(BigDecimal rsmAmount) {
        this.rsmAmount = rsmAmount;
    }

    public BigDecimal getMaxAdvanceAmount() {
        return maxAdvanceAmount;
    }

    public void setMaxAdvanceAmount(BigDecimal maxAdvanceAmount) {
        this.maxAdvanceAmount = maxAdvanceAmount;
    }

    public BigDecimal getCurrentAdvanceAmount() {
        return currentAdvanceAmount;
    }

    public void setCurrentAdvanceAmount(BigDecimal currentAdvanceAmount) {
        this.currentAdvanceAmount = currentAdvanceAmount;
    }

    public BigDecimal getAvailableAdvanceAmount() {
        return availableAdvanceAmount;
    }

    public void setAvailableAdvanceAmount(BigDecimal availableAdvanceAmount) {
        this.availableAdvanceAmount = availableAdvanceAmount;
    }

    public BigDecimal getUsedAdvanceAmount() {
        return usedAdvanceAmount;
    }

    public void setUsedAdvanceAmount(BigDecimal usedAdvanceAmount) {
        this.usedAdvanceAmount = usedAdvanceAmount;
    }

    public BigDecimal getAdvanceFrozenAmount() {
        return advanceFrozenAmount;
    }

    public void setAdvanceFrozenAmount(BigDecimal advanceFrozenAmount) {
        this.advanceFrozenAmount = advanceFrozenAmount;
    }

    public BigDecimal getAdvanceScale() {
        return advanceScale;
    }

    public void setAdvanceScale(BigDecimal advanceScale) {
        this.advanceScale = advanceScale;
    }

    public BigDecimal getGrandTotalReceiveAmount() {
        return grandTotalReceiveAmount;
    }

    public void setGrandTotalReceiveAmount(BigDecimal grandTotalReceiveAmount) {
        this.grandTotalReceiveAmount = grandTotalReceiveAmount;
    }

    public BigDecimal getGrandTotalFrozenAmount() {
        return grandTotalFrozenAmount;
    }

    public void setGrandTotalFrozenAmount(BigDecimal grandTotalFrozenAmount) {
        this.grandTotalFrozenAmount = grandTotalFrozenAmount;
    }

    public BigDecimal getGrandTotalAvailableFrozenAmount() {
        return grandTotalAvailableFrozenAmount;
    }

    public void setGrandTotalAvailableFrozenAmount(BigDecimal grandTotalAvailableFrozenAmount) {
        this.grandTotalAvailableFrozenAmount = grandTotalAvailableFrozenAmount;
    }

    public BigDecimal getGrandTotalReturnAmount() {
        return grandTotalReturnAmount;
    }

    public void setGrandTotalReturnAmount(BigDecimal grandTotalReturnAmount) {
        this.grandTotalReturnAmount = grandTotalReturnAmount;
    }

    public BigDecimal getGrandTotalAvailableReturnAmount() {
        return grandTotalAvailableReturnAmount;
    }

    public void setGrandTotalAvailableReturnAmount(BigDecimal grandTotalAvailableReturnAmount) {
        this.grandTotalAvailableReturnAmount = grandTotalAvailableReturnAmount;
    }

    public BigDecimal getUsefulAvailableSettAmountTemp() {
        return usefulAvailableSettAmountTemp;
    }

    public void setUsefulAvailableSettAmountTemp(BigDecimal usefulAvailableSettAmountTemp) {
        this.usefulAvailableSettAmountTemp = usefulAvailableSettAmountTemp;
    }

    public BigDecimal getUsefulAvailableAdvanceAmountTemp() {
        return usefulAvailableAdvanceAmountTemp;
    }

    public void setUsefulAvailableAdvanceAmountTemp(BigDecimal usefulAvailableAdvanceAmountTemp) {
        this.usefulAvailableAdvanceAmountTemp = usefulAvailableAdvanceAmountTemp;
    }

    public BigDecimal getAvailableBalanceTemp() {
        return availableBalanceTemp;
    }

    public void setAvailableBalanceTemp(BigDecimal availableBalanceTemp) {
        this.availableBalanceTemp = availableBalanceTemp;
    }

    public Date getLastClearDate() {
        return lastClearDate;
    }

    public void setLastClearDate(Date lastClearDate) {
        this.lastClearDate = lastClearDate;
    }

    public Date getLastDailyCollectDate() {
        return lastDailyCollectDate;
    }

    public void setLastDailyCollectDate(Date lastDailyCollectDate) {
        this.lastDailyCollectDate = lastDailyCollectDate;
    }

    /**
     * 获取实际可用的可结算金额，当风控冻结金额超过可结算金额时，返回0
     * @return
     */
    public BigDecimal getUsefulAvailableSettAmount(){
        if(AmountUtil.bigger(this.availableSettAmount.doubleValue(), this.rsmAmount.doubleValue())){
            return BigDecimal.valueOf(AmountUtil.sub(this.availableSettAmount, this.rsmAmount));
        }else{
            return BigDecimal.ZERO;
        }
    }

    /**
     * 获取实际可用的当日可垫资金额（不包含不可垫资），当金额出现负数时强制返回0，需要结合 "账务和清结算技术实现方案.doc" 文档中的图片来理解
     * @return
     */
    public BigDecimal getUsefulAvailableAdvanceAmount(){
        //如果还未完成每日汇总，直接返回0
        if(! isDailyClearDone()){
            return BigDecimal.ZERO;
        }

        double maxAvailableBalance = this.getMaxAvailableBalance().doubleValue();
        if(AmountUtil.greaterThanOrEqualTo(0D, this.availableAdvanceAmount.doubleValue())){
            //如果 可用垫资金额 <= 0，则直接返回0
            return BigDecimal.ZERO;
        }else if(AmountUtil.greaterThanOrEqualTo(0D, maxAvailableBalance)){
            //如果 实际最大可用余额 < 0，说明风控已经超额冻结了，应该返回0
            return BigDecimal.ZERO;
        }else if(AmountUtil.greaterThanOrEqualTo(this.availableAdvanceAmount.doubleValue(), maxAvailableBalance)){
            //如果 可用垫资金额 > 实际最大可用余额，说明风控冻住了一部分可用垫资金额，应该返回实际可用余额
            return BigDecimal.valueOf(maxAvailableBalance);
        }else{
            //如果 可用垫资金额 > 0 && 可用垫资金额 <= 实际最大可用余额，说明风控没有冻结可用垫资金额，应该返回所有的可用垫资金额
            return this.availableAdvanceAmount;
        }
    }

    /**
     * 获取实际可用余额 = 可结 + 当日可垫 - 风控
     * 说明：
     *     1、当可用垫资金额大于0，并且已完成每日清零操作时，实际可用余额 = 可结 + 当日可垫 - 风控
     *     2、当可用垫资金额大于0，但是未完成每日清零操作时，实际可用余额 = 可结 - 风控
     *     3、当可用垫资金额小于或等于0时，实际可用余额 = 可结 - 风控
     *     4、如果实际可用余额小于0，则会强制返回0
     * @return
     */
    public BigDecimal getAvailableBalance(){
        double totalBalance = 0D;
        if(AmountUtil.bigger(this.availableAdvanceAmount.doubleValue(), 0D)){
            if(isDailyClearDone()){
                //可用垫资金额大于0，并且已完成每日清零操作时，可用余额 = 可结算金额 + 可用垫资金额
                totalBalance = AmountUtil.add(this.availableSettAmount.doubleValue(), this.availableAdvanceAmount.doubleValue());
            }else{
                //可用垫资金额大于0，但未完成每日清零操作时，可用余额 = 可结算金额
                totalBalance = this.availableSettAmount.doubleValue();
            }
        }else{
            //可用垫资金额小于或等于0时，不管有没有完成清零，可用余额 = 可结算金额
            totalBalance = this.availableSettAmount.doubleValue();
        }
        if(AmountUtil.bigger(totalBalance, this.rsmAmount.doubleValue())){
            //可用余额大于风控冻结金额时，实际可用余额 = 可用余额 - 风控冻结金额
            return BigDecimal.valueOf(AmountUtil.sub(totalBalance, this.rsmAmount.doubleValue()));
        }else{
            //可用余额小于或等于风控冻结金额时，实际可用余额 = 0
            return BigDecimal.ZERO;
        }
    }

    /**
     * 获取实际最大可用余额（扣减风控金额之后） = 余额 - 不可用 - 未结 - 风控 等同于 (可结 + 当日可垫 + 当日不可垫 - 风控)
     * 注意：
     *     1、在未完成日汇总之前，不管是否有清零，这个值都是一样的，只不过清零前有一部分是可垫资金额，清零后就被认为全部都是不可垫金额，所以，
     *     为了避免在当天可以使用到昨日的不可垫，在未日汇总之前，此方法直接返回实际可用余额，另外，在进行账务处理时，如果是还未完成日汇总，
     *     则不可以使用不可垫出款
     *     2、如果已完成了日汇总，则还会判断是否已完成日清零，如果还没有，会扣减掉可用垫资的金额再返回
     * @return
     */
    public BigDecimal getMaxAvailableBalance(){
        if(this.isDailyCollectDone()){
            double pureAvailableBalance = this.getPureAvailableBalance().doubleValue();
            //如果可用垫资大于0，且未完成每日清零，则需要扣减掉可用垫资金额
            if(AmountUtil.bigger(this.availableAdvanceAmount.doubleValue(), 0D) && ! isDailyClearDone()){
                pureAvailableBalance = AmountUtil.sub(pureAvailableBalance, this.availableAdvanceAmount.doubleValue());
            }

            //如果实际金额都小于0，肯定是数据出问题了，打印日志，方便问题排查
            if(AmountUtil.bigger(0D, pureAvailableBalance)){
                logger.error("userNo={},pureAvailableBalance={}", this.userNo, pureAvailableBalance);
            }

            if(AmountUtil.greaterThanOrEqualTo(pureAvailableBalance, this.rsmAmount.doubleValue())){
                return BigDecimal.valueOf(AmountUtil.sub(pureAvailableBalance, this.rsmAmount.doubleValue()));
            }else{
                return BigDecimal.ZERO;
            }
        }else{
            //未完成日汇总，不可垫金额将不能使用，所以直接使用可用余额
            return getAvailableBalance();
        }
    }

    /**
     * 获取单纯的可用余额(即不考虑风控) = 余额 - (未结 + 不可用)，正常的数据情况不会出现负数
     * @return
     */
    public BigDecimal getPureAvailableBalance(){
        return BigDecimal.valueOf(AmountUtil.sub(this.balance, AmountUtil.add(this.unSettleAmount, this.unBalance)));
    }

    /**
     * 判断是否已经进行过日汇总，如果已经日汇总过，返回true，否则返回false
     * @return
     */
    public boolean isDailyCollectDone(){
        return DateUtils.compareDate(new Date(), this.lastDailyCollectDate, Calendar.DATE) == 0;
    }

    /**
     * 判断是否已经进行过清零，如果已经清零过，返回true，否则返回false
     * @return
     */
    public boolean isDailyClearDone(){
        return DateUtils.compareDate(new Date(), this.lastClearDate, Calendar.DATE) == 0;
    }

    /**
     * 是否使用新账务处理方式
     * @see com.junlon.facade.account.entity.Account#isUseNewAccountLogic()
     * @return
     */
    public boolean isUseNewAccountLogic(){
        return this.isNewAccountLogic != null && this.isNewAccountLogic == PublicStatusEnum.ACTIVE.getValue();
    }
}
