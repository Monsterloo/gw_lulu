package jms;

import com.alibaba.fastjson.JSON;
import com.junlon.facade.user.entity.Admin;
import com.junlon.facade.user.service.AdminQueryFacade;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import test.facade.user.DubboProvider;
import test.facade.user.SpringJunitSupport;

import javax.jms.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: LuJunLang
 * @Description:
 * @Date: 2017/12/21
 */

public class ProducerTest extends SpringJunitSupport{

    private static final String USERNAME = "admin";

    private static final String PASSWORD = "admin";

    private static final String BROKENURL = "tcp://localhost:61616";

    private static final Integer MESSAGENUM = 10000;

    @Autowired
    private AdminQueryFacade adminQueryFacade;

    @Autowired
    private JmsTemplate notifyJmsTemplate;

    @Test
    @Ignore
    public void publishTestQueueNotify(){
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

    public static void main(String[] args) {
        ProducerTest pt = new ProducerTest();
        pt.publishTestQueueNotify();
        /*ConnectionFactory connectionFactory;
        Connection connection = null;

        Session session;
        Destination destination;

        MessageProducer messageProducer;

        //实例工厂
        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKENURL);

        try{
            //通过连接工厂创建连接
            connection = connectionFactory.createConnection();
            //启动连接
            connection.start();
            //参数1 : 支持事务 , 参数2 : 客户端接收和发送消息都为自动确定
            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            //创建一个消息队列
            destination = session.createQueue("queue");
            //创建一个消息生产者
            messageProducer = session.createProducer(destination);
            for(int i=1;i<=MESSAGENUM;i++){
                Message message = session.createTextMessage("Producer sends message " + i);
                System.out.println("Sending...");
                messageProducer.send(message);
            }
            session.commit();
            return;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }*/
    }
}
