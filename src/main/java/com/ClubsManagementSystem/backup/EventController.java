package com.ClubsManagementSystem.backup;

// Backup copy of EventController; moved out of component-scan for safekeeping.
import com.ClubsManagementSystem.NewHomePage.Models.Event;
import com.ClubsManagementSystem.NewHomePage.Services.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> listEvents() {
        return eventService.getUpcomingEvents();
    }
}
