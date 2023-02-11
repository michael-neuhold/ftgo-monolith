package net.chrisrichardson.ftgo.courierservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "courier-service")
public class ConfigProperties {
}
