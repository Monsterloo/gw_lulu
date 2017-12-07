package com.junlon.facade.user.impl;

import com.junlon.core.user.biz.AdminQueryBiz;
import com.junlon.facade.user.entity.Admin;
import com.junlon.facade.user.service.AdminQueryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author: LuJunLang
 * @Description:
 * @Date: 2017/12/7
 */

@Component("adminQueryFacade")
public class AdminQueryFacadeImpl implements AdminQueryFacade{

    @Autowired
    private AdminQueryBiz adminQueryBiz;

    @Override
    public List<Admin> list(Map<String, Object> params) {
        return adminQueryBiz.list(params);
    }
}
