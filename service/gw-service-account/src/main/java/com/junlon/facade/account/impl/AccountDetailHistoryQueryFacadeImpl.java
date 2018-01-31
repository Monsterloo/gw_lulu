package com.junlon.facade.account.impl;

import com.junlon.common.base.page.PageBean;
import com.junlon.common.base.page.PageParam;
import com.junlon.core.account.biz.AccountDetailHistoryQueryBiz;
import com.junlon.facade.account.service.AccountDetailHistoryQueryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: LuJunLang
 * @Description:
 * @Date: 2018/1/3
 */

@Component("accountDetailHistoryQueryFacade")
public class AccountDetailHistoryQueryFacadeImpl implements AccountDetailHistoryQueryFacade {

    @Autowired
    private AccountDetailHistoryQueryBiz accountDetailHistoryQueryBiz;

    /**
     * 账务明细历史记录查询
     * @param pageParam
     * @param paramMap
     */
    @Override
    public PageBean queryAccountDetailHistoryListPage(PageParam pageParam, Map<String, Object> paramMap) {
        return accountDetailHistoryQueryBiz.queryAccountDetailHistoryListPage(pageParam, paramMap);
    }

    /**
     * 垫资账务明细历史记录查询
     * @param pageParam
     * @param paramMap
     */
    @Override
    public PageBean queryAccountAdvanceDetailHistoryListPage(PageParam pageParam, Map<String, Object> paramMap) {
        return accountDetailHistoryQueryBiz.queryAccountAdvanceDetailHistoryListPage(pageParam, paramMap);
    }
}
