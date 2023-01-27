package net.chrisrichardson.ftgo.consumerservice.external.mapper;

import net.chrisrichardson.ftgo.consumerservice.external.model.ConsumerExternal;
import net.chrisrichardson.ftgo.domain.Consumer;

public class ConsumerToConsumerExternalMapper {

    public static ConsumerExternal toExternal(Consumer consumer) {
        return new ConsumerExternal(consumer.getId(), consumer.getName().getFirstName(), consumer.getName().getLastName(), "");
    }

}
