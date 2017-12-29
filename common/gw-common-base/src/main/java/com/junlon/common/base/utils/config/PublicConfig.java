package com.junlon.common.base.utils.config;

import com.junlon.common.base.utils.ResourceUtils;

import java.util.Map;

/**
 * @Author: LuJunLang
 * @Description: 环境基础配置类
 * @Date: 2017/12/26
 */

public class PublicConfig {

    /**
     * 系统文件配置 加载
     */
    public static final Map<String, String> PUBLIC_SYSTEM = ResourceUtils.getResource("public_system").getMap();

    /**
     * 通知URL
     */
    public static final String NOTIFY_RECEIVE_URL = PUBLIC_SYSTEM.get("NOTIFY_RECEIVE_URL");
}
