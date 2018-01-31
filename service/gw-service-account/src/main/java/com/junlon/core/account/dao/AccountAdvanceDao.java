/*
 * Powered By [huang.jin]
 * Since 2017 - 2017
 */

package com.junlon.core.account.dao;

import com.junlon.common.base.dao.BaseDao;
import com.junlon.facade.account.entity.AccountAdvance;

public interface AccountAdvanceDao extends BaseDao<AccountAdvance> {
	
	/**
	 * 
	 * @description:        使用乐观锁机制获取垫资账户
	 * @param userNo        用户编号
	 * @param isPessimist   是否使用乐观锁机制
	 * @return              返回垫资账户
	 *
	 */
	public AccountAdvance getByUserNo_IsPessimist(String userNo, boolean isPessimist);

	public AccountAdvance getByAccountNo(String accountNo);
}
