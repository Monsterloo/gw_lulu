package com.junlon.timer;

import com.junlon.facade.account.enums.AccountMigrationTypeEnum;
import com.junlon.timer.Biz.AccountMigrateBiz;
import com.junlon.timer.Biz.CheckTimerBiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: LuJunLang
 * @Description: 账户明细数据迁移任务
 * @Date: 2018/1/30
 */

public class AccountMigrateTask {

    private static final Logger log = LoggerFactory.getLogger(CheckTask.class);

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        try{
            final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring/spring-context.xml"});

            context.start();
            log.info("==========>AccountMigrateTask begin==========<");
            AccountMigrateBiz accountMigrateBiz = (AccountMigrateBiz) context.getBean("accountMigrateBiz");

            log.info("==========>开始迁移主账户明细数据==========<");
            accountMigrateBiz.migrateDetailRecords(AccountMigrationTypeEnum.MAIN_ACCOUNT_DETAIL);
            log.info("==========>结束迁移主账户明细数据==========<");


            int second = 5;
            while(second > 0){
                log.info(second-- +"秒后开始迁移垫资账户明细数据");
                Thread.sleep(1000);
            }

            log.info("==========>开始迁移垫资账户明细数据==========<");
            accountMigrateBiz.migrateDetailRecords(AccountMigrationTypeEnum.ADVANCE_ACCOUNT_DETAIL);
            log.info("==========>结束迁移垫资账户明细数据==========<");

            log.info("==========>AccountMigrateTask end==========<");
        }catch (Exception e){
            e.printStackTrace();
        }

        synchronized (CheckTask.class){
            while (true){
                try {
                    CheckTask.class.wait();
                } catch (InterruptedException e) {
                    log.error("== synchronized error:",e);
                }
            }
        }
    }
}
