package Game.WebSocket;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Scope("singleton")
public class Sessions {

    private Map<String, WebSocketSession> sessions = new ConcurrentHashMap<String,WebSocketSession>();

    public Map<String, WebSocketSession> getSessions() {
        return sessions;
    }

    public void broadcast(String msg) {
        for (WebSocketSession webSocketSession : sessions.values()) {
            try {
                webSocketSession.sendMessage(new TextMessage(msg));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addSession(WebSocketSession session) {
        getSessions().put(session.getId(),session);

    }

    public void removeSession(WebSocketSession session) {
        getSessions().remove(session.getId());

    }
}
