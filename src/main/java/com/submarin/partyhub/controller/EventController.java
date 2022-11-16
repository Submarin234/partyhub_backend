package com.submarin.partyhub.controller;

import com.submarin.partyhub.domain.Event;
import com.submarin.partyhub.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path="/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/find/{name}")
    public ResponseEntity<?> getEventByName(@PathVariable String name) {

        Event event = eventService.findByName(name);
        if (event != null)
            return ResponseEntity.ok().body(event);
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }

    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<?> getEventByName(@PathVariable Long id) {

        Event event = eventService.findById(id);
        if (event != null)
            return ResponseEntity.ok().body(event);
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }

    }

    @GetMapping("/find")
    public ResponseEntity<?> getAll() {
        List<Event> events=eventService.findAll();
        return ResponseEntity.ok().body(events.toArray(new Event[0]));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Event event){
        try{
            Event addedEvent=eventService.add(event);
            return ResponseEntity.ok().body(addedEvent);
        }catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id or name already in database!");
        }
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            eventService.delete(id);
            return ResponseEntity.ok().build();
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Event not found!");
        }
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Event updatedEvent) {
        try {
            eventService.update(updatedEvent);
            return ResponseEntity.ok().build();
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can not do update!");

        }

    }




}
