/*
 * Powered By [joinPay.com]
 */

package com.junlon.core.account.dao;



import com.junlon.common.base.dao.BaseDao;
import com.junlon.facade.account.entity.AccountDetailHistory;

import java.util.List;


public interface AccountDetailHistoryDao extends BaseDao<AccountDetailHistory> {

    /**
     * 从主账户明细迁移数据到主账户明细的历史记录表
     * @param idsList
     * @return
     */
    public int migrateDetailAccountDetailByIds(List<Long> idsList);

    public List<AccountDetailHistory> listByUserNoAndRequestNo(String userNo, String requestNo);
}
