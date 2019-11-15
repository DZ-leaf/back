package leaf.model.dto.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
@Builder
@Entity
@Table(schema = "member", name = "member_list")
public class Member {

    @Id
    @Column(name = "member_id")
    private String memberId;

    @Column(name = "member_pw")
    private String memberPw;

    @Column(name = "member_nm")
    private String memberName;

    @Column(name = "email")
    private String email;

    @Column(name = "company_nm")
    private String companyName;

    @Column(name = "department_nm")
    private String departmentName;

    @Column(name = "position")
    private String position;

    @Column(name = "profile")
    private String profile;

}
