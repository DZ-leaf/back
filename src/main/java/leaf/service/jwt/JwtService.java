package leaf.service.jwt;

import java.util.Map;

public interface JwtService {

    String createJwt(String id);

    byte[] generateKey();

    boolean isUsable(String jwt);

    Map<String, Object> getToken();

    Object getTokenValue(String key);

}
