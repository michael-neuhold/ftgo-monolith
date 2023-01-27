package net.chrisrichardson.ftgo.consumerservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "consumer-service")
public class ConfigProperties {

    private ConsumerServiceImpl implementation;

    private String consumerMicroServiceBaseUrl;

}