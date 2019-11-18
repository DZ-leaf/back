package leaf.model.dao.chat;

import leaf.model.dto.chat.ChatRoom;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends  JpaRepository<ChatRoom, String> {

    List<ChatRoom> findByRoomNm(String roomNm);

}
