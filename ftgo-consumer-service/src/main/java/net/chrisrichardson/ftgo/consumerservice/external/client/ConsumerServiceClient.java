package net.chrisrichardson.ftgo.consumerservice.external.client;

import net.chrisrichardson.ftgo.consumerservice.external.model.ConsumerExternal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Optional;

import static net.chrisrichardson.ftgo.consumerservice.external.constants.HttpConstants.CONSUMERS_RESOURCE;
import static net.chrisrichardson.ftgo.consumerservice.external.constants.HttpConstants.CONSUMER_SERVICE_BASE;

@Service
public class ConsumerServiceClient {

    private static final Logger LOG = LoggerFactory.getLogger(ConsumerServiceClient.class);

    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

    public Optional<ConsumerExternal> create(ConsumerExternal consumerExternal) {
        LOG.info("Send request 'create consumer' to external consumer service at '{}'.", CONSUMERS_RESOURCE);

        ResponseEntity<ConsumerExternal> response =
                REST_TEMPLATE.postForEntity(CONSUMERS_RESOURCE, consumerExternal, ConsumerExternal.class);

        if (response.getStatusCode().equals(HttpStatus.CREATED)) {
            Optional<ConsumerExternal> createdConsumer =
                    getCreatedConsumer(response.getHeaders().getLocation());
            createdConsumer.ifPresent(external -> LOG.info("Consumer was created '{}'.", external));
            return createdConsumer;
        } else {
            LOG.info("Consumer could not be created. Request returned with status code: '{}'.", response.getStatusCode());
            return Optional.empty();
        }
    }

    public Optional<ConsumerExternal> findById(Long id) {
        LOG.info("Send request 'find by id' to external consumer service at '{}'.", CONSUMERS_RESOURCE);

        LOG.info("Path: " + CONSUMERS_RESOURCE + "/" + id);
        ResponseEntity<ConsumerExternal> response =
                REST_TEMPLATE.getForEntity(CONSUMERS_RESOURCE + "/" + id, ConsumerExternal.class);

        return Optional.ofNullable(response.getBody());
    }

    private Optional<ConsumerExternal> getCreatedConsumer(URI createdConsumerLocation) {
        LOG.info("Send request 'get created consumer (find by id)' to external consumer service at '{}'.",
                CONSUMERS_RESOURCE);

        ResponseEntity<ConsumerExternal> response =
                REST_TEMPLATE.getForEntity(CONSUMER_SERVICE_BASE + createdConsumerLocation, ConsumerExternal.class);

        return Optional.ofNullable(response.getBody());
    }

}
