package com.NUClubs.login.signup.Controllers;

import com.NUClubs.login.signup.Models.Highlight;
import com.NUClubs.login.signup.Services.MemberService;
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
