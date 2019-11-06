package leaf.model.dao.member;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import leaf.model.dto.member.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

    // @Query(nativeQuery = true, value = "SELECT * FROM member.member_list WHERE userId")
    // memberList findByUsername(String userId);

    List<Member> findByCompanyNmLike(String companyNm);

    List<Member> findByMemberNmAndEmail(String memberNm, String email);

    List<Member> findByMemberIdAndEmail(String memberId, String email);

    List<Member> findByMemberIdAndMemberPw(String memberId, String memberPw);

    Member getOne(String id);

}
