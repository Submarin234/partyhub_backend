package com.submarin.partyhub.controller;

import com.submarin.partyhub.domain.AppLocation;
import com.submarin.partyhub.service.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping(path = "/location/api")
@RequiredArgsConstructor
@Slf4j
public class LocationController {

    private final LocationService locationService;


    @GetMapping("/locations/{name}")
    public ResponseEntity<?> getLocationByName(@PathVariable String name) {
        final AppLocation location;

        try {
            location = locationService.findByName(name);
        } catch (IOException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }

        if (location != null)
            return ResponseEntity.ok().body(location);
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Location not found!");
        }
    }
}
