package com.junlon.common.base.entity;

import com.junlon.common.base.enums.NotifyStatusEnum;

import java.util.Date;

/**
 * @Author: LuJunLang
 * @Description: 通知记录实体
 * @Date: 2017/12/27
 */

public class NotifyRecord {

    /**
     * 通知次数
     */
    private Integer notifyTimes = 0;

    /**
     * 限制通知次数
     */
    private Integer limitNotifyTimes =5;

    /**
     * 通知url
     */
    private String url;

    /**
     * 请求参数
     */
    private String param;

    /**
     * 通知状态
     */
    private Integer status = NotifyStatusEnum.CREATED.getValue();

    /**
     * 创建日期
     */
    private Date createTime;

    public Integer getNotifyTimes() {
        return notifyTimes;
    }

    public void setNotifyTimes(Integer notifyTimes) {
        this.notifyTimes = notifyTimes;
    }

    public Integer getLimitNotifyTimes() {
        return limitNotifyTimes;
    }

    public void setLimitNotifyTimes(Integer limitNotifyTimes) {
        this.limitNotifyTimes = limitNotifyTimes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
