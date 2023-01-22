package net.chrisrichardson.ftgo.consumerservice.internal;

import net.chrisrichardson.ftgo.common.Money;
import net.chrisrichardson.ftgo.common.PersonName;
import net.chrisrichardson.ftgo.consumerservice.ConsumerService;
import net.chrisrichardson.ftgo.consumerservice.internal.domain.ConsumerNotFoundException;
import net.chrisrichardson.ftgo.domain.Consumer;
import net.chrisrichardson.ftgo.domain.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@Qualifier("consumer-service-internal")
public class ConsumerServiceInternalImpl implements ConsumerService {

  @Autowired
  private ConsumerRepository consumerRepository;

  @Override
  public void validateOrderForConsumer(long consumerId, Money orderTotal) {
    Optional<Consumer> consumer = consumerRepository.findById(consumerId);
    consumer.orElseThrow(ConsumerNotFoundException::new).validateOrderByConsumer(orderTotal);
  }

  @Override
  public Consumer create(PersonName name) {
    Consumer consumer = consumerRepository.save(new Consumer(name));
    return consumer;
  }

  @Override
  public Optional<Consumer> findById(long consumerId) {
    return consumerRepository.findById(consumerId);
  }

}
