package leaf.component.jwt;

import leaf.model.dto.member.Member;
import leaf.service.member.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@Component
@AllArgsConstructor
public class JwtInterceptor implements HandlerInterceptor {

    private Jwt jwt;
    private MemberService memberService;

    @Transactional
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        final String token = req.getHeader("Authorization");
        System.out.println(req.getRequestURI());
        String str = "";
        if (token != null && jwt.isUsable(token)) {
            str = jwt.getTokenValue("aud").toString();
            res.setHeader("Authorization", jwt.createJwt(str));
            Member member = memberService.getMember(str);
            req.setAttribute("memberinfo", member);
            return true;
        } else {
            throw new RuntimeException("다시 로그인을 해 주세요.");
        }
    }

}
