package Game.cfg;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {
    public void configureMessageBroker(MessageBrokerRegistry config){
        config.enableSimpleBroker("/api");
        config.setApplicationDestinationPrefixes("app");
    }

    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("/api-api").withSockJS();
    }
}