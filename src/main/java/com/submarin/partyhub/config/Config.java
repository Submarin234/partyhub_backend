package com.submarin.partyhub.config;

import com.submarin.partyhub.service.EventService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {
    @Bean
    public EventService userService() {
        return new EventService();
    }
}
