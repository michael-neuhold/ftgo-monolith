package net.chrisrichardson.ftgo.courierservice.external.client;

import net.chrisrichardson.ftgo.courierservice.external.model.CourierExternal;
import net.chrisrichardson.ftgo.domain.Courier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Optional;

import static net.chrisrichardson.ftgo.courierservice.external.constants.HttpConstants.COURIERS_RESOURCE;
import static net.chrisrichardson.ftgo.courierservice.external.constants.HttpConstants.COURIER_SERVICE_BASE;

@Service
public class CourierServiceClient {

    private static final Logger LOG = LoggerFactory.getLogger(CourierServiceClient.class);

    private static final RestTemplate REST_TEMPLATE = new RestTemplate();


    public Optional<CourierExternal> create(CourierExternal courierExternal) {
        LOG.info("Send request 'create courier' to external courier service at '{}'.", COURIERS_RESOURCE);

        ResponseEntity<CourierExternal> response =
                REST_TEMPLATE.postForEntity(COURIERS_RESOURCE, courierExternal, CourierExternal.class);

        if (response.getStatusCode().equals(HttpStatus.CREATED)) {
            Optional<CourierExternal> createdCourier =
                    getCreatedConsumer(response.getHeaders().getLocation());
            createdCourier.ifPresent(external -> LOG.info("Courier was created '{}'.", external));
            return createdCourier;
        } else {
            LOG.info("Courier could not be created. Request returned with status code: '{}'.", response.getStatusCode());
            return Optional.empty();
        }
    }

    public Optional<CourierExternal> update(CourierExternal courierExternal) {
        LOG.info("Send request 'update courier' to external courier service at '{}'.", COURIERS_RESOURCE);

        CourierExternal response =
                REST_TEMPLATE.patchForObject(COURIERS_RESOURCE, courierExternal, CourierExternal.class);

        return Optional.ofNullable(response);
    }

    public Optional<CourierExternal> findById(Long id) {
        LOG.info("Send request 'find by id' to external courier service at '{}'.", COURIERS_RESOURCE);

        ResponseEntity<CourierExternal> response =
                REST_TEMPLATE.getForEntity(COURIERS_RESOURCE + "/" + id, CourierExternal.class);

        return Optional.ofNullable(response.getBody());
    }

    private Optional<CourierExternal> getCreatedConsumer(URI createdCourierLocation) {
        LOG.info("Send request 'get created courier (find by id)' to external courier service at '{}'.",
                COURIERS_RESOURCE);

        ResponseEntity<CourierExternal> response =
                REST_TEMPLATE.getForEntity(COURIER_SERVICE_BASE + createdCourierLocation, CourierExternal.class);

        return Optional.ofNullable(response.getBody());
    }

}
