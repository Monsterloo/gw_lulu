package Factory;

import org.springframework.stereotype.Component;

/**
 * @Author: LuJunLang
 * @Description:
 * @Date: 2018/1/8
 */

@Component("twoService")
public class TwoService implements CommonService{
    @Override
    public void test() {
        System.out.println("twoSerivce working..");
    }
}
