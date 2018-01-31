package com.junlon.facade.account.service;

import com.junlon.common.base.exceptions.AccountBizException;
import com.junlon.common.base.page.PageBean;
import com.junlon.common.base.page.PageParam;
import com.junlon.facade.account.entity.Account;
import com.junlon.facade.account.entity.AccountAdvance;
import com.junlon.facade.account.entity.AccountDetail;
import com.junlon.facade.account.vo.AccountAmountVo;

import java.util.List;
import java.util.Map;

/**
 * 账户查询
 * 
 * @author healy
 * 
 */
public interface AccountQueryFacade {

	public boolean isRequestNoHasBeenIncome(String requestNo, String accountNo);

	public List<AccountDetail> listAccountDetailByRequestNo(String requestNo);

	/**
	 * 获取账户相关的金额业务对象
	 * @param userNo
	 * @return
	 */
	AccountAmountVo getAccountAmountVoByUserNo(String userNo);

	/**
	 * 查询账务信息
	 * @param pageParam
	 * @param paramMap
	 */
	public PageBean queryAccountList(PageParam pageParam, Map<String, Object> paramMap);

	/**
	 * 根据当前登录用户的用户号获取当前用户的账户金额信息并且格式化金额
	 * @return
	 */
	public AccountAmountVo getFormattingAccountAmountVo(String userNo, int degree);

	/**
	 * 账户详细查询
	 * @param pageParam
	 * @param paramMap
	 * @return
	 * @throws AccountBizException
	 */
	PageBean queryAccountDetailListPage(PageParam pageParam, Map<String, Object> paramMap) throws AccountBizException;

	/**
	 * 查询垫资账户
	 * @param accountNo
	 * @return
	 */
	AccountAdvance queryAccountAdvanceByAccountNo(String accountNo);

	/**
	 * @Author: LuJunLang
	 * @Description: 统计商户金额记录
	 * @Date: 2018-01-02
	 */
	public Map<String, Object> sumMerchantData(Map<String, Object> paramMap);

	/**
	 * 账户历史查询.
	 * 
	 * @param pageParam
	 *            分页参数.
	 * @param paramMap
	 *            查询参数.
	 * @return AccountHistoryList.
	 * @throws AccountBizException
	 */
	PageBean queryAccountHistoryListPage(PageParam pageParam, Map<String, Object> paramMap) throws AccountBizException;

	/**
	 * 根据用户编号获取账户信息 .
	 * 
	 * @param userNo
	 *            用户编号.
	 * @return account 查询到的账户信息.
	 * @throws AccountBizException
	 */
	Account getAccountByUserNo(String userNo) throws AccountBizException;

	/**
	 * 根据多个用户编号获取账户信息.
	 * @deprecated
	 * @param userNoList 多个用户编号.
	 * @return List<Account> 查询到的账户信息.
	 */
	List<Account> getAccountByUserNoList(List<String> userNoList);

	/**
	 * 根据多个用户编号获取账户信息.
	 *
	 * @param userNoList 多个用户编号.
	 * @return List<Account> 查询到的账户信息.
	 */
	Map<String, Account> listAccountByUserNoList(List<String> userNoList);
	
	/**
	 * 根据账户编号查询账户信息.
	 * 
	 * @param accountNo
	 *            账户编号.
	 * @return account 查询到的账户信息.
	 * @throws AccountBizException
	 */
	Account getAccountByAccountNo(String accountNo) throws AccountBizException;

	/**
     * 
     * @description:    获取垫资账户对象
     * @param userNo    用户编号
     * @return          
     * @author:         huang.jin
     * @date:           2017年10月30日 上午10:41:19
     *
     */
	public AccountAdvance getAccountAdvanceByUserNo(String userNo);
}
