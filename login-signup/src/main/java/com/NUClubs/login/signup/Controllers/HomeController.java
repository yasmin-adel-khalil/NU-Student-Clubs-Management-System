package com.NUClubs.login.signup.Controllers;

import com.NUClubs.login.signup.Models.HomeResponse;
import com.NUClubs.login.signup.Services.ClubService;
import com.NUClubs.login.signup.Services.EventService;
import com.NUClubs.login.signup.Services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HomeController integrates ClubService, EventService, and MemberService
 * to provide aggregated home page data with top clubs, upcoming events, and member highlights.
 */
@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    private ClubService clubService;

    @Autowired
    private EventService eventService;

    @Autowired
    private MemberService memberService;

    public HomeController() {
    }

    /**
     * GET /api/home
     * Returns HomeResponse containing:
     * - topClubs: list of all clubs (from ClubService)
     * - upcomingEvents: list of upcoming events (from EventService)
     * - highlights: list of member highlights (from MemberService)
     */
    @GetMapping
    public HomeResponse getHome() {
        return new HomeResponse(
                clubService.getTopClubs(),           // Get clubs from ClubService
                eventService.getUpcomingEvents(),    // Get events from EventService
                memberService.getHighlights()        // Get highlights from MemberService
        );
    }
}
