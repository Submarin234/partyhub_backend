package com.submarin.partyhub.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.submarin.partyhub.domain.AppEvent;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class EventService {
    public AppEvent findById(final Long id) throws IOException {
        final List<AppEvent> appEvents = findAll();

        return appEvents
                .stream()
                .filter(appEvent -> appEvent.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<AppEvent> sortByName() throws IOException {
        final List<AppEvent> appEvents = findAll();

        return appEvents
                .stream()
                .sorted(Comparator.comparing(AppEvent::getName))
                .collect(Collectors.toList());
    }

    public List<AppEvent> sortByDate() throws IOException {
        final List<AppEvent> appEvents = findAll();

        return appEvents
                .stream()
                .sorted(Comparator.comparing(AppEvent::getDate))
                .collect(Collectors.toList());
    }

    public List<AppEvent> filterByLocation(final String location) throws IOException {
        final List<AppEvent> appEvents = findAll();

        return appEvents
                .stream()
                .filter(f -> f.getLocation().contains(location) == true)
                .collect(Collectors.toList());
    }

    public List<AppEvent> findAll() throws IOException {
        final URL url = new URL("http://localhost:8082/event/api/events");
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        log.info("GOOD: EVENT SERVICE - find all");
        return objectMapper.readValue(con.getInputStream(), new TypeReference<List<AppEvent>>() {
        });
    }
}
