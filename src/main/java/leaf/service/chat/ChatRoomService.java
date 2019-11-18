package leaf.service.chat;

import leaf.model.dao.chat.ChatRoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ChatRoomService {

    ChatRoomRepository repo;

}
