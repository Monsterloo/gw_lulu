package com.junlon.core.account.dao.impl;

import com.junlon.common.base.dao.BaseDaoImpl;
import com.junlon.core.account.dao.AccountDao;
import com.junlon.facade.account.entity.Account;
import com.junlon.facade.account.vo.AccountAmountVo;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository("accountDao")
public class AccountDaoImpl extends BaseDaoImpl<Account> implements AccountDao {

	/**
	 * 获取账户相关的金额业务对象
	 * @param userNo
	 * @return
	 */
	public AccountAmountVo getAccountAmountVoByUserNo(String userNo){
		return this.getSessionTemplate().selectOne(getStatement("getAccountAmountVoByUserNo"), userNo);
	}

	/**
	 * 生成账户编号20位
	 */
	public String buildAccountNo(String accountType) {
		// 获取账户编号序列值，用于生成20位的账户编号
		String accountNoSeq = super.getSeqNextValue("ACCOUNT_NO_SEQ");
		// 构造账户编号
		String accountNo = "8008" + accountType + accountNoSeq + "0101";

		return accountNo;
	}

	/**
	 * 根據帳戶編號獲取帳戶信息
	 * 
	 * @param accountNo
	 * @return
	 */
	public Account getByAccountNo(String accountNo) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountNo", accountNo);
		return super.getBy(params);
	}

	/**
	 * 获取账户实体
	 * 
	 * @param userNo
	 * @param isPessimist
	 *            是否乐观锁
	 * @return
	 */
	public Account getByUserNo_IsPessimist(String userNo, boolean isPessimist) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userNo", userNo);
		params.put("isPessimist", isPessimist);
		return super.getBy(params);
	}

	/**
	 * 修改新旧账务处理逻辑
	 * @param paramMap
	 * @return
	 */
	public int updateAccountNewLogic(Map<String, Object> paramMap){
		paramMap.put("lastTime", new Date());
		return this.getSqlSession().update("updateAccountNewLogic", paramMap);
	}

	/**
	 * 交易
	 * 
	 * @param account
	 */
	public void transaction(Account account) {
		super.getSessionTemplate().update(getStatement("transaction"), account);
	}

	public boolean adjustCanOutAmount(long id, int version, double adjustAmount){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("version", version);
		params.put("adjustAmount", adjustAmount);
		return this.getSqlSession().update("adjustCanOutAmount", params) > 0;
	}
	
	public boolean adjustAvailableSettAmount(long id, int version, double adjustAmount,Date lastTime){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("version", version);
		params.put("adjustAmount", adjustAmount);
		params.put("lastTime", lastTime);
		return this.getSqlSession().update("adjustAvailableSettAmount", params) > 0;
	}

}
