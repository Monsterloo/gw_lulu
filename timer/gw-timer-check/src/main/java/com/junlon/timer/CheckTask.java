package com.junlon.timer;

import com.junlon.timer.Biz.CheckTimerBiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: LuJunLang
 * @Description: 检查定时任务中心
 * @Date: 2018/1/11
 */

public class CheckTask {

    private static final Logger log = LoggerFactory.getLogger(CheckTask.class);

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        try{
            final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring/spring-context.xml"});

            context.start();
            log.info("=======>"+Thread.currentThread().getStackTrace()[1].getClassName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName()+"  begin=======<");
            CheckTimerBiz checkTimerBiz = (CheckTimerBiz) context.getBean("checkTimerBiz");
            checkTimerBiz.checkBiz();
            log.info("=======>"+Thread.currentThread().getStackTrace()[1].getClassName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName()+"  end=======<");
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
