package net.chrisrichardson.ftgo.consumerservice.main;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "consumer-service")
public class ConfigProperties {

    private ConsumerServiceImpl implementation;

}