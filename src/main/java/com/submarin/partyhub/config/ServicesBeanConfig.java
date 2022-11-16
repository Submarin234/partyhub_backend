package com.submarin.partyhub.config;

import com.submarin.partyhub.service.EventService;
import com.submarin.partyhub.service.implementation.EventServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ServicesBeanConfig {

    @Bean
    public EventService userService() {
        return new EventServiceImpl();
    }

}
