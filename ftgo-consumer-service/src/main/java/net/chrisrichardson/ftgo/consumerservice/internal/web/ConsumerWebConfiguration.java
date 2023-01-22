package net.chrisrichardson.ftgo.consumerservice.internal.web;

import net.chrisrichardson.ftgo.consumerservice.internal.domain.ConsumerConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@Import(ConsumerConfiguration.class)
public class ConsumerWebConfiguration {
}
