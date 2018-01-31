package com.junlon.facade.account.impl;

import com.junlon.core.account.biz.AccountMigrationBiz;
import com.junlon.facade.account.enums.AccountMigrationTypeEnum;
import com.junlon.facade.account.service.AccountMigrationFacade;
import com.junlon.facade.account.vo.AccountMigrationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @Author: chenyf、LuJunLang
 * @Date: 2018/1/2
 * @Description:
 */
@Component("accountMigrationFacade")
public class AccountMigrationFacadeImpl implements AccountMigrationFacade {

    @Autowired
    AccountMigrationBiz accountMigrationBiz;

    @Override
    public List<String> calNeedMigrationDates(String migrateDate, AccountMigrationTypeEnum migrationType) {
        return accountMigrationBiz.calNeedMigrationDates(migrateDate, migrationType);
    }

    @Override
    public AccountMigrationVo getDetailMigrationVoByDate(String migrationDate, AccountMigrationTypeEnum migrationType) {
        return accountMigrationBiz.getDetailMigrationVoByDate(migrationDate, migrationType);
    }

    @Override
    public int doDetailMigration(AccountMigrationVo migrationVo) {
        return accountMigrationBiz.doDetailMigration(migrationVo);
    }
}
