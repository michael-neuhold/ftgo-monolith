package net.chrisrichardson.ftgo.consumerservice;

import net.chrisrichardson.ftgo.common.Money;
import net.chrisrichardson.ftgo.common.PersonName;
import net.chrisrichardson.ftgo.domain.Consumer;

import java.util.Optional;

public interface ConsumerService {

    void validateOrderForConsumer(long consumerId, Money orderTotal);

    Consumer create(PersonName name);

    public Optional<Consumer> findById(long consumerId);


}
