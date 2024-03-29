package leaf.component.websocket;

import leaf.model.dto.chat.ChatMessage;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Component
public class WebSocketEventListener {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

    private SimpMessageSendingOperations messagingTemplate;

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {

    }

    
    
    

    @EventListener
    public void handleWebSocketConnectListener(SessionDisconnectEvent event) {
        System.out.println("disconn");
//        String username = (String) StompHeaderAccessor.wrap(event.getMessage()).getSessionAttributes().get("username");
        // Map<String, Object> username = (HashMap<String, Object>) StompHeaderAccessor.wrap(event.getMessage()).getSessionAttributes().get("username");

        // if (username != null) {
        //     logger.info("User Disconnected : " + username);

        //     ChatMessage chatMessage = new ChatMessage();
        //     chatMessage.setName(username);

            // messagingTemplate.convertAndSend("/chat/public");
        // }
    }

}
