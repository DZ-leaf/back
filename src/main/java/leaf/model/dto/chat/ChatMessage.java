package leaf.model.dto.chat;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
@Document(collection = "chatmessage")
public class ChatMessage {

    @Id
    private Long id;
    private Long roomIdx;
    private String roomName;
    private Map<String, Object> name;
    private String text;
    private LocalDateTime createdAt;

}
