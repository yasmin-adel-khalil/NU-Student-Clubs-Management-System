package com.NUClubs.login.signup.Controllers;

import com.NUClubs.login.signup.Models.Event;
import com.NUClubs.login.signup.Services.EventService;
import org.springframework.web.bind.annotation.GetMapping;
// Disabled: moved to backup package. Controller is kept here as a non-annotated class for reference.
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
