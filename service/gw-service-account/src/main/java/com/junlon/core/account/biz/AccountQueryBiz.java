package com.junlon.core.account.biz;

import com.junlon.core.account.dao.AccountAdvanceDao;
import com.junlon.core.account.dao.AccountDao;
import com.junlon.core.account.dao.AccountDetailDao;
import com.junlon.facade.account.entity.AccountAdvance;
import com.junlon.facade.account.vo.AccountAmountVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by chenyf on 2017/9/26.
 */
@Component("accountQueryBiz")
public class AccountQueryBiz {
    private Logger logger = LoggerFactory.getLogger(AccountQueryBiz.class);
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private AccountAdvanceDao accountAdvanceDao;
    @Autowired
    private AccountDetailDao accountDetailDao;

    /**
     * 获取账户相关的金额业务对象
     * @param userNo
     * @return
     */
    public AccountAmountVo getAccountAmountVoByUserNo(String userNo){
        return accountDao.getAccountAmountVoByUserNo(userNo);
    }

    /**
     * 根据当前登录用户的用户号获取当前用户的账户金额信息并且格式化金额
     * @return
     */
    public AccountAmountVo getFormattingAccountAmountVo(String userNo, int degree){
        if(degree <= 0){
            degree = 2;
        }
        AccountAmountVo amountVo = this.getAccountAmountVoByUserNo(userNo);
        //余额
        amountVo.setBalance(amountVo.getBalance().setScale(degree, BigDecimal.ROUND_DOWN));
        //可结算金额
        amountVo.setAvailableSettAmount(amountVo.getAvailableSettAmount().setScale(degree, BigDecimal.ROUND_DOWN));
        //不可用余额
        amountVo.setUnBalance(amountVo.getUnBalance().setScale(degree, BigDecimal.ROUND_DOWN));
        //待清算金额
        amountVo.setUnSettleAmount(amountVo.getUnSettleAmount().setScale(degree, BigDecimal.ROUND_DOWN));
        //风控冻结金额
        amountVo.setRsmAmount(amountVo.getRsmAmount().setScale(degree, BigDecimal.ROUND_DOWN));
        //可结算冻结
        amountVo.setAvailableSettAmountFrozen(amountVo.getAvailableSettAmountFrozen().setScale(degree, BigDecimal.ROUND_DOWN));
        //可用垫资额度
        amountVo.setAvailableAdvanceAmount(amountVo.getAvailableAdvanceAmount().setScale(degree, BigDecimal.ROUND_DOWN));
        //已用垫资额度
        amountVo.setUsedAdvanceAmount(amountVo.getUsedAdvanceAmount().setScale(degree, BigDecimal.ROUND_DOWN));
        //垫资冻结额度
        amountVo.setAdvanceFrozenAmount(amountVo.getAdvanceFrozenAmount().setScale(degree, BigDecimal.ROUND_DOWN));
        //当前垫资额度
        amountVo.setCurrentAdvanceAmount(amountVo.getCurrentAdvanceAmount().setScale(degree, BigDecimal.ROUND_DOWN));
        //当日累计收款
        amountVo.setGrandTotalReceiveAmount(amountVo.getGrandTotalReceiveAmount().setScale(degree, BigDecimal.ROUND_DOWN));
        //最高垫资额度
        amountVo.setMaxAdvanceAmount(amountVo.getMaxAdvanceAmount().setScale(degree, BigDecimal.ROUND_DOWN));
        //控制比例
        amountVo.setAdvanceScale(amountVo.getAdvanceScale().setScale(degree, BigDecimal.ROUND_DOWN));
        //单日累计收款
        amountVo.setGrandTotalReceiveAmount(amountVo.getGrandTotalReceiveAmount().setScale(degree, BigDecimal.ROUND_DOWN));
        //当日累计冻结
        amountVo.setGrandTotalFrozenAmount(amountVo.getGrandTotalFrozenAmount().setScale(degree, BigDecimal.ROUND_DOWN));
        //当日可垫资冻结
        amountVo.setGrandTotalAvailableFrozenAmount(amountVo.getGrandTotalAvailableFrozenAmount().setScale(degree, BigDecimal.ROUND_DOWN));
        //当日累计退回
        amountVo.setGrandTotalReturnAmount(amountVo.getGrandTotalReturnAmount().setScale(degree, BigDecimal.ROUND_DOWN));
        //当日可垫资退回
        amountVo.setGrandTotalAvailableReturnAmount(amountVo.getGrandTotalAvailableReturnAmount().setScale(degree, BigDecimal.ROUND_DOWN));
        //实际可用余额临时值
        amountVo.setAvailableBalanceTemp(amountVo.getAvailableBalance().setScale(degree, BigDecimal.ROUND_DOWN));
        //实际可用的可结算金额临时值
        amountVo.setUsefulAvailableSettAmountTemp(amountVo.getUsefulAvailableSettAmount().setScale(degree, BigDecimal.ROUND_DOWN));
        //实际可用的可垫资金额临时值
        amountVo.setUsefulAvailableAdvanceAmountTemp(amountVo.getUsefulAvailableAdvanceAmount().setScale(degree, BigDecimal.ROUND_DOWN));

        return amountVo;
    }
    
    /**
     * 
     * @description:    获取垫资账户对象
     * @param userNo    用户编号
     * @return          
     * @author:         huang.jin
     * @date:           2017年10月30日 上午10:41:19
     *
     */
    public AccountAdvance getAccountAdvanceByUserNo(String userNo) {
    	return accountAdvanceDao.getByUserNo_IsPessimist(userNo, false);
    }

    /**
     * @Author: LuJunLang
     * @Description: 统计商户金额记录
     * @Date: 2018-01-02
     */
    public Map<String,Object> sumMerchantData(Map<String, Object> paramMap) {
        return  accountDao.sumData(paramMap);
    }
}
