package com.junlon.core.account.biz;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.junlon.common.base.exceptions.AccountBizException;
import com.junlon.common.base.exceptions.BizException;
import com.junlon.common.base.utils.date.DateUtils;
import com.junlon.core.account.dao.AccountAdvanceDetailDao;
import com.junlon.core.account.dao.AccountAdvanceDetailHistoryDao;
import com.junlon.core.account.dao.AccountDetailDao;
import com.junlon.core.account.dao.AccountDetailHistoryDao;
import com.junlon.facade.account.enums.AccountMigrationTypeEnum;
import com.junlon.facade.account.vo.AccountMigrationVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: chenyf、LuJunLang
 * @Date: 2018/1/2
 * @Description: 账户明细数据迁移Biz
 */
@Component("accountMigrationBiz")
public class AccountMigrationBiz {
    private final static Logger log = LoggerFactory.getLogger(AccountMigrationBiz.class);

    @Autowired
    AccountDetailDao accountDetailDao;
    @Autowired
    AccountAdvanceDetailDao accountAdvanceDetailDao;
    @Autowired
    AccountDetailHistoryDao accountDetailHistoryDao;
    @Autowired
    AccountAdvanceDetailHistoryDao accountAdvanceDetailHistoryDao;

    /**
     * 查询出需要迁移数据的日期集合
     * @param migrateDate
     * @param migrationType
     * @return
     */
    public List<String> calNeedMigrationDates(String migrateDate, AccountMigrationTypeEnum migrationType){
        log.info("===>calNeedMigrationDates_migrateDate = {} migrationType = {}<===", migrateDate, migrationType);
        if(migrateDate == null){
            throw BizException.NULL_PARAM_ERROR;
        }
        List<String> datesList = null;
        if(migrationType == AccountMigrationTypeEnum.MAIN_ACCOUNT_DETAIL){
            datesList = accountDetailDao.calNeedMigrationDates(migrateDate);
        }else if(migrationType == AccountMigrationTypeEnum.ADVANCE_ACCOUNT_DETAIL){
            datesList = accountAdvanceDetailDao.calNeedMigrationDates(migrateDate);
        }else{
            datesList = new ArrayList<>();
        }
        log.info("===>calNeedMigrationDates_datesList = {}", Arrays.asList(datesList));
        return datesList;
    }

    /**
     * 根据交易日期查询出迁移Vo的信息
     * @param migrationDate
     * @param migrationType
     * @return
     */
    public AccountMigrationVo getDetailMigrationVoByDate(String migrationDate, AccountMigrationTypeEnum migrationType){
        log.info("===>getMigrationVoByDate_migrationDate = {} migrationType = {}<===", migrationDate, migrationType);
        if(migrationDate == null){
            throw AccountBizException.NULL_PARAM_ERROR;
        }
        AccountMigrationVo accountMigrationVo = null;
        if(migrationType == AccountMigrationTypeEnum.MAIN_ACCOUNT_DETAIL){
            accountMigrationVo = accountDetailDao.getDetailMigrationVoByDate(migrationDate);
            accountMigrationVo.setDetailType(AccountMigrationTypeEnum.MAIN_ACCOUNT_DETAIL.getValue());
        }else if(migrationType == AccountMigrationTypeEnum.ADVANCE_ACCOUNT_DETAIL){
            accountMigrationVo = accountAdvanceDetailDao.getDetailMigrationVoByDate(migrationDate);
            accountMigrationVo.setDetailType(AccountMigrationTypeEnum.ADVANCE_ACCOUNT_DETAIL.getValue());
        }else{
            accountMigrationVo = new AccountMigrationVo();
        }
        this.fillAccountMigrationVoIfNullValue(accountMigrationVo);
        log.info("getDetailMigrationVoByDate_accountMigrationVo = {}", JSONObject.toJSONString(accountMigrationVo, true));
        return accountMigrationVo;
    }

    /**
     * 原子数据迁移操作
     * 账户明细迁移数据到账户明细历史记录表，同时删除在账户明细表中的记录
     * @param migrationVo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int doDetailMigration(AccountMigrationVo migrationVo){
        log.info("===>doDetailMigration_migrationDate = {} migrationType = {} minId = {} maxId = {} preMigrationNum = {}<===",new Object[]{migrationVo.getMigrationDate(), migrationVo.getDetailType(), migrationVo.getMinId(), migrationVo.getMaxId(), migrationVo.getPreMigrationNum()});
        this.validateMigrationParam(migrationVo);
        List<Long> idsList = null;
        int migrateCount = 0;
        int deleteCount = 0;

        //主账户明细数据迁移
        if(migrationVo.getDetailType() == AccountMigrationTypeEnum.MAIN_ACCOUNT_DETAIL.getValue()){
            idsList = accountDetailDao.queryNeedMigrationIdsList(migrationVo);

            log.info("doDetailMigration_migrationDate={}  detailIdList.size={} 主账户明细数据迁移获取id完成", DateUtils.formatDate(migrationVo.getMigrationDate(),DateUtils.DATE_FORMAT_DATEONLY), idsList.size());
            migrateCount = accountDetailHistoryDao.migrateDetailAccountDetailByIds(idsList);
            if(migrateCount > 0){
                deleteCount = accountDetailDao.deleteDetailByIdsList(idsList);
                if(migrateCount != deleteCount){
                    log.error("doDetailMigration_error migrateCount={} and deleteCount={} not match，Transactional rollback, AccountMigrationVo={}", new Object[]{migrateCount, deleteCount, JSON.toJSONString(migrationVo, true)});
                    throw AccountBizException.MIGRATION_COUNT_NOT_EQUAL;
                }else{
                    log.info("deleteDetailByIdsList_deleteCount={} detailIdList.size={} 主账户明细数据迁移删除id完成");
                }
            }
        //垫资账户明细数据迁移
        }else if(migrationVo.getDetailType() == AccountMigrationTypeEnum.ADVANCE_ACCOUNT_DETAIL.getValue()){
            idsList = accountAdvanceDetailDao.queryNeedMigrationIdsList(migrationVo);
            log.info("doDetailMigration_migrationDate={}  detailIdList.size={} 垫资账户明细迁移获取id完成", DateUtils.dateFormat(migrationVo.getMigrationDate()), idsList.size());
            migrateCount = accountAdvanceDetailHistoryDao.migrateDetailAccountDetailByIds(idsList);
            if(migrateCount > 0){
                deleteCount = accountAdvanceDetailDao.deleteDetailByIdsList(idsList);
                if(migrateCount != deleteCount){
                    log.error("doDetailMigration_error migrateCount={} and deleteCount={} not match，Transactional rollback, AccountMigrationVo={}", new Object[]{migrateCount, deleteCount, JSON.toJSONString(migrationVo, true)});
                    throw AccountBizException.MIGRATION_COUNT_NOT_EQUAL;
                }else{
                    log.info("deleteDetailByIdsList_deleteCount={} detailIdList.size={} 垫资账户明细数据迁移删除id完成");
                }
            }
        }
        return migrateCount;
    }

    /**
     * 填充AccountMigrationVo的空值为0
     * @param accountMigrationVo
     */
    public void fillAccountMigrationVoIfNullValue(AccountMigrationVo accountMigrationVo){
        if(accountMigrationVo.getMinId() == null){
            accountMigrationVo.setMinId(0L);
        }
        if(accountMigrationVo.getMaxId() == null){
            accountMigrationVo.setMaxId(0L);
        }
        if(accountMigrationVo.getPreMigrationNum() == null){
            accountMigrationVo.setPreMigrationNum(0L);
        }
        if(accountMigrationVo.getCurrentMaxId() == null){
            accountMigrationVo.setCurrentMaxId(0L);
        }
        if(accountMigrationVo.getCurrentMinId() == null){
            accountMigrationVo.setCurrentMinId(0L);
        }
    }

    /**
     * 校验migrationVo参数是否为空
     * @param migrationVo
     */
    private void validateMigrationParam(AccountMigrationVo migrationVo){
        if(migrationVo == null){
            throw AccountBizException.NULL_PARAM_ERROR;
        }else if(migrationVo.getMigrationDate() == null){
            throw AccountBizException.NULL_PARAM_ERROR;
        }else if(migrationVo.getCurrentMinId() == null){
            throw AccountBizException.NULL_PARAM_ERROR;
        }else if(migrationVo.getCurrentMaxId() == null){
            throw AccountBizException.NULL_PARAM_ERROR;
        }
    }
}
