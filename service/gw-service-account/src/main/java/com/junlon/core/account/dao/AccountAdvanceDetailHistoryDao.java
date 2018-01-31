/*
 * Powered By [joinPay.com]
 */

package com.junlon.core.account.dao;



import com.junlon.common.base.dao.BaseDao;
import com.junlon.facade.account.entity.AccountAdvanceDetailHistory;

import java.util.List;


public interface AccountAdvanceDetailHistoryDao extends BaseDao<AccountAdvanceDetailHistory> {

    public int migrateDetailAccountDetailByIds(List<Long> idsList);

}
