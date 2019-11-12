package leaf.service.chat;

import leaf.model.dto.chat.ChatMessage;

import java.util.List;

public interface ChatService {

    List<ChatMessage> getUserChat(String user);

}
