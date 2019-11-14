package leaf.component.jwt;

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
        if (token != null && jwt.isUsable(token)) {
            res.setHeader("Authorization", jwt.createJwt((jwt.getTokenValue("aud").toString())));
            req.setAttribute("memberinfo", memberService.getMemberData(jwt.getTokenValue("aud").toString()));
            System.out.println(req.getAttribute("memberinfo"));
            return true;
        } else {
            throw new RuntimeException("다시 로그인을 해 주세요.");
        }
    }

}
