/*
 * Powered By [huang.jin]
 * Since 2017 - 2017
 */

package com.junlon.core.account.dao;


import com.junlon.common.base.dao.BaseDao;
import com.junlon.facade.account.entity.AccountDetail;
import com.junlon.facade.account.vo.AccountMigrationVo;

import java.util.List;

public interface AccountDetailDao extends BaseDao<AccountDetail> {

    public List<String> calNeedMigrationDates(String calNeedMigrationDates);

    public AccountMigrationVo getDetailMigrationVoByDate(String migrationDate);

    public List<Long> queryNeedMigrationIdsList(AccountMigrationVo migrationVo);

    public int deleteDetailByIdsList(List<Long> idsList);

}