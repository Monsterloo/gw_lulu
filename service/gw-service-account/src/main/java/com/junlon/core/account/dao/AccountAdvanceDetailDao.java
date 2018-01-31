package com.junlon.core.account.dao;


import com.junlon.common.base.dao.BaseDao;
import com.junlon.facade.account.entity.AccountAdvanceDetail;
import com.junlon.facade.account.vo.AccountMigrationVo;

import java.util.List;

/**
 * 
 * @description:  垫资账户Dao接口类
 *
 */
public interface AccountAdvanceDetailDao extends BaseDao<AccountAdvanceDetail> {

    public List<String> calNeedMigrationDates(String migrateDate);

    public AccountMigrationVo getDetailMigrationVoByDate(String migrationDate);

    List<Long> queryNeedMigrationIdsList(AccountMigrationVo migrationVo);

    public int deleteDetailByIdsList(List<Long> idsList);

}
