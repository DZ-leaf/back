package leaf.model.dao.group;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import leaf.model.dto.group.GroupMember;


public interface GroupMemberRepository extends JpaRepository<GroupMember, String> {

    List<GroupMember> findByMemberId(String memberId);



}
