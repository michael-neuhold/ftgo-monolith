package net.chrisrichardson.ftgo.courierservice.internal.web;

import net.chrisrichardson.ftgo.courierservice.internal.domain.CourierServiceConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CourierServiceConfiguration.class)
@ComponentScan
public class CourierWebConfiguration {
}
