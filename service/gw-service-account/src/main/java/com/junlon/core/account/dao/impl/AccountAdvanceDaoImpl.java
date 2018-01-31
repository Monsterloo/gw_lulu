/*
 * Powered By [huang.jin]
 * Since 2017 - 2017
 */

package com.junlon.core.account.dao.impl;

import com.junlon.common.base.dao.BaseDaoImpl;
import com.junlon.core.account.dao.AccountAdvanceDao;
import com.junlon.facade.account.entity.AccountAdvance;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository("accountAdvanceDao")
public class AccountAdvanceDaoImpl extends BaseDaoImpl<AccountAdvance> implements AccountAdvanceDao {

	/**
	 * 
	 * @description:        使用乐观锁机制获取垫资账户
	 * @param userNo        用户编号
	 * @param isPessimist   是否使用乐观锁机制
	 * @return              返回垫资账户
	 */
	public AccountAdvance getByUserNo_IsPessimist(String userNo, boolean isPessimist) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userNo", userNo);
		params.put("isPessimist", isPessimist);
		
		return super.getBy(params);
	}

	public AccountAdvance getByAccountNo(String accountNo){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountNo", accountNo);
		return super.getBy(params);
	}
}
