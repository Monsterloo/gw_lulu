package com.junlon.facade.account.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: chenyf
 * @Date: 2018/1/2
 * @Description:
 */
public class AccountMigrationVo implements Serializable {
    private static final long serialVersionUID = -1636546564645311315L;

    /**
     * 账户明细类型
     * @see com.junlon.facade.account.enums.AccountMigrationTypeEnum
     */
    private int detailType;

    /**
     * 需要被迁移的日期
     */
    private Date migrationDate;

    /**
     * 当前日期内被迁移数据的最小id
     */
    private Long minId = 0L;

    /**
     * 当前日期内被迁移数据的最大id
     */
    private Long maxId = 0L;

    /**
     * 预计需要迁移的记录数
     */
    private Long preMigrationNum = 0L;

    /**
     * 当前迁移批次的最小id
     */
    private Long currentMinId = 0L;

    /**
     * 当前迁移批次的最大id
     */
    private Long currentMaxId = 0L;

    public int getDetailType() {
        return detailType;
    }

    public void setDetailType(int detailType) {
        this.detailType = detailType;
    }

    public Date getMigrationDate() {
        return migrationDate;
    }

    public void setMigrationDate(Date migrationDate) {
        this.migrationDate = migrationDate;
    }

    public Long getMinId() {
        return minId;
    }

    public void setMinId(Long minId) {
        this.minId = minId;
    }

    public Long getMaxId() {
        return maxId;
    }

    public void setMaxId(Long maxId) {
        this.maxId = maxId;
    }

    public Long getPreMigrationNum() {
        return preMigrationNum;
    }

    public void setPreMigrationNum(Long preMigrationNum) {
        this.preMigrationNum = preMigrationNum;
    }

    public Long getCurrentMinId() {
        return currentMinId;
    }

    public void setCurrentMinId(Long currentMinId) {
        this.currentMinId = currentMinId;
    }

    public Long getCurrentMaxId() {
        return currentMaxId;
    }

    public void setCurrentMaxId(Long currentMaxId) {
        this.currentMaxId = currentMaxId;
    }
}
