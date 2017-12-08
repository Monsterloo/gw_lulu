package spring;

import com.junlon.core.user.biz.AdminQueryBiz;
import com.junlon.facade.user.entity.Admin;
import com.junlon.facade.user.service.AdminQueryFacade;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: LuJunLang
 * @Description:
 * @Date: 2017/12/7
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-context.xml")
public class SpringTest {

    @Autowired
    private AdminQueryFacade adminQueryFacade;

    @Ignore
    @Test
    public void testQueryFacade(){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("state", 1);
        List<Admin> list = adminQueryFacade.list(params);
        System.out.println(list);
    }
}
