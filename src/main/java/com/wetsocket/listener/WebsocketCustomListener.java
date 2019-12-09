package com.wetsocket.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.*;

/**
 * Created by PC-007 on 2019/11/19.
 */
@Component
@Slf4j
public class WebsocketCustomListener {

    @EventListener
    public void handleConnectListener(SessionConnectEvent sessionConnectEvent){
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(sessionConnectEvent.getMessage());
        log.info("connect: command={}, message={}, sessionId={}", accessor.getCommand(), accessor.getMessage(), accessor.getSessionId());
    }

    @EventListener
    public void handleDisconnectListener(SessionDisconnectEvent sessionDisconnectEvent){
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(sessionDisconnectEvent.getMessage());
        log.info("disconnect: command={}, message={}, sessionId={}", accessor.getCommand(), accessor.getMessage(), accessor.getSessionId());
    }

    @EventListener
    public void handleSubscribeListener(SessionSubscribeEvent sessionSubscribeEvent){
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(sessionSubscribeEvent.getMessage());
        log.info("subscribe: command={}, message={}, sessionId={}", accessor.getCommand(), accessor.getMessage(), accessor.getSessionId());
    }

    @EventListener
    public void handleUnsubscribeListener(SessionUnsubscribeEvent sessionUnsubscribeEvent){
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(sessionUnsubscribeEvent.getMessage());
        log.info("unSubscribe: command={}, message={}, sessionId={}", accessor.getCommand(), accessor.getMessage(), accessor.getSessionId());
    }

//    @EventListener
//    public void handleMessageListener(SessionUnsubscribeEvent sessionUnsubscribeEvent){
//        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(sessionUnsubscribeEvent.getMessage());
//        log.info("unSubscribe: command={}, message={}, sessionId={}", accessor.getCommand(), accessor.getMessage(), accessor.getSessionId());
//    }

}
