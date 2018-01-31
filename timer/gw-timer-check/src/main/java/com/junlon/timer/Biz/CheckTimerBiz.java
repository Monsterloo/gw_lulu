package com.junlon.timer.Biz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: LuJunLang
 * @Description: 定时作业
 * @Date: 2018/1/11
 */
@Component("checkTimerBiz")
public class CheckTimerBiz {

    private static final Logger log = LoggerFactory.getLogger(CheckTimerBiz.class);

    public void checkBiz(){
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = sdf.format(now);
        log.info("=========>" + Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName()+"<=========");
        log.info("Time is : "+timeStr);
        System.out.println("Time : "+timeStr);
    }
}
