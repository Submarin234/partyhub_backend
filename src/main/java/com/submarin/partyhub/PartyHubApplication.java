package com.submarin.partyhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// TODO: 11/16/2022
//taie exclude cand e configurata baza de date
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class PartyHubApplication {


    public static void main(String[] args) {
        SpringApplication.run(PartyHubApplication.class, args);
    }

}
