package leaf.component.jwt;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
@AllArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private JwtInterceptor jwtInterceptor;

    private static final String[] EXCLUDE_PATHS = { 
        "/**" 
    };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/**").excludePathPatterns(EXCLUDE_PATHS);
    }

}
