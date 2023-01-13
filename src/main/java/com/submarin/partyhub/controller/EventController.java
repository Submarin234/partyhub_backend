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
}
