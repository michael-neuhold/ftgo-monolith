package net.chrisrichardson.ftgo.courierservice.internal.domain;

import net.chrisrichardson.ftgo.courierservice.internal.CourierServiceInternalImpl;
import net.chrisrichardson.ftgo.domain.CourierRepository;
import net.chrisrichardson.ftgo.domain.DomainConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DomainConfiguration.class)
public class CourierServiceConfiguration {

  @Bean
  public CourierServiceInternalImpl courierService(CourierRepository courierRepository) {
    return new CourierServiceInternalImpl(courierRepository);
  }

}
