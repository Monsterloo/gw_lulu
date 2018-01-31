package com.junlon.core.account.dao;


import com.junlon.common.base.dao.BaseDao;
import com.junlon.facade.account.entity.Account;
import com.junlon.facade.account.vo.AccountAmountVo;

import java.util.Date;
import java.util.Map;

public interface AccountDao extends BaseDao<Account> {

	/**
	 * 获取账户相关的金额业务对象
	 * @param userNo
	 * @return
	 */
	public AccountAmountVo getAccountAmountVoByUserNo(String userNo);

	/**
	 * 生成账户编号20位
	 * 
	 * @param accountType
	 * @return
	 */
	public String buildAccountNo(String accountType);

	/**
	 * 根據帳戶編號獲取帳戶信息
	 * 
	 * @param accountNo
	 * @return
	 */
	public Account getByAccountNo(String accountNo);

	/**
	 * 获取账户实体
	 * 
	 * @param userNo
	 * @param userNo
	 * @param isPessimist
	 *            是否乐观锁
	 * @return
	 */
	public Account getByUserNo_IsPessimist(String userNo, boolean isPessimist);

	/**
	 * 修改新旧账务处理逻辑
	 * @param paramMap
	 */
	public int updateAccountNewLogic(Map<String, Object> paramMap);

	/**
	 * 交易
	 * 
	 * @param account
	 */
	public void transaction(Account account);

	/**
	 * 调整可出款金额
	 * @param id
	 * @param version
	 * @param adjustAmount
	 * @return
	 */
	public boolean adjustCanOutAmount(long id, int version, double adjustAmount);
	
	/**
	 * 调整可结算金额
	 * @param id
	 * @param version
	 * @param adjustAmount
	 * @return
	 */
	public boolean adjustAvailableSettAmount(long id, int version, double adjustAmount, Date lastTime);

}
