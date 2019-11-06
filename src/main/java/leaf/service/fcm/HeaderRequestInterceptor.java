//package leaf.service.fcmserver;
//
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import org.springframework.http.HttpRequest;
//import org.springframework.http.client.ClientHttpRequestExecution;
//import org.springframework.http.client.ClientHttpRequestInterceptor;
//import org.springframework.http.client.ClientHttpResponse;
//import org.springframework.http.client.support.HttpRequestWrapper;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//@AllArgsConstructor
//@NoArgsConstructor
//public class HeaderRequestInterceptor implements ClientHttpRequestInterceptor {
//
//    private final String headerName;
//    private final String headerValue;
//
//    @Override
//    public ClientHttpResponse intercept(HttpRequest req, byte[] body, ClientHttpRequestExecution execution) throws IOException {
//        HttpRequest wrapper = new HttpRequestWrapper(req);
//        wrapper.getHeaders().set(headerName, headerValue);
//        return execution.execute(wrapper, body);
//    }
//
//}
