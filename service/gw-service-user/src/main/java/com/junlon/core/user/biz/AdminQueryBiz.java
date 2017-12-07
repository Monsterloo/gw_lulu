package com.junlon.core.user.biz;

import com.junlon.core.user.dao.AdminDao;
import com.junlon.facade.user.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author: LuJunLang
 * @Description:
 * @Date: 2017/12/7
 */

@Component("adminQueryBiz")
public class AdminQueryBiz {

    @Autowired
    private AdminDao adminDao;

    public List<Admin> list(Map<String, Object> params) {
        return adminDao.list(params);
    }
}
