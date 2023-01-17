package com.submarin.partyhub.controller;

import com.submarin.partyhub.domain.AppEvent;
import com.submarin.partyhub.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/event/api")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping("/events/{id}")
    public ResponseEntity<?> getEventById(@PathVariable Long id) {

        final AppEvent event;
        try {
            event = eventService.findById(id);
        } catch (IOException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }

        if (event != null)
            return ResponseEntity.ok().body(event);
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found!");
        }
    }

    @GetMapping("/events")
    public ResponseEntity<?> findAll() {

        final List<AppEvent> events;

        try {
            events = eventService.findAll();
        } catch (IOException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }

        return ResponseEntity.ok().body(events);
    }

    @GetMapping("/events/sortbyname")
    public ResponseEntity<?> sortByName() {

        final List<AppEvent> events;

        try {
            events = eventService.sortByName();
        } catch (IOException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }

        return ResponseEntity.ok().body(events);
    }

    @GetMapping("/events/sortbydate")
    public ResponseEntity<?> sortByDate() {

        final List<AppEvent> events;

        try {
            events = eventService.sortByDate();
        } catch (IOException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }

        return ResponseEntity.ok().body(events);
    }

    @GetMapping("/events/filterbylocation")
    public ResponseEntity<?> filterByLocation() {

        final List<AppEvent> events;

        try {
            events = eventService.filterByLocation();
        } catch (IOException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }

        return ResponseEntity.ok().body(events);
    }
}
