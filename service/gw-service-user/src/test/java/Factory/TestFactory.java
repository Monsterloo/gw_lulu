package Factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: LuJunLang
 * @Description:
 * @Date: 2018/1/8
 */

@Component("testFactory")
public class TestFactory {

    @Autowired
    private OneService oneService;

    @Autowired
    private TwoService twoService;

    public OneService getOneService() {
        return oneService;
    }

    public void setOneService(OneService oneService) {
        this.oneService = oneService;
    }

    public TwoService getTwoService() {
        return twoService;
    }

    public void setTwoService(TwoService twoService) {
        this.twoService = twoService;
    }

    public CommonService tryWay(Integer index){
        if(index == 1){
            return oneService;
        }else if(index ==2){
            return twoService;
        }else{
            return null;
        }
    }
}
