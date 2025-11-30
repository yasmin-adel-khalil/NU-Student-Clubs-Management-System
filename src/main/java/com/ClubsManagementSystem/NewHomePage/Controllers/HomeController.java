package com.ClubsManagementSystem.NewHomePage.Controllers;

import com.ClubsManagementSystem.NewHomePage.Models.HomeResponse;
import com.ClubsManagementSystem.NewHomePage.Services.ClubService;
import com.ClubsManagementSystem.NewHomePage.Services.EventService;
import com.ClubsManagementSystem.NewHomePage.Services.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    private final ClubService clubService;
    private final EventService eventService;
    private final MemberService memberService;

    public HomeController(ClubService clubService, EventService eventService, MemberService memberService) {
        this.clubService = clubService;
        this.eventService = eventService;
        this.memberService = memberService;
    }

    @GetMapping
    public HomeResponse getHome() {
        return new HomeResponse(
                clubService.getTopClubs(),
                eventService.getUpcomingEvents(),
                memberService.getHighlights());
    }
}
