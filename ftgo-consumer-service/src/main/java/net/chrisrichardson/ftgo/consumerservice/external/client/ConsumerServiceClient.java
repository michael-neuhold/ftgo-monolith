package net.chrisrichardson.ftgo.consumerservice.external.client;

import net.chrisrichardson.ftgo.consumerservice.external.model.ConsumerExternal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ConsumerServiceClient {

    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

    public ConsumerExternal create(ConsumerExternal consumerExternal) {
        String fooResourceUrl = "http://localhost:8080/spring-rest/foos";
        ResponseEntity<ConsumerExternal> response =
                REST_TEMPLATE.postForEntity(fooResourceUrl + "/1", consumerExternal, ConsumerExternal.class);
        return response.getBody();
    }

    public ConsumerExternal findById(Long id) {
        String fooResourceUrl = "http://localhost:8080/spring-rest/foos";
        ResponseEntity<ConsumerExternal> response =
                REST_TEMPLATE.getForEntity(fooResourceUrl + "/" + id, ConsumerExternal.class);
        return response.getBody();
    }

}
