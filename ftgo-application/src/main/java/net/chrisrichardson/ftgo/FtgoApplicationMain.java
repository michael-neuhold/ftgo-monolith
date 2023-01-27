package net.chrisrichardson.ftgo;

import net.chrisrichardson.ftgo.consumerservice.ConfigProperties;
import net.chrisrichardson.ftgo.consumerservice.ConsumerServiceConfiguration;
import net.chrisrichardson.ftgo.orderservice.main.OrderServiceConfiguration;
import net.chrisrichardson.ftgo.restaurantservice.RestaurantServiceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@Import({ConsumerServiceConfiguration.class,
        OrderServiceConfiguration.class,
        RestaurantServiceConfiguration.class})
@EnableConfigurationProperties(ConfigProperties.class)
public class FtgoApplicationMain {

  public static void main(String[] args) {
    SpringApplication.run(FtgoApplicationMain.class, args);
  }
}
