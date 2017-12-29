package com.junlon.facade.user.entity;

import com.junlon.common.base.entity.BaseEntity;

import java.util.Date;

/**
 * @Author: LuJunLang
 * @Description:
 * @Date: 2017/12/28
 */

public class User extends BaseEntity {

    /**
     * 用户编号
     */
    private String userNo;

    /**
     * 商户状态
     */
    private Integer status;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 登录密码
     */
    private String loginPwd;

    /**
     * 登录错误次数
     */
    private Integer pwdErrorTimes;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public Integer getPwdErrorTimes() {
        return pwdErrorTimes;
    }

    public void setPwdErrorTimes(Integer pwdErrorTimes) {
        this.pwdErrorTimes = pwdErrorTimes;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
