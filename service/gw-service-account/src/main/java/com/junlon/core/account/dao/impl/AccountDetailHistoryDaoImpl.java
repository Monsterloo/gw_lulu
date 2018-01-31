/*
 * Powered By [joinPay.com]
 */

package com.junlon.core.account.dao.impl;

import com.junlon.common.base.dao.BaseDaoImpl;
import com.junlon.core.account.dao.AccountDetailHistoryDao;
import com.junlon.facade.account.entity.AccountDetailHistory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("accountDetailHistoryDao")
public class AccountDetailHistoryDaoImpl extends BaseDaoImpl<AccountDetailHistory> implements AccountDetailHistoryDao {

    @Override
    public int migrateDetailAccountDetailByIds(List<Long> idsList) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("idsList", idsList);
        return super.getSessionTemplate().insert(super.getStatement("migrateDetailAccountDetailByIds"), param);
    }

    @Override
    public List<AccountDetailHistory> listByUserNoAndRequestNo(String userNo, String requestNo){
        Map<String, Object> param = new HashMap<>(2);
        param.put("userNo", userNo);
        param.put("requestNo", requestNo);
        return this.listBy(param);
    }
}
