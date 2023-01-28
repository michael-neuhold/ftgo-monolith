package net.chrisrichardson.ftgo.consumerservice.external.mapper;

import net.chrisrichardson.ftgo.common.PersonName;
import net.chrisrichardson.ftgo.consumerservice.external.model.ConsumerExternal;
import net.chrisrichardson.ftgo.domain.Consumer;

public class ConsumerExternalToConsumerMapper {

    public static Consumer toDomain(ConsumerExternal consumerExternal) {
        Consumer consumer = new Consumer(new PersonName(consumerExternal.getFirstName(), consumerExternal.getLastName()));
        consumer.setId(consumerExternal.getId());
        return consumer;
    }

}
