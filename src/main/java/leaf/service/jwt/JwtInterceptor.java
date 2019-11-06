package leaf.service.jwt;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@AllArgsConstructor
public class JwtInterceptor implements HandlerInterceptor {

    private JwtServiceImpl jwtService;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        final String token = req.getHeader("Authorization");
        if (token != null && jwtService.isUsable(token)) {
            res.setHeader("Authorization", jwtService.createJwt((jwtService.getTokenValue("aud").toString())));
            return true;
        } else {
            throw new UnauthorizedException();
        }
    }

}
