package leaf.controller.chat;

import leaf.model.dto.chat.ChatMessage;
import leaf.service.chat.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin("origin-allowed = *")
@AllArgsConstructor
@Controller
public class ChatController {

    ChatService service;

    @MessageMapping("/sendMessage") // "/sendMessage" 라는 API로 Mapping됨
    @SendTo("/topic/public") // "topic/public" 이라는 API를 Subscribe하고 있는 Client들에게 Broadcast
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        System.out.println("-------------------");
        System.out.println(chatMessage.getSender());
        System.out.println("===================");
        return chatMessage;
    }

    @MessageMapping("/addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        System.out.println("+++++++++++++++++++");
        System.out.println(chatMessage);
        System.out.println("-------------------");
        // Add user in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

    @ResponseBody
    @GetMapping("/userchat")
    public List<ChatMessage> getUserChat(@RequestParam String sender) {
        return service.getUserChat(sender);
    }

}
