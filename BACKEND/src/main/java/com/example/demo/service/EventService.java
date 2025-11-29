package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Event;
import com.example.demo.repository.EventRepository;

@Service
public class EventService {

    private final EventRepository repo;

    public EventService(EventRepository repo) {
        this.repo = repo;
    }

    public List<Event> getAllEvents() {
        return repo.findAll();
    }

    public Event getEventById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Event createEvent(Event event) {
        return repo.save(event);
    }

    public Event updateEvent(Long id, Event eventDetails) {
        Event event = repo.findById(id).orElse(null);
        if (event != null) {
            event.setName(eventDetails.getName());
            event.setDate(eventDetails.getDate());
            event.setPlace(eventDetails.getPlace());
            event.setDescription(eventDetails.getDescription());
            return repo.save(event);
        }
        return null;
    }

    public void deleteEvent(Long id) {
        repo.deleteById(id);
    }
}
