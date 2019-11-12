package leaf.model.dao.chat;

import leaf.model.dto.chat.ChatRoom;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {

    ChatRoom insert(ChatRoom chatRoom);

}
