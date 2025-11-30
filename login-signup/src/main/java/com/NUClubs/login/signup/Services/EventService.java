package com.NUClubs.login.signup.Services;

import com.NUClubs.login.signup.Models.Event;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {
    private final List<Event> events = new ArrayList<>();

    public EventService() {
        events.add(new Event(1L, "Coding Workshop", "2025-12-10", "Tarek Khalil - Room 127", "Organised a coding workshop"));
        events.add(new Event(2L, "Annual Fair", "2026-01-22", "Roman Theatre", "Coordinated the annual fair"));
        events.add(new Event(3L, "Movie Night", "2025-11-30", "Tarek Khalil Garden", "Watch, relax, and enjoy!"));
    }

    public List<Event> getUpcomingEvents() {
        return new ArrayList<>(events);
    }
}
