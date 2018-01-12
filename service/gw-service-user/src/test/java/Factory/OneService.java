package Factory;

import org.springframework.stereotype.Component;

/**
 * @Author: LuJunLang
 * @Description:
 * @Date: 2018/1/8
 */

@Component("oneService")
public class OneService implements CommonService{
    @Override
    public void test() {
        System.out.println("oneService working...");
    }
}
