package net.chrisrichardson.ftgo.courierservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CourierServiceFactory {

    private static final Logger LOG = LoggerFactory.getLogger(CourierServiceFactory.class);

    @Autowired
    public CourierServiceFactory(@Qualifier("courier-service-internal") CourierService courierServiceInternal,
                                 @Qualifier("courier-service-external") CourierService courierServiceExternal,
                                 @Qualifier("courier-service-parallel") CourierService courierServiceParallel,
                                 @Value("${courier-service.implementation}") CourierServiceImpl courierServiceImpl) {
        this.courierServiceInternal = courierServiceInternal;
        this.courierServiceExternal = courierServiceExternal;
        this.courierServiceParallel = courierServiceParallel;
        this.defaultImplementation = courierServiceImpl;
        LOG.info("Default courier service implementation: " + courierServiceImpl);
    }

    private final CourierService courierServiceInternal;

    private final CourierService courierServiceExternal;

    private final CourierService courierServiceParallel;

    private final CourierServiceImpl defaultImplementation;

    public CourierService defaultImpl() {
        switch (defaultImplementation) {
            case EXTERNAL:
                return externalImpl();
            case INTERNAL:
                return internalImpl();
            case PARALLEL:
                return parallelImpl();
            default:
                throw new IllegalArgumentException("No match!");
        }
    }

    public CourierService internalImpl() {
        return courierServiceInternal;
    }

    public CourierService externalImpl() {
        return courierServiceExternal;
    }

    public CourierService parallelImpl() {
        return courierServiceParallel;
    }

}
