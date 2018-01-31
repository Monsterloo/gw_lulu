/*
 * Powered By [joinPay.com]
 */

package com.junlon.core.account.dao.impl;


import com.junlon.common.base.dao.BaseDaoImpl;
import com.junlon.core.account.dao.AccountAdvanceDetailHistoryDao;
import com.junlon.facade.account.entity.AccountAdvanceDetailHistory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("accountAdvanceDetailHistoryDao")
public class AccountAdvanceDetailHistoryDaoImpl extends BaseDaoImpl<AccountAdvanceDetailHistory> implements AccountAdvanceDetailHistoryDao {

    @Override
    public int migrateDetailAccountDetailByIds(List<Long> idsList) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("idsList", idsList);
        return super.getSessionTemplate().insert(super.getStatement("migrateDetailAccountDetailByIds"), param);
    }

}
