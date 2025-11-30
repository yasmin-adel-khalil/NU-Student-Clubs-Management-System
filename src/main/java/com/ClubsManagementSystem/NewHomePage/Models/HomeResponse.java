package com.ClubsManagementSystem.NewHomePage.Models;

import java.util.List;

public class HomeResponse {
    private List<Club> topClubs;
    private List<Event> upcomingEvents;
    private List<Highlight> highlights;

    public HomeResponse() {
    }

    public HomeResponse(List<Club> topClubs, List<Event> upcomingEvents, List<Highlight> highlights) {
        this.topClubs = topClubs;
        this.upcomingEvents = upcomingEvents;
        this.highlights = highlights;
    }

    public List<Club> getTopClubs() {
        return topClubs;
    }

    public void setTopClubs(List<Club> topClubs) {
        this.topClubs = topClubs;
    }

    public List<Event> getUpcomingEvents() {
        return upcomingEvents;
    }

    public void setUpcomingEvents(List<Event> upcomingEvents) {
        this.upcomingEvents = upcomingEvents;
    }

    public List<Highlight> getHighlights() {
        return highlights;
    }

    public void setHighlights(List<Highlight> highlights) {
        this.highlights = highlights;
    }
}
