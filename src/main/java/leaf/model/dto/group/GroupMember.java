package leaf.model.dto.group;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
@Entity
@Table(schema = "groups", name = "group_member_list")
@Builder
public class GroupMember {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="group_member_cd")
    private Long groupMemberCd;

    @Column(name = "group_nm")
    private String groupNm;

    @Column(name = "member_id")
    private String memberId;

}
