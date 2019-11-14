package leaf.component.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class Jwt {

    /*
     ** Salt, for Signature Hash
     */
    private static final String SALT = "COO_LJE_BJY_JJH_IN_DZ_LEAF_FINAL_TEAM";

    /*
     ** Create Token
     */
    public String createJwt(String id) {
        // use "SHA-256" Hash Algorithm
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        final Key key = new SecretKeySpec(generateKey(), signatureAlgorithm.getJcaName());

        // JWT Header, 해시 알고리즘 정보 포함
        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");

        // JWT Claims Set (Body)
        Map<String, Object> claims = new HashMap<>();
        // Token 발행자 (issuer)
        claims.put("iss", "http://hotba.ga");
        // Token 제목 (subject)
        claims.put("sub", "MemberToken");
        // Token 대상자 (audience)
        claims.put("aud", id);
        // Token 발급 시간 (issued at)
        claims.put("iat", new Date());
        // Token 만료 시간 (expiration) (Token 1시간 유지)
        claims.put("exp", new Date(System.currentTimeMillis() + 1000 * 60 * 60));

        // JWT가 생성되는 부분, 생성되는 JWT를 String type로 변환하여 return
        return Jwts.builder().setHeader(header).setClaims(claims).signWith(key, signatureAlgorithm).compact();
    }

    /*
     ** Key 생성
     */
    public byte[] generateKey() {
        return SALT.getBytes(StandardCharsets.UTF_8);
    }
    /*
     ** Claim으로 변환 도중 예외가 발생하거나 토큰이 만료되었다면 유효하지 않은 토큰으로 판단하여 Exception handling
     */
    public boolean isUsable(String jwt) {
        if (jwt == null)
            return false;
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(this.generateKey()).parseClaimsJws(jwt);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            throw new RuntimeException("로그인 유지 시간이 만료되었습니다. 다시 로그인을 해 주세요.");
        }
    }

    private HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }

    /*
     ** Token을 가져오는 코드 HTTP Header -> JWT -> Claim -> Key -> Value
     */
    public Map<String, Object> getToken() {
        HttpServletRequest req = this.getRequest();
        String jwt = req.getHeader("Authorization");
        Jws<Claims> claims = null;
        try {
            claims = Jwts.parser().setSigningKey(this.generateKey()).parseClaimsJws(jwt);
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return claims.getBody();
    }

    /*
     ** JWT에 넣어둔 데이터를 가져오는 코드 HTTP Header -> JWT -> Claim -> Key -> Value
     */
    public Object getTokenValue(String key) {
        HttpServletRequest req = this.getRequest();
        String jwt = req.getHeader("Authorization");
        Jws<Claims> claims = null;
        try {
            claims = Jwts.parser().setSigningKey(this.generateKey()).parseClaimsJws(jwt);
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return claims.getBody().get(key);
    }

}