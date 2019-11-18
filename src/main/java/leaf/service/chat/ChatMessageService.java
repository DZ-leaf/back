package leaf.service.chat;

import leaf.model.dao.chat.ChatMessageRepository;
import leaf.model.dto.chat.ChatMessage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ChatMessageService {

    ChatMessageRepository repo;

}
