package com.junlon.facade.account.impl;

import com.junlon.common.base.exceptions.AccountBizException;
import com.junlon.common.base.page.PageBean;
import com.junlon.common.base.page.PageParam;
import com.junlon.common.base.utils.string.StringUtil;
import com.junlon.core.account.biz.AccountQueryBiz;
import com.junlon.core.account.dao.AccountAdvanceDao;
import com.junlon.core.account.dao.AccountDao;
import com.junlon.core.account.dao.AccountDetailDao;
import com.junlon.facade.account.entity.Account;
import com.junlon.facade.account.entity.AccountAdvance;
import com.junlon.facade.account.entity.AccountDetail;
import com.junlon.facade.account.service.AccountQueryFacade;
import com.junlon.facade.account.vo.AccountAmountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 账户查询
 * 
 * @author healy
 * 
 */
@Component("accountQueryFacade")
public class AccountQueryFacadeImpl implements AccountQueryFacade {
	@Autowired
	private AccountQueryBiz accountQueryBiz;
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private AccountDetailDao accountDetailDao;
	@Autowired
	private AccountAdvanceDao accountAdvanceDao;

	@Override
	public boolean isRequestNoHasBeenIncome(String requestNo, String accountNo) {
		return false;
	}

	@Override
	public List<AccountDetail> listAccountDetailByRequestNo(String requestNo){
		Map<String, Object> paramMap = new HashMap<>(1);
		paramMap.put("requestNo", requestNo);
		return accountDetailDao.listBy(paramMap);
	}

	/**
	 * 获取账户相关的金额业务对象
	 * @param userNo
	 * @return
	 */
	@Override
	public AccountAmountVo getAccountAmountVoByUserNo(String userNo){
		return accountQueryBiz.getAccountAmountVoByUserNo(userNo);
	}

	@Override
	public PageBean queryAccountList(PageParam pageParam, Map<String, Object> paramMap) {
		return accountDao.listPage(pageParam, paramMap);
	}

	/**
	 * 根据当前登录用户的用户号获取当前用户的账户金额信息并且格式化金额
	 * @return
	 */
	@Override
	public AccountAmountVo getFormattingAccountAmountVo(String userNo, int degree){
		return accountQueryBiz.getFormattingAccountAmountVo(userNo, degree);
	}

	/**
	 * 账户详细查询
	 *
	 * @Author: LuJunLang
	 * @Description:
	 * @Date: 2017-10-19
	 * @param pageParam
	 *            分页参数.
	 * @param paramMap
	 *            查询参数.
	 * @return AccountDetailList.
	 */
	@Override
	public PageBean queryAccountDetailListPage(PageParam pageParam, Map<String, Object> paramMap) throws AccountBizException {
		return accountDetailDao.listPage(pageParam, paramMap);
	}

	/**
	 * @Author: LuJunLang
	 * @Description: 查询垫资账户
	 * @Date: 2017-10-25
	 * @param accountNo
	 */
	@Override
	public AccountAdvance queryAccountAdvanceByAccountNo(String accountNo) {
		return accountAdvanceDao.getByAccountNo(accountNo);
	}

	@Override
	public Map<String, Object> sumMerchantData(Map<String, Object> paramMap) {
		return accountQueryBiz.sumMerchantData(paramMap);
	}

	@Override
	public PageBean queryAccountHistoryListPage(PageParam pageParam, Map<String, Object> paramMap) throws AccountBizException {
		return null;
	}

	/**
	 * 根据用户编号获取账户信息 .
	 * 
	 * @param userNo
	 *            用户编号.
	 * @return account 查询到的账户信息.
	 */
	@Override
	public Account getAccountByUserNo(String userNo) {
		if (StringUtil.isBlank(userNo)) {
			return null;
		}
		return accountDao.getByUserNo_IsPessimist(userNo, false);
	}
	
	/**
	 * 根据多个用户编号获取账户信息.
	 * @deprecated
	 * @param userNoList
	 *            多个用户编号.
	 * @return List<Account> 查询到的账户信息.
	 */
	@Override
	public List<Account> getAccountByUserNoList(List<String> userNoList){
		if (userNoList==null || userNoList.isEmpty()) {
			return null;
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userNoList", userNoList);
		return accountDao.listBy(param);
	}

	/**
	 * 根据多个用户编号获取账户信息.
	 *
	 * @param userNoList
	 *            多个用户编号.
	 * @return List<Account> 查询到的账户信息.
	 */
	@Override
	public Map<String, Account> listAccountByUserNoList(List<String> userNoList){
		if (userNoList==null || userNoList.isEmpty()) {
			return new HashMap<>();
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userNoList", userNoList);
		return accountDao.mapBy(param, "userNo");
	}

	/**
	 * 根据账户编号查询账户信息.
	 * 
	 * @param accountNo
	 *            账户编号.
	 * @return account 查询到的账户信息.
	 */
	@Override
	public Account getAccountByAccountNo(String accountNo) {
		return accountDao.getByAccountNo(accountNo);
	}

	@Override
	public AccountAdvance getAccountAdvanceByUserNo(String userNo) {
		
		return accountQueryBiz.getAccountAdvanceByUserNo(userNo);
	}
	
}
