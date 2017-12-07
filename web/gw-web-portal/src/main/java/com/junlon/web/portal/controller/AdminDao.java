package com.junlon.web.portal.controller;

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
