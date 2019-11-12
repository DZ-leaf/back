package leaf.model.dto.chat;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
@Document(collection = "chatmessage")
public class ChatMessage {

    @Id
    @Column(name = "sender")
    private String sender;

    @Column(name = "type")
    private MessageType type;

    @Column(name = "content")
    private String content;

    @Column(name = "sendtime")
    private LocalDateTime sendTime;


    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE,
        TYPING
    }

}
