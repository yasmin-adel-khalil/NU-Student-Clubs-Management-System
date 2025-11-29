package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Club;
import com.example.demo.model.Member;
import com.example.demo.model.SeasonType;
import com.example.demo.repository.MemberRepository;

@Service
public class MemberService {

    private final MemberRepository repo;

    public MemberService(MemberRepository repo) {
        this.repo = repo;
    }

    public List<Member> getBestMembers() {
        return repo.findTop5ByOrderByScoreDesc();
    }

    public List<Member> getAllMembers() {
        return repo.findAll();
    }

    public List<Member> getBestMembersByClub(Club club) {
        return repo.findTop5ByClubOrderByScoreDesc(club);
    }

    public List<Member> getMembersByClub(Club club) {
        return repo.findByClubOrderByScoreDesc(club);
    }

    public List<Member> getBestMembersByClubAndSeason(Long clubId, SeasonType season) {
        List<Member> members = repo.findByClubIdAndSeason(clubId, season);
        // pick the top (highest score) member per committee
        java.util.Map<String, Member> bestPerCommittee = new java.util.HashMap<>();
        for (Member m : members) {
            String committee = m.getCommittee() == null ? "Unknown" : m.getCommittee();
            Member current = bestPerCommittee.get(committee);
            if (current == null || m.getScore() > current.getScore()) {
                bestPerCommittee.put(committee, m);
            }
        }
        return new java.util.ArrayList<>(bestPerCommittee.values());
    }

    public Member createMember(Member member) {
        return repo.save(member);
    }

    public Member updateMember(Long id, Member memberDetails) {
        Member member = repo.findById(id).orElse(null);
        if (member != null) {
            member.setName(memberDetails.getName());
            member.setRole(memberDetails.getRole());
            member.setScore(memberDetails.getScore());
            member.setClub(memberDetails.getClub());
            return repo.save(member);
        }
        return null;
    }

    public void deleteMember(Long id) {
        repo.deleteById(id);
    }
}
