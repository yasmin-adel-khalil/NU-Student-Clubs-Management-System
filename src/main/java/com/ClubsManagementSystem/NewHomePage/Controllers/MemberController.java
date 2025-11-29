package com.ClubsManagementSystem.NewHomePage.Controllers;

import com.ClubsManagementSystem.NewHomePage.Models.Highlight;
import com.ClubsManagementSystem.NewHomePage.Services.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
// Disabled: moved to backup package. Controller is kept here as a non-annotated class for reference.
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/highlights")
    public List<Highlight> highlights() {
        return memberService.getHighlights();
    }
}
