package com.junlon.facade.user.entity;

import com.junlon.common.base.entity.BaseEntity;

/**
 * @Author: LuJunLang
 * @Description:
 * @Date: 2017/12/29
 */

public class role extends BaseEntity {

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 用户编号
     */
    private String userNo;

    /**
     * 备注
     */
    private String remark;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
