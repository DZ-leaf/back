package leaf.controller.member;


import leaf.model.dao.company.AlarmRepository;
import leaf.model.dto.company.Alarm;
import leaf.model.dto.member.Member;
import leaf.component.jwt.Jwt;
import leaf.component.s3.S3FileIO;
import leaf.service.company.CompanyService;
import leaf.service.member.MemberService;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// import leaf.controller.S3Uploader;

@CrossOrigin("origin-allowed = *")
@AllArgsConstructor
@RestController
@RequestMapping(value = "/member")
public class MemberController {

    private MemberService memberService;
    private CompanyService companyService;
    private Jwt jwt;
    private JavaMailSender javaMailSender;
    private AlarmRepository repo;
    private S3FileIO s3uploader;

    // 진짜 코드 (수정 금지)

//    @PostMapping("/login")
//    public Map<String, Object> login(@RequestBody Member member, HttpServletResponse res) {
//        Map<String, Object> map = new HashMap<>();
//        if (memberService.isMemberExist(member.getMemberId(), member.getMemberPw())) {
//            String token = jwtService.createJwt(member.getMemberId());
//            res.setHeader("Authorization", token);
//            map.put("message", "success");
//            map.put("info", member.getMemberName());
//        } else {
//            map.put("message", "fail");
//        }
//        return map;
//    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Member member, HttpServletResponse res) {
        System.out.println("/member/login");
        System.out.println(member);
        Map<String, Object> map = new HashMap<>();
        Member memberData = memberService.login(member.getMemberId(), member.getMemberPw());
        if (memberData == null) {
            map.put("message", "fail");
        } else {
            String token = jwt.createJwt(memberData.getMemberId());
            res.setHeader("Authorization", token);
            map.put("member", memberData);           
            map.put("message", "success");
        }
        return map;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Map<String, Object> register(@RequestBody Member member) {
        Map<String, Object> map = new HashMap<>();
        System.out.println("/member/register");
        System.out.println(member);
        map.put("message", memberService.register(member) ? "success" : "fail");
        return map;
    }

    @RequestMapping(value = "/idCheck", method = RequestMethod.POST)
    public Map<String, Object> idCheck(@RequestBody Object obj) {
        Map<String, Object> map = new HashMap<>();
        System.out.println("/member/idCheck");
        System.out.println("도커된당");
        map.put("message", memberService.idCheck(obj.toString()));

        return map;
    }

    @RequestMapping(value = "/findCompany", method = RequestMethod.POST)
    public Map<String, Object> findCompany(@RequestBody Object obj) {
        Map<String, Object> map = new HashMap<>();
        System.out.println("/member/findCompany");
        try {
            map.put("data", companyService.findCompany(obj.toString()));
            map.put("message", "success");
        } catch (Exception e) {
            map.put("message", "fail");
        }
        return map;
    }

    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public Map<String, Object> sendEmail(@RequestBody Object obj) {
        Map<String, Object> map = new HashMap<>();
        System.out.println("/member/sendEmail");
        String email = obj.toString();
        try {
            String authNum = this.sendEmail(email);
            map.put("authNum", authNum);
            map.put("message", "success");
        } catch (Exception e) {
            System.out.println(e);
            map.put("message", "fail");
        }
        return map;
    }

    // 테스트 코드 (수정 가능)

    @RequestMapping(value = "/findIdAuthNm", method = RequestMethod.POST)
    public Map<String, Object> findIdAuthNm(@RequestBody String obj) {
        Map<String, Object> map = new HashMap<>();
        System.out.println("/member/findIdAuthNm");
        JSONObject json = new JSONObject(obj);
        String name = json.getString("memberNm");
        String email = json.getString("email");
        System.out.println(name + " @@ " + email);
        if (memberService.findId(name, email) != null) {
            String authNum = this.sendEmail(email);
            map.put("authNum", authNum);
            map.put("message", "success");
        } else
            map.put("message", "fail");
        return map;
    }

    @RequestMapping(value = "/findId", method = RequestMethod.POST)
    public Map<String, Object> findId(@RequestBody String obj) {
        Map<String, Object> map = new HashMap<>();
        System.out.println("/member/findId");
        JSONObject json = new JSONObject(obj);
        String name = json.getString("memberNm");
        String email = json.getString("email");
        map.put("memberId", memberService.findId(name, email));
        map.put("message", "success");
        return map;
    }

    @RequestMapping(value = "/findPwAuthNm", method = RequestMethod.POST)
    public Map<String, Object> findPwAuthNm(@RequestBody String obj) {
        Map<String, Object> map = new HashMap<>();
        System.out.println("/member/findPwAuthNm");
        JSONObject json = new JSONObject(obj);
        String id = json.getString("memberId");
        String email = json.getString("email");
        System.out.println(id + " @@ " + email);
        if (memberService.findPw(id, email) != null) {
            String authNum = this.sendEmail(email);
            map.put("authNum", authNum);
            map.put("message", "success");
        } else
            map.put("message", "fail");
        return map;
    }

    @RequestMapping(value = "/changePw", method = RequestMethod.POST)
        public Map<String, Object> changePw(@RequestBody String obj) {
            Map<String, Object> map = new HashMap<>();
            System.out.println("/member/changePw");
            JSONObject json = new JSONObject(obj);
            String id = json.getString("memberId");
            String pw = json.getString("memberPw");
        if (memberService.changePw(id, pw)) {
            map.put("message", "success");
        } else {
            map.put("message", "fail");
        }
        return map;
    }

    @GetMapping("/mongotest")
    public List<Alarm> mongoTest() {
        return repo.findAll();
    }

    // @RequestMapping(value = "/s3put", method = RequestMethod.GET)
    // public void put() {
    // String filePath = "C:\\Users\\BIT\\Downloads\\book2.png";
    // s3uploader.putObject("dz-leaf", filePath);
    // }

    // @RequestMapping(value = "/s3delete", method = RequestMethod.GET)
    // public void delete() {
    // s3uploader.deleteObject("dz-leaf", "book.png");
    // }

    // @RequestMapping(value = "/s3getallobject", method = RequestMethod.GET)
    // public List<S3ObjectSummary> getAllObject() {
    // return s3uploader.getAllObject("dz-leaf");
    // }

    private String sendEmail(String email) {
        int num = (int) Math.round(Math.random() * 100000);
        SimpleMailMessage msg = new SimpleMailMessage();
        System.out.println(email);
        msg.setTo(email);
        msg.setSubject("test");
        msg.setText("인증번호 : " + num);
        javaMailSender.send(msg);
        return Integer.toString(num);
    }

}
