package net.chrisrichardson.ftgo.consumerservice.parallel;

import net.chrisrichardson.ftgo.common.Money;
import net.chrisrichardson.ftgo.common.PersonName;
import net.chrisrichardson.ftgo.consumerservice.ConsumerService;
import net.chrisrichardson.ftgo.domain.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Qualifier("consumer-service-parallel")
public final class ConsumerServiceParallelImpl implements ConsumerService {

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

    }

    @Override
    public Consumer create(PersonName name) {
        return null;
    }

    @Override
    public Optional<Consumer> findById(long consumerId) {
        return Optional.empty();
    }

}
