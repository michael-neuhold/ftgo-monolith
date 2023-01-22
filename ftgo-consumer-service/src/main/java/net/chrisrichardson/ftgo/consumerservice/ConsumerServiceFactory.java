package net.chrisrichardson.ftgo.consumerservice;

import net.chrisrichardson.ftgo.consumerservice.main.ConsumerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public final class ConsumerServiceFactory {
    @Autowired
    public ConsumerServiceFactory(@Qualifier("consumer-service-internal") ConsumerService consumerServiceInternal,
                                  @Qualifier("consumer-service-external") ConsumerService consumerServiceExternal,
                                  @Qualifier("consumer-service-parallel") ConsumerService consumerServiceParallel,
                                  @Value("${consumer-service.implementation}") ConsumerServiceImpl consumerServiceImpl) {
        this.consumerServiceInternal = consumerServiceInternal;
        this.consumerServiceExternal = consumerServiceExternal;
        this.consumerServiceParallel = consumerServiceParallel;
        this.defaultImplementation = consumerServiceImpl;
        System.out.println("DEFAULT IMPLEMENTATION --> " + consumerServiceImpl);
    }

    private final ConsumerService consumerServiceInternal;

    private final ConsumerService consumerServiceExternal;

    private final ConsumerService consumerServiceParallel;

    private final ConsumerServiceImpl defaultImplementation;

    public ConsumerService defaultImpl() {
        switch (defaultImplementation) {
            case EXTERNAL: return externalImpl();
            case INTERNAL: return internalImpl();
            case PARALLEL: return parallelImpl();
            default: throw new IllegalArgumentException("No match!");
        }
    }

    public ConsumerService internalImpl() {
        return consumerServiceInternal;
    }

    public ConsumerService externalImpl() {
        return consumerServiceExternal;
    }

    public ConsumerService parallelImpl() {
        return consumerServiceParallel;
    }

}
