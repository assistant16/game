package Game.WebSocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class GameWebSocketHandler extends TextWebSocketHandler {

    @Autowired
    Sessions sessions;



    public GameWebSocketHandler() {
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.addSession(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message)
            throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status)
            throws Exception {
        sessions.removeSession(session);
    }
}