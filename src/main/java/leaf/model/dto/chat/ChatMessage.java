package leaf.model.dto.chat;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
@Document(collection = "chatmessage")
public class ChatMessage {

    private Long roomIdx;
    private String roomName;
    private String name;
    private String text;
    private LocalDateTime createdAt;

}
