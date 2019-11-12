package leaf.model.dto.chat;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
@Document(collection = "chatmessage")
public class ChatMessage {

    @Id
    private String sender;
    private MessageType type;
    private String content;
    private LocalDateTime sendTime;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE,
        TYPING
    }

}
