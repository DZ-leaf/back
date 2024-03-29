//package leaf.component.fcm;
//
//import org.springframework.http.HttpEntity;
//import org.springframework.http.client.ClientHttpRequestInterceptor;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.concurrent.CompletableFuture;
//
//@Service
//public class MobilePushNotificationService {
//
//    private static final String FIREBASE_SERVER_KEY = "AA";
//    private static final String FIREBASE_API_URL = "AA";
//
//    @Async
//    public CompletableFuture<String> send(HttpEntity<String> entity) {
//        RestTemplate restTemplate = new RestTemplate();
//
//        ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
//
//        // interceptors.add(new HeaderRequestInterceptor("Authorization", "key = " + FIREBASE_SERVER_KEY));
//        // interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json; UTF-8"));
//        restTemplate.setInterceptors(interceptors);
//
//        String firebaseResponse = restTemplate.postForObject(FIREBASE_API_URL, entity, String.class);
//
//        return CompletableFuture.completedFuture(firebaseResponse);
//    }
//
//}
