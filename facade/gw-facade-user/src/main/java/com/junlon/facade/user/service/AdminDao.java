package com.junlon.facade.user.service;

import com.junlon.facade.user.entity.Admin;

import java.util.List;
import java.util.Map;

/**
 * @Author: LuJunLang
 * @Description:
 * @Date: 2017/12/4
 */
public interface AdminDao {

    public List<Admin> list(Map<String, Object> params);
}
