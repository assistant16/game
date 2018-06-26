package Game.cfg;

import Game.WebSocket.GameWebSocketHandler;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.handler.PerConnectionWebSocketHandler;


@Configuration
@EnableWebSocket
@EnableAutoConfiguration
public class WebSocketConfiguration implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler(), "/app").withSockJS();
    }
    @Bean
    public WebSocketHandler webSocketHandler() {
        return new PerConnectionWebSocketHandler(GameWebSocketHandler.class);
    }

}
