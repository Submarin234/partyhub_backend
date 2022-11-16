package com.submarin.partyhub.service;

import com.submarin.partyhub.domain.Event;

import java.util.List;

public interface EventService {
    Event findByName(String name);

    Event findById(Long id);

    List<Event> findAll();

    Event add(Event event);

    void delete(Long id);

    void update(Event updatedEvent);
}
