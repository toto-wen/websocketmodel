package com.wetsocket.config;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

import java.util.Map;

/**
 * Created by PC-007 on 2019/11/16.
 */
//@Component
public class STOMPConnectedEventListener implements ApplicationListener<SessionConnectedEvent> {
    @Override
    public void onApplicationEvent(SessionConnectedEvent sessionConnectedEvent) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(sessionConnectedEvent.getMessage());

        String login = accessor.getLogin();
        String message = accessor.getMessage();
        String messageId = accessor.getMessageId();
        String ack = accessor.getAck();
        String sessionId = accessor.getSessionId();
        Map<String, Object> stringObjectMap = accessor.getSessionAttributes();
        // 判断客户端连接状态
        switch (accessor.getCommand()){
            case CONNECT:
                System.out.println("上线");
                System.out.println("login:"+login);
                System.out.println("message:"+message);
                System.out.println("messageId:"+messageId);
                System.out.println("ack:"+ack);
                System.out.println("sessionId:"+sessionId);

                break;
            case DISCONNECT:
                System.out.println("下线");
                break;
            case SUBSCRIBE:
                System.out.println("订阅");
                break;
            case SEND:
                System.out.println("发送");
                break;
            case UNSUBSCRIBE:
                System.out.println("取消订阅");
                break;
            case ERROR:
                System.out.println("发生错误");
                break;
            case MESSAGE:
                System.out.println("信息");
                break;
            default:
                System.out.println("其他");
                break;
        }
    }
}
