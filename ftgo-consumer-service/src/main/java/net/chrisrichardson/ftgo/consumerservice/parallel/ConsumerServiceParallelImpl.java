package net.chrisrichardson.ftgo.consumerservice.parallel;

import io.sentry.Sentry;
import net.chrisrichardson.ftgo.common.Money;
import net.chrisrichardson.ftgo.common.PersonName;
import net.chrisrichardson.ftgo.consumerservice.ConsumerService;
import net.chrisrichardson.ftgo.domain.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static net.chrisrichardson.ftgo.consumerservice.external.constants.LogConstants.EXTERNAL_CONSUMER_SERVICE;

@Service
@Qualifier("consumer-service-parallel")
public final class ConsumerServiceParallelImpl implements ConsumerService {

    private static final Logger LOG = LoggerFactory.getLogger(ConsumerServiceParallelImpl.class);

    @Autowired
    @Qualifier("consumer-service-internal")
    ConsumerService consumerServiceInternal;

    @Autowired
    @Qualifier("consumer-service-external")
    ConsumerService consumerServiceExternal;

    @Override
    public void hello() {
        System.out.println("Hello from Consumer Service Parallel");
    }

    @Override
    public void validateOrderForConsumer(long consumerId, Money orderTotal) {
        LOG.info(EXTERNAL_CONSUMER_SERVICE);
    }

    @Override
    public Consumer create(PersonName name) {
        Consumer createdConsumerInternal = consumerServiceInternal.create(name);
        Consumer createdConsumerExternal = consumerServiceExternal.create(name);

        if (!createdConsumerInternal.getId().equals(createdConsumerExternal.getId())) {
            Sentry.captureException(new Exception("Internal and externally created consumer diverge."));
        }

        return createdConsumerInternal;
    }

    @Override
    public Optional<Consumer> findById(long consumerId) {
        Optional<Consumer> foundConsumerInternal = consumerServiceInternal.findById(consumerId);
        Optional<Consumer> foundConsumerExternal = consumerServiceExternal.findById(consumerId);

        if (foundConsumerExternal.isPresent() && !foundConsumerInternal.isPresent()) {
            Sentry.captureException(new Exception("Internal and externally found consumer diverge."));
        }

        return foundConsumerInternal;
    }

}
