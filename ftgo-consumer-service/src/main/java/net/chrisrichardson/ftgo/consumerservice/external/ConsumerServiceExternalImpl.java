package net.chrisrichardson.ftgo.consumerservice.external;

import net.chrisrichardson.ftgo.common.Money;
import net.chrisrichardson.ftgo.common.PersonName;
import net.chrisrichardson.ftgo.consumerservice.ConsumerService;
import net.chrisrichardson.ftgo.domain.Consumer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Qualifier("consumer-service-external")
public class ConsumerServiceExternalImpl implements ConsumerService {

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
