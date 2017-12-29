package com.junlon.app.notify.message;

import com.junlon.common.base.utils.date.DateUtils;
import org.apache.activemq.command.ActiveMQMessage;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.Date;

/**
 * @Author: LuJunLang
 * @Description: 用户通知队列监听器
 *  目前对于消息而言最担心的问题有两个：消息丢失(包括：生产者发送失败、中间件丢失、消费者接收后处理失败)、消息重复
 * 1.消息丢失：
 * 		1.1 对于生产者发送失败的情况，由生产者去保证，简单点的做法可以是生产者在同一事务里面在发送消息前先保存到数据库
 * 		1.2 中间件丢失，ActiveMQ是保证消息不丢失的
 * 		1.3 消费者接收后处理失败，接收到消息之后先保存到数据库，然后再进行消息的业务逻辑处理
 *
 * 2.消息重复：
 * 		2.1 生产者重复发送，由生产者自己负责
 * 		2.2 消费者重复接受和处理，保存到数据库的消息有唯一键约束，可以保证不会重复处理相同的消息
 * @Date: 2017/12/26
 */

public class UserMessageListener implements SessionAwareMessageListener{

    private static final Logger log = LoggerFactory.getLogger(UserMessageListener.class);

    @Override
    public void onMessage(Message message, Session session) throws JMSException {
        System.out.println("----------------------------------------------------");
        System.out.println("UserMessageListener is Listening.Handl");
        try{
            ActiveMQTextMessage msg = (ActiveMQTextMessage) message;
            final String ms = msg.getText();
            String date = DateUtils.formatDate(new Date(msg.getJMSTimestamp()));
            System.out.println(date+"  Consumer receives the message : "+ms);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
