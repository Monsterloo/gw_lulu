package com.junlon.facade.account.service;


import com.junlon.common.base.page.PageBean;
import com.junlon.common.base.page.PageParam;

import java.util.Map;

/**
 * @Author: LuJunLang
 * @Description: 商户账务历史数据查询
 * @Date: 2018/1/3
 */
public interface AccountDetailHistoryQueryFacade {

    /**
     * 账务明细历史记录查询
     * @param pageParam
     * @param paramMap
     */
    public PageBean queryAccountDetailHistoryListPage(PageParam pageParam, Map<String, Object> paramMap);

    /**
     * 垫资账务明细历史记录查询
     * @param pageParam
     * @param paramMap
     */
    public PageBean queryAccountAdvanceDetailHistoryListPage(PageParam pageParam, Map<String, Object> paramMap);
}
