package com.submarin.partyhub.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.submarin.partyhub.domain.AppLocation;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Slf4j
public class LocationService {
    public AppLocation findByName(final String name) throws IOException {
        final List<AppLocation> appLocations = findAll();

        return appLocations
                .stream()
                .filter(appLocation -> appLocation.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    private List<AppLocation> findAll() throws IOException {
        log.info("start...: LOCATION SERVICE - find all");
        final URL url = new URL("http://localhost:8082/location/api/locations");
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        log.info("GOOD: LOCATION SERVICE - find all");
        return objectMapper.readValue(con.getInputStream(), new TypeReference<List<AppLocation>>() {
        });
    }
}
