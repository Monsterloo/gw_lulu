package spring;

import com.junlon.common.base.utils.date.DateUtils;
import com.junlon.core.account.biz.AccountMigrationBiz;
import com.junlon.core.account.biz.AccountQueryBiz;
import com.junlon.facade.account.enums.AccountMigrationTypeEnum;
import com.junlon.facade.account.service.AccountMigrationFacade;
import com.junlon.facade.account.vo.AccountAmountVo;
import com.junlon.facade.account.vo.AccountMigrationVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import serivce.account.impl.SpringJunitSupport;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author: LuJunLang
 * @Description:
 * @Date: 2018/1/29
 */

public class SpringTest extends SpringJunitSupport {

    @Autowired
    private AccountQueryBiz accountQueryBiz;

    @Autowired
    private AccountMigrationFacade accountMigrationFacade;

    @Autowired
    private AccountMigrationBiz accountMigrationBiz;

    @Test
    public void test(){
        AccountAmountVo formattingAccountAmountVo = accountQueryBiz.getFormattingAccountAmountVo("888000000000000", 2);
        System.out.println("账户帐号 :"+ formattingAccountAmountVo.getAccountNo());
        System.out.println("商户编号 :"+ formattingAccountAmountVo.getUserNo());
        System.out.println("账户余额 :"+ formattingAccountAmountVo.getBalance());
        System.out.println("不可用余额 :"+ formattingAccountAmountVo.getUnBalance());
        System.out.println("可结算金额 :"+ formattingAccountAmountVo.getAvailableSettAmount());
        System.out.println("最大垫资额度 :"+ formattingAccountAmountVo.getMaxAdvanceAmount());
        System.out.println("最大可用余额 :" + formattingAccountAmountVo.getMaxAvailableBalance());
    }

    @Test
    public void testDetailHistory(){
        Date date = new Date();
        System.out.println(date);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -10);
        Date newDate = cal.getTime();
        System.out.println(newDate);
        AccountMigrationVo detailMigrationVo = accountMigrationFacade.getDetailMigrationVoByDate(DateUtils.formatDate(newDate), AccountMigrationTypeEnum.MAIN_ACCOUNT_DETAIL);
        System.out.println(detailMigrationVo.getMaxId());
        System.out.println(detailMigrationVo.getMinId());
        System.out.println(detailMigrationVo.getMigrationDate());
        System.out.println(detailMigrationVo.getPreMigrationNum());
    }
}
