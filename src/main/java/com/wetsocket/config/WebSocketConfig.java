package com.wetsocket.config;

import com.wetsocket.interceptor.MyChannelInterceptorAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Created by PC-007 on 2019/11/13.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 注册一个stomp的节点，并指定使用sockJS协议
        registry.addEndpoint("/register/server").setAllowedOrigins("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 启动心跳机制
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(1);
        taskScheduler.setThreadNamePrefix("wss-heartbeat-thread-");
        taskScheduler.initialize();
        // 服务器端发送消息给客户端的与，多个用逗号隔开
        registry.enableSimpleBroker("/topic", "/user").setHeartbeatValue(new long[]{5000l, 5000l}).setTaskScheduler(taskScheduler);
        // 定义1对1推送的时候的前缀
        registry.setUserDestinationPrefix("/user");
        // 定义websocket前缀
        registry.setApplicationDestinationPrefixes("/app");
    }

    public void configureClientOutboundChannel(ChannelRegistration registration) {
        registration.interceptors(new MyChannelInterceptorAdapter());
    }

}
