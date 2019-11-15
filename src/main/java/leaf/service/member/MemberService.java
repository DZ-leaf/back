
package leaf.service.member;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import leaf.model.dao.member.MemberRepository;
import leaf.model.dto.member.Member;

import javax.transaction.Transactional;

@Transactional
@AllArgsConstructor
@Service
public class MemberService {

    private final MemberRepository repo;

    public boolean register(Member model) {
        try {
            repo.saveAndFlush(model);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

     public Member login(String id, String pw) {
        if (!this.isMemberExist(id, pw)) {
            return null;
        }
        return this.getMemberData(id);
     }

    public Member getMember(String id) {
        return repo.findById(id).get();
    }

    public Member getMemberData(String id) {
        
        return repo.getOne(id);
    }



    public String idCheck(String id) {
        try {
            repo.findById(id).get();
            return "fail";
        } catch (Exception e) {
            return "success";
        }
    }

    // 전달받은 ID에게 발급해준 토큰이 있는지 확인
    public boolean hasToken(String id) {
        return true;
    }

    // 로그인 요청 시 회원의 ID와 Password가 맞는지 확인
    public boolean isMemberExist(String id, String pw) {
        return !repo.findByMemberIdAndMemberPw(id, pw).isEmpty();
    }

 
    public String findId(String name, String email) {
        try {
            return repo.findByMemberNameAndEmail(name, email).get(0).getMemberId();
        } catch (Exception e) {
            return null;
        }
    }

    public String findPw(String id, String email) {
        try {
            return repo.findByMemberIdAndEmail(id, email).get(0).getMemberPw();
        } catch (Exception e) {
            return null;
        }

    }

    public boolean changePw(String id, String pw) {
        try {
            System.out.println("1");
            Member list = repo.getOne(id);
            System.out.println("2");
            System.out.println(pw);
            System.out.println("3");
            System.out.println(list.getMemberPw());
            System.out.println("4");
            if (list.getMemberPw().equals(pw))
                return false;
            System.out.println("5");
            list.setMemberPw(pw);
            repo.save(list);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
