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
        config.enableSimpleBroker("/topic");   //the messages whose destination starts with “/app” should be routed to message-handling methods
        config.setApplicationDestinationPrefixes("/app");  //that the messages whose destination starts with “/topic” should be routed to the message broker
    }

    public void registerStompEndpoints(StompEndpointRegistry registry){  //we register a websocket endpoint that the clients will use to connect to our websocket server.
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }
}
