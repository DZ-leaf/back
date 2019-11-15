package leaf.controller.chat;

import leaf.model.dto.chat.ChatMessage;
import leaf.model.dto.chat.ChatRoom;
import leaf.service.chat.ChatMessageService;
import leaf.service.chat.ChatRoomService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

@CrossOrigin("origin-allowed = *")
@AllArgsConstructor
@Controller
@Transactional
@RequestMapping("/chat")
public class ChatController {

    ChatMessageService messageService;
    ChatRoomService roomService;

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
        return messageService.getUserChat(sender);
    }

    @ResponseBody
    @PostMapping("/newchatroom")
    public void makeNewChatRoom(@RequestBody ChatRoom chatRoom) {
        System.out.println(chatRoom.getChatRoomIdx());
        System.out.println(chatRoom.getChatRoomMemberNum());
        System.out.println(chatRoom.getChatRoomName());
        System.out.println(chatRoom.getChatRoomOpenDate());
        roomService.makeNewChatRoom(chatRoom);
    }

    @ResponseBody
    @GetMapping("/getRooms")
    public Map<String, Object> getChatRooms(HttpServletRequest req) {
        Object member  = req.getAttribute("memberinfo");
        System.out.println("member");
        System.out.println(member);
        Map<String, Object> map = new HashMap<>();
        map.put("message", "success");
        
        return map;
    }

}
