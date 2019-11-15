package leaf.model.dto.group;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
@Entity
@Table(schema = "group", name = "group_member")
public class groupMember {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="player_id")
    private Long groupMemberId;

    private String groupNM;

    private String memberId;

}