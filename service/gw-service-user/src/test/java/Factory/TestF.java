package Factory;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.facade.user.SpringJunitSupport;

/**
 * @Author: LuJunLang
 * @Description:
 * @Date: 2018/1/8
 */

public class TestF extends SpringJunitSupport{

    @Test
    public void testFactory(){
        TestFactory testFactory = new TestFactory();
        testFactory.setOneService(new OneService());
        testFactory.setTwoService(new TwoService());
        CommonService cs = testFactory.tryWay(2);
        cs.test();
    }
}
