package net.chrisrichardson.ftgo.courierservice.external.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.chrisrichardson.ftgo.courierservice.external.model.ActionExternal;
import net.chrisrichardson.ftgo.courierservice.external.model.CourierExternal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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
                    getCreatedCourier(response.getHeaders().getLocation());
            createdCourier.ifPresent(external -> LOG.info("Courier was created '{}'.", external));
            return createdCourier;
        } else {
            LOG.info("Courier could not be created. Request returned with status code: '{}'.", response.getStatusCode());
            return Optional.empty();
        }
    }

    public void update(CourierExternal courierExternal) {
        LOG.info("Send request 'update courier' to external courier service at '{}'.", COURIERS_RESOURCE);

        ResponseEntity<CourierExternal> response =
                REST_TEMPLATE.postForEntity(COURIERS_RESOURCE, courierExternal, CourierExternal.class);
    }

    public Optional<CourierExternal> findById(Long id) {
        LOG.info("Send request 'find by id' to external courier service at '{}'.", COURIERS_RESOURCE);

        ResponseEntity<CourierExternal> response =
                REST_TEMPLATE.getForEntity(COURIERS_RESOURCE + "/" + id, CourierExternal.class);

        return Optional.ofNullable(response.getBody());
    }

    public List<CourierExternal> findAll() {
        LOG.info("Send request 'find by id' to external courier service at '{}'.", COURIERS_RESOURCE);
        ObjectMapper mapper = new ObjectMapper();

        ResponseEntity<Object[]> response =
                REST_TEMPLATE.getForEntity(COURIERS_RESOURCE, Object[].class);

        return Arrays.stream(Objects.requireNonNull(response.getBody()))
                .map(object -> mapper.convertValue(object, CourierExternal.class))
                .collect(Collectors.toList());
    }

    private Optional<CourierExternal> getCreatedCourier(URI createdCourierLocation) {
        LOG.info("Send request 'get created courier (find by id)' to external courier service at '{}'.",
                COURIERS_RESOURCE);

        ResponseEntity<CourierExternal> response =
                REST_TEMPLATE.getForEntity(COURIER_SERVICE_BASE + createdCourierLocation, CourierExternal.class);

        return Optional.ofNullable(response.getBody());
    }

    public void createActionForCourier(ActionExternal action) {
        LOG.info("Send request 'create action for courier' to external courier service at '{}'.",
                COURIERS_RESOURCE);

        ResponseEntity<CourierExternal> response =
                REST_TEMPLATE.postForEntity(COURIERS_RESOURCE + "/" + action.getCourierId() + "/action", action, CourierExternal.class);

        if (response.getStatusCode().equals(HttpStatus.OK)) {
            Optional<CourierExternal> courierWithCreatedAction =
                    getCreatedCourier(response.getHeaders().getLocation());
            courierWithCreatedAction.ifPresent(external -> LOG.info("Action of Courier was created '{}'.", external));
        } else {
            LOG.info("Courier could not be created. Request returned with status code: '{}'.", response.getStatusCode());
        }
    }

}
