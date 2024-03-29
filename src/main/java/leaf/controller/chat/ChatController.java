package leaf.controller.chat;

import leaf.model.dto.chat.ChatMessage;
import leaf.model.dto.chat.ChatRoom;
import leaf.model.dto.member.Member;
import leaf.service.chat.ChatMessageService;
import leaf.service.chat.ChatRoomService;
import leaf.service.group.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("origin-allowed = *")
@AllArgsConstructor
@Controller
@Transactional
@RequestMapping("/chat")
public class ChatController {

    GroupService groupService;
    ChatMessageService messageService;
    ChatRoomService roomService;

    @MessageMapping("/sendMessage/{chatRoomCd}") // "/sendMessage" 라는 API로 Mapping됨
    @SendTo("/chat/message/{chatRoomCd}") // "topic/public" 이라는 API를 Subscribe하고 있는 Client들에게 Broadcast
    public ChatMessage sendMessage(@DestinationVariable String chatRoomCd,
            @Payload @RequestBody ChatMessage chatMessage) {
        messageService.putMessage(chatMessage);
        return chatMessage;
    }

    @ResponseBody
    @GetMapping("/getPastMessage/{roomIdx}")
    public List<ChatMessage> getChat(@PathVariable Long roomIdx) {
        return messageService.getAllMessage(roomIdx);
    }

    @ResponseBody
    @GetMapping("/getRooms")
    public Map<String, Object> getChatRooms(HttpServletRequest req) {
        Member member = (Member) req.getAttribute("memberinfo");
        System.out.println("member");
        System.out.println(member);

        List<ChatRoom> roomList = groupService.getRoomList(member);
        System.out.println("roomList");
        System.out.println(roomList);
        Map<String, Object> map = new HashMap<>();
        map.put("message", "success");
        map.put("rooms", roomList);
        System.out.println(map);
        return map;
    }

    // Message put test
    @PutMapping("/inputmessage")
    public ChatMessage inputMessage(@RequestBody ChatMessage chatMessage) {
        messageService.putMessage(chatMessage);
        return chatMessage;
    }

    @ResponseBody
    @PostMapping("/newchatroom")
    public void makeNewChatRoom(@RequestBody ChatRoom chatRoom) {

    }

}
