package leaf.service.member;

import leaf.model.dto.member.Member;

public interface MemberService {

    boolean register(Member model);

    Member getModel(String id);

    String idCheck(String id);

    String findId(String name, String email);

    String findPw(String id, String email);

    boolean changePw(String id, String pw);

    boolean hasToken(String id);

    boolean isMemberExist(String id, String pw);

}
