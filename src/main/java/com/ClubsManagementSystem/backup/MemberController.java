package com.ClubsManagementSystem.backup;

// Backup copy of MemberController; moved out of component-scan for safekeeping.
import com.ClubsManagementSystem.NewHomePage.Models.Highlight;
import com.ClubsManagementSystem.NewHomePage.Services.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/members")
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
