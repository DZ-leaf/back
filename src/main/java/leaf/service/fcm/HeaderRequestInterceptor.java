package leaf.service.fcm;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HeaderRequestInterceptor implements ClientHttpRequestInterceptor {

    private String headerName;
    private String headerValue;

    @Override
    public ClientHttpResponse intercept(HttpRequest req, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpRequest wrapper = new HttpRequestWrapper(req);
        wrapper.getHeaders().set(headerName, headerValue);
        return execution.execute(wrapper, body);


    }

}
