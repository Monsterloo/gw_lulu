package jms;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.junlon.app.notify.message.UserMessageListener;
import com.junlon.facade.user.entity.Admin;
import com.junlon.facade.user.service.AdminQueryFacade;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import test.facade.user.DubboProvider;
import test.facade.user.SpringJunitSupport;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: LuJunLang
 * @Description:
 * @Date: 2017/12/22
 */

public class MQSpringTest extends SpringJunitSupport{

    private static final Integer MESSAGENUM = 10000;

    @Autowired
    private JmsTemplate notifyJmsTemplate;

    @Autowired
    private AdminQueryFacade adminQueryFacade;

    @Test
    @Ignore
    public void publishTestQueueNotify(){
        /*String message = "Producer sends message ";
        try{
            for(int i = 0;i < MESSAGENUM; i++){
                System.out.println("Sending........"+i);
                int finalI = i;
                notifyJmsTemplate.send(new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        return session.createTextMessage(message+ finalI);
                    }
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }*/
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("state", 1);
        List<Admin> list = adminQueryFacade.list(params);
        System.out.println(list);
        String listJsonStr = JSON.toJSONString(list);
        notifyJmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                System.out.println(listJsonStr);
                return session.createTextMessage(listJsonStr);
            }
        });
    }

    @Test
    @Ignore
    public void consumeTestQueueNotify(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");

        UserMessageListener userMessageListener = (UserMessageListener)context.getBean("userMessageListener");

        context.start();

        synchronized (MQSpringTest.class) {
            while (true) {
                try {
                    MQSpringTest.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
