package com.ClubsManagementSystem.NewHomePage.Services;

import com.ClubsManagementSystem.NewHomePage.Models.Event;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {
    private final List<Event> events = new ArrayList<>();

    public EventService() {
        events.add(new Event(1L, "Coding Workshop", "2025-12-10", "Auditorium", "Organised a coding workshop"));
        events.add(new Event(2L, "Annual Fair", "2026-01-22", "Main Lawn", "Coordinated the annual fair"));
        events.add(new Event(3L, "Music Night", "2025-11-30", "Hall B", "Live performances by the Music Club"));
    }

    public List<Event> getUpcomingEvents() {
        return new ArrayList<>(events);
    }
}
