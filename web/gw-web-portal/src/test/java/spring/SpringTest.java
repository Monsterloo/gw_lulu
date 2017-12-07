package spring;

import com.junlon.facade.user.entity.Admin;
import com.junlon.facade.user.service.AdminQueryFacade;
import com.junlon.web.portal.base.BaseController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-context.xml")
public class SpringTest {

	@Autowired
	private AdminQueryFacade adminQueryFacade;

	public static void main(String[] args) {
		/*ApplicationContext ctx = new ClassPathXmlApplicationContext("com/sp/config/spring-common.xml");
		 Object adminDao = ctx.getBean("adminDao");
		 System.out.println(adminDao);*/
		Date date = new Date();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//String s = "Fri Sep 08 10:29:36 CST 2017";
		System.out.println(sdf.format(date));
		long time = 1505836800000l;
		date = new Date(time);
		System.out.println(sdf.format(date));
	}

	@Test
	public void test(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-context.xml");
		BaseController baseController = (BaseController) ctx.getBean("baseController");
		baseController.setPageNum(1);
		System.out.println(baseController.getPageNum());
	}

	@Test
	public void testMybatis(){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("state", 1);
		List<Admin> list = adminQueryFacade.list(paramMap);
		System.out.println(list);
	}
}
