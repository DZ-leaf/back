package leaf.model.dto.member;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
@Entity
@Table(schema = "member", name = "member_list")
public class Member {

    @Id
    private String memberId;
    
    private String memberPw;
    
    private String memberNm;

    private String email;

    private String companyNm;
    
    private String departmentNm;
    
    private String position;
    
    private String profile;

}
