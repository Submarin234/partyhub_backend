package com.submarin.partyhub.service.implementation;

import com.submarin.partyhub.domain.Event;
import com.submarin.partyhub.service.EventService;

import java.util.ArrayList;
import java.util.List;

// TODO: 11/16/2022
public class EventServiceImpl implements EventService {

    @Override
    public Event findByName(String name) {
        return new Event(1L,"event");
    }

    @Override
    public Event findById(Long id) {
        return null;
    }

    @Override
    public List<Event> findAll() {
        Event event1=new Event(2L,"e1");
        Event event2=new Event(2L,"e2");
        List<Event> list=new ArrayList<>();
        list.add(event1);
        list.add(event2);
        return list;
    }

    @Override
    public Event add(Event event) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Event updatedEvent) {

    }
}
