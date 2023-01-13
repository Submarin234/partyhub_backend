package com.submarin.partyhub.config;

import com.submarin.partyhub.service.EventService;
import com.submarin.partyhub.service.LocationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {
    @Bean
    public EventService eventService() {
        return new EventService();
    }

    @Bean
    public LocationService locationService() {
        return new LocationService();
    }
}
