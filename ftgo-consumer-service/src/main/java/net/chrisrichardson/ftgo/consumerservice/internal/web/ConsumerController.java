package net.chrisrichardson.ftgo.consumerservice.internal.web;

import net.chrisrichardson.ftgo.consumerservice.ConsumerService;
import net.chrisrichardson.ftgo.consumerservice.ConsumerServiceFactory;
import net.chrisrichardson.ftgo.consumerservice.api.web.CreateConsumerRequest;
import net.chrisrichardson.ftgo.consumerservice.api.web.CreateConsumerResponse;
import net.chrisrichardson.ftgo.consumerservice.api.web.GetConsumerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/consumers")
public class ConsumerController {

  private final ConsumerService consumerService;

  public ConsumerController(ConsumerServiceFactory consumerServiceFactory) {
    this.consumerService = consumerServiceFactory.defaultImpl();
  }

  @RequestMapping(method= RequestMethod.POST)
  public CreateConsumerResponse create(@RequestBody CreateConsumerRequest request) {
    return new CreateConsumerResponse(consumerService.create(request.getName()).getId());
  }

  @RequestMapping(method= RequestMethod.GET,  path="/{consumerId}")
  public ResponseEntity<GetConsumerResponse> get(@PathVariable long consumerId) {
      System.out.println("controller return value: " + consumerService.findById(consumerId));
      return consumerService.findById(consumerId)
            .map(consumer -> {
              GetConsumerResponse getConsumerResponse = new GetConsumerResponse(consumer.getName());
              getConsumerResponse.setConsumerId(consumer.getId());
              return new ResponseEntity<>(getConsumerResponse, HttpStatus.OK);
            })
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

}
