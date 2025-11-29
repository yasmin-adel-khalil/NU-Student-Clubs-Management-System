package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Club;
import com.example.demo.model.Member;
import com.example.demo.model.SeasonType;
import com.example.demo.repository.ClubRepository;
import com.example.demo.service.MemberService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private ClubRepository clubRepository;

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/best")
    public List<Member> getBestMembers() {
        return memberService.getBestMembers();
    }

    @GetMapping("/club/{clubId}/best")
    public List<Member> getBestMembersByClub(@PathVariable Long clubId) {
        Club club = clubRepository.findById(clubId).orElse(null);
        if (club != null) {
            return memberService.getBestMembersByClub(club);
        }
        return List.of();
    }

    @GetMapping("/club/{clubId}")
    public List<Member> getMembersByClub(@PathVariable Long clubId) {
        Club club = clubRepository.findById(clubId).orElse(null);
        if (club != null) {
            return memberService.getMembersByClub(club);
        }
        return List.of();
    }

    @GetMapping("/club/{clubId}/bests/mid")
    public List<Member> getMidSeasonBests(@PathVariable Long clubId) {
        System.out.println("GET /members/club/" + clubId + "/bests/mid called");
        List<Member> result = memberService.getBestMembersByClubAndSeason(clubId, SeasonType.MID);
        System.out.println("Returning " + result.size() + " mid-season members");
        return result;
    }

    @GetMapping("/club/{clubId}/bests/end")
    public List<Member> getEndSeasonBests(@PathVariable Long clubId) {
        System.out.println("GET /members/club/" + clubId + "/bests/end called");
        List<Member> result = memberService.getBestMembersByClubAndSeason(clubId, SeasonType.END);
        System.out.println("Returning " + result.size() + " end-season members");
        return result;
    }

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody Member memberDetails) {
        return memberService.updateMember(id, memberDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }
}
