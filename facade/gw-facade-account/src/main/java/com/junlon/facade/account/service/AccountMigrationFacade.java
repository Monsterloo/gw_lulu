package com.junlon.facade.account.service;

import com.junlon.facade.account.enums.AccountMigrationTypeEnum;
import com.junlon.facade.account.vo.AccountMigrationVo;

import java.util.Date;
import java.util.List;

/**
 * @author: chenyf、LuJunLang
 * @Date: 2018/1/2
 * @Description: 账户数据迁移接口
 */
public interface AccountMigrationFacade {

    public List<String> calNeedMigrationDates(String migrateDate, AccountMigrationTypeEnum migrationType);

    public AccountMigrationVo getDetailMigrationVoByDate(String migrationDate, AccountMigrationTypeEnum migrationType);

    public int doDetailMigration(AccountMigrationVo migrationVo);

}
