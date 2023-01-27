package net.chrisrichardson.ftgo.consumerservice.external;

import net.chrisrichardson.ftgo.common.Money;
import net.chrisrichardson.ftgo.common.PersonName;
import net.chrisrichardson.ftgo.consumerservice.ConsumerService;
import net.chrisrichardson.ftgo.consumerservice.external.client.ConsumerServiceClient;
import net.chrisrichardson.ftgo.consumerservice.external.exception.ConsumerServiceExternalException;
import net.chrisrichardson.ftgo.consumerservice.external.mapper.ConsumerExternalToConsumerMapper;
import net.chrisrichardson.ftgo.consumerservice.external.mapper.ConsumerToConsumerExternalMapper;
import net.chrisrichardson.ftgo.consumerservice.external.model.ConsumerExternal;
import net.chrisrichardson.ftgo.domain.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static net.chrisrichardson.ftgo.consumerservice.external.constants.LogConstants.EXTERNAL_CONSUMER_SERVICE;

@Service
@Qualifier("consumer-service-external")
public class ConsumerServiceExternalImpl implements ConsumerService {

    private static final Logger LOG = LoggerFactory.getLogger(ConsumerServiceExternalImpl.class);

    @Autowired
    ConsumerServiceClient consumerServiceClient;

    @Override
    public void hello() {
        System.out.println("Hello from consumer service external");
    }

    @Override
    public void validateOrderForConsumer(long consumerId, Money orderTotal) {
        LOG.info(EXTERNAL_CONSUMER_SERVICE);
    }

    @Override
    public Consumer create(PersonName name) {
        LOG.info(EXTERNAL_CONSUMER_SERVICE + ": Create consumer.");
        Optional<ConsumerExternal> createdConsumer = consumerServiceClient
                .create(ConsumerToConsumerExternalMapper.toExternal(new Consumer(name)));

        if (createdConsumer.isPresent()) {
            return ConsumerExternalToConsumerMapper.toDomain(createdConsumer.get());
        } else {
            throw new ConsumerServiceExternalException("Consumer could not be created. External consumer service error.");
        }
    }

    @Override
    public Optional<Consumer> findById(long consumerId) {
        LOG.info(EXTERNAL_CONSUMER_SERVICE + ": find consumer by id.");
        return consumerServiceClient.findById(consumerId)
                .map(ConsumerExternalToConsumerMapper::toDomain);
    }

}
