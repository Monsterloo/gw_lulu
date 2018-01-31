package com.junlon.timer.Biz;

import com.alibaba.fastjson.JSON;
import com.junlon.common.base.utils.date.DateUtils;
import com.junlon.facade.account.enums.AccountMigrationTypeEnum;
import com.junlon.facade.account.service.AccountMigrationFacade;
import com.junlon.facade.account.vo.AccountMigrationVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author: LuJunLang
 * @Description: 账户明细数据迁移
 * @Date: 2018/1/30
 */

@Component("accountMigrateBiz")
public class AccountMigrateBiz {

    private final static Logger log = LoggerFactory.getLogger(AccountMigrateBiz.class);

    @Autowired
    private AccountMigrationFacade accountMigrationFacade;

    private final static int DETAIL_RECORD_KEEP_DAYS = 15;

    private final static int MIGRATE_DETAIL_NUM_EACH_TIME = 1000;

    /**
     * 迁移明细数据
     */
    public void migrateDetailRecords(AccountMigrationTypeEnum migrationType){
        log.info("==========>AccountMigrationBiz.detailRecordsMigrate Begin<==========");
        String migrateDate = this.calMigrationalTargetDate();
        log.info("AccountMigrationBiz.migrateDetailRecords  migrateDate = {}", migrateDate);

        // step 1.统计出需要迁移明细数据的日期集合
        List<String> datesList = accountMigrationFacade.calNeedMigrationDates(migrateDate, migrationType);
        log.info("===>calNeedMigrationDates_datesList = {}", Arrays.asList(datesList));
        if(datesList == null || datesList.isEmpty()){
            log.info("没有检索出需要迁移的明细记录");
            return;
        }

        // step 2.遍历日期集合，统计具体迁移数据到Vo中
        long totalMigrateCount = 0;
        for(String targetDate : datesList){
            long migrateCount = 0;
            AccountMigrationVo accountMigrationVo = accountMigrationFacade.getDetailMigrationVoByDate(targetDate, migrationType);
            log.info("migrationDate={} AccountMigrationVo = {}", targetDate, JSON.toJSONString(accountMigrationVo, true));
            //判断是否继续分段迁移，设置当前最大Id，最小Id
            while(isNeedMigrate(accountMigrationVo)){
                accountMigrationVo.setCurrentMinId(accountMigrationVo.getMinId());
                accountMigrationVo.setCurrentMaxId(accountMigrationVo.getMinId() + MIGRATE_DETAIL_NUM_EACH_TIME -1);
                if(accountMigrationVo.getCurrentMaxId() > accountMigrationVo.getMaxId()){
                    accountMigrationVo.setCurrentMaxId(accountMigrationVo.getMaxId());
                }

                // step 3.开始迁移数据
                try{
                    log.info("CurrentMinId = {} CurrentMaxId = {} MigrationDate = {} start", new Object[]{accountMigrationVo.getCurrentMinId(), accountMigrationVo.getCurrentMaxId(), DateUtils.formatDate(accountMigrationVo.getMigrationDate())});
                    migrateCount = accountMigrationFacade.doDetailMigration(accountMigrationVo);
                    log.info("CurrentMinId = {} CurrentMaxId = {} migrationNum = {} end", new Object[]{accountMigrationVo.getCurrentMinId(), accountMigrationVo.getCurrentMaxId(), accountMigrationVo.getPreMigrationNum()});
                    totalMigrateCount += migrateCount;
                }catch(Exception e){
                    log.info("Exception_Happened  CurrentMinId = {} CurrentMaxId = {} , exception", accountMigrationVo.getCurrentMinId(), accountMigrationVo.getCurrentMaxId());
                    if(migrationType == AccountMigrationTypeEnum.MAIN_ACCOUNT_DETAIL){
                        log.error("主账户明细数据迁移发生异常", e);
                    }else if(migrationType == AccountMigrationTypeEnum.ADVANCE_ACCOUNT_DETAIL){
                        log.error("垫资账户明细数据迁移发生异常", e);
                    }
                }
                //最后更新minId
                accountMigrationVo.setMinId(accountMigrationVo.getCurrentMaxId() + 1);
            }
            try{
                //休眠一下，避免太过频繁的调用接口导致异常
                Thread.sleep(2000);
            }catch(Exception e){
                if(migrationType == AccountMigrationTypeEnum.MAIN_ACCOUNT_DETAIL){
                    log.error("主账户明细迁移休眠时发生异常", e);
                }else if(migrationType == AccountMigrationTypeEnum.ADVANCE_ACCOUNT_DETAIL){
                    log.error("垫资账户明细迁移休眠时发生异常",e);
                }
            }
            continue;
        }
        log.info("detailRecordsMigrate_totalMigrateCount = {}" , totalMigrateCount);
        log.info("==========>AccountMigrationBiz.detailRecordsMigrate End<==========");
    }

    /**
     * 计算出迁移点时间
     * @return
     */
    public String calMigrationalTargetDate(){
        return DateUtils.formatDate(DateUtils.addDay(new Date(), (-1) * DETAIL_RECORD_KEEP_DAYS), DateUtils.DATE_FORMAT_DATEONLY);
    }

    /**
     * 是否执行迁移操作
     * @param accountMigrationVo
     * @return
     */
    public boolean isNeedMigrate(AccountMigrationVo accountMigrationVo){
        return accountMigrationVo.getMaxId() >= accountMigrationVo.getMinId() && accountMigrationVo.getMaxId() > 0;
    }

}
