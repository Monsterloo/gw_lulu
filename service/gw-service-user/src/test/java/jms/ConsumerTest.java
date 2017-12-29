package jms;

import com.junlon.app.notify.message.UserMessageListener;
import com.junlon.common.base.utils.date.DateUtils;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Ignore;

import javax.jms.*;
import java.util.Date;

/**
 * @Author: LuJunLang
 * @Description:
 * @Date: 2017/12/21
 */

public class ConsumerTest {
    private static final String USERNAME = "admin";

    private static final String PASSWORD = "admin";

    private static final String BROKENURL = "tcp://localhost:61616";

    private static final Integer MESSAGENUM = 10000;

    @Ignore
    public static void main(String[] args) {
        UserMessageListener userMessageListener = new UserMessageListener();

        synchronized (ConsumerTest.class) {
            while (true) {
                try {
                    ConsumerTest.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        /*ConnectionFactory connectionFactory;
        Connection connection = null;

        Session session;
        Destination destination;

        MessageConsumer messageConsumer;

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

            messageConsumer = session.createConsumer(destination);
                messageConsumer.setMessageListener(new MessageListener() {
                    @Override
                    public void onMessage(Message msg) {
                        if(msg != null){
                            try {
                                TextMessage textMessage = (TextMessage)msg;
                                String date = DateUtils.formatDate(new Date(textMessage.getJMSTimestamp()));
                                System.out.println(date+"  Consumer receives the message : "+textMessage);
                            } catch (JMSException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            *//*while (true){
                TextMessage textMessage = (TextMessage) messageConsumer.receive(1000);
                if(textMessage != null){
                    System.out.println("Consumer receives the message : "+textMessage);
                }else{
                    break;
                }
            }*//*
            // 休眠100ms再关闭
            Thread.sleep(100 * 100);

            // 提交会话
            session.commit();
        }catch(Exception e){


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
