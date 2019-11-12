package leaf.service.chat;

import leaf.model.dao.chat.ChatRoomRepository;
import leaf.model.dto.chat.ChatRoom;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ChatRoomService {

    ChatRoomRepository repo;

    public ChatRoom makeNewChatRoom(ChatRoom chatRoom) {
        return repo.insert(chatRoom);
    }

}
