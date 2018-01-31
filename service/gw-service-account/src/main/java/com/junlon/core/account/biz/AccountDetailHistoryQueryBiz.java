package com.junlon.core.account.biz;

import com.junlon.common.base.page.PageBean;
import com.junlon.common.base.page.PageParam;
import com.junlon.core.account.dao.AccountAdvanceDetailHistoryDao;
import com.junlon.core.account.dao.AccountDetailHistoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: LuJunLang
 * @Description: 账务历史记录查询Biz
 * @Date: 2018/1/3
 */
@Component("accountDetailHistoryQueryBiz")
public class AccountDetailHistoryQueryBiz {

    @Autowired
    private AccountDetailHistoryDao accountDetailHistoryDao;

    @Autowired
    private AccountAdvanceDetailHistoryDao accountAdvanceDetailHistoryDao;

    /**
     * 账户明细历史记录查询
     * @param pageParam
     * @param paramMap
     */
    public PageBean queryAccountDetailHistoryListPage(PageParam pageParam, Map<String, Object> paramMap) {
        return accountDetailHistoryDao.listPage(pageParam, paramMap);
    }

    /**
     * 垫资账户明细历史记录查询
     * @param pageParam
     * @param paramMap
     */
    public PageBean queryAccountAdvanceDetailHistoryListPage(PageParam pageParam, Map<String, Object> paramMap) {
        return accountAdvanceDetailHistoryDao.listPage(pageParam, paramMap);
    }
}
