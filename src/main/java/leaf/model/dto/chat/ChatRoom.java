package leaf.model.dto.chat;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "chatroom")
public class ChatRoom {

    @Id
    @GeneratedValue
    @Column(name = "chatroom_cd")
    private long chatRoomIdx;

    @Column(name = "chatroom_nm")
    private String chatRoomName;

    @Column(name = "chatroom_member_nm")
    private String chatRoomMemberNum;

    @Column(name = "chatroom_open_dt")
    private LocalDateTime chatRoomOpenDate;

}
