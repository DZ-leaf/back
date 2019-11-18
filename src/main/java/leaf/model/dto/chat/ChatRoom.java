package leaf.model.dto.chat;

import lombok.*;

import javax.persistence.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
@Entity
@Table(schema = "chat", name = "room_list")
public class ChatRoom {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "room_cd")
    private long roomCd;

    @Column(name = "room_nm")
    private String roomNm;

    @Column(name = "room_type")
    private String roomType;

}
