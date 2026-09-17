package org.example.chatws.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration //configuraton 

@EnableWebSocketMessageBroker


public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override //override de la interfaz WebSocketMessageBrokerConfigurer para configurar el broker de mensajes
    //configuración para que springboot pueda manejar los mensajes de websocket

    public void configureMessageBroker(org.springframework.messaging.simp.config.MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override

    public void registerStompEndpoints(org.springframework.web.socket.config.annotation.StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
    }


}