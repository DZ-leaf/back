package leaf.model.dao.chat;

import leaf.model.dto.chat.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, Long> {

    List<ChatMessage> findAllByRoomIdxOrderByCreatedAtDesc(Long roomIdx);

}