package com.example.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Club;
import com.example.demo.model.Member;
import com.example.demo.repository.ClubRepository;
import com.example.demo.repository.MemberRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final ClubRepository clubRepository;
    private final MemberRepository memberRepository;

    public DataLoader(ClubRepository clubRepository, MemberRepository memberRepository) {
        this.clubRepository = clubRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create clubs
        Club club1 = new Club(1L, "Computer Science Club", "Club for CS enthusiasts");
        Club club2 = new Club(2L, "Debate Club", "Public speaking and debate");
        Club club3 = new Club(3L, "Photography Club", "Photography and visual arts");
        Club club4 = new Club(4L, "Music Club", "Music and performing arts");

        clubRepository.save(club1);
        clubRepository.save(club2);
        clubRepository.save(club3);
        clubRepository.save(club4);

        // Create members for Computer Science Club
        memberRepository.save(new Member(1L, "Ahmed Hassan", "President", 95, club1));
        memberRepository.save(new Member(2L, "Fatima Ali", "Vice President", 92, club1));
        memberRepository.save(new Member(3L, "Omar Mohamed", "Treasurer", 88, club1));
        memberRepository.save(new Member(4L, "Noor Khalid", "Secretary", 85, club1));
        memberRepository.save(new Member(5L, "Sara Ibrahim", "Member", 80, club1));

        // Create members for Debate Club
        memberRepository.save(new Member(6L, "Mariam Rashid", "President", 93, club2));
        memberRepository.save(new Member(7L, "Hassan Karim", "Vice President", 90, club2));
        memberRepository.save(new Member(8L, "Layla Noor", "Member", 87, club2));
        memberRepository.save(new Member(9L, "Zainab Mustafa", "Member", 84, club2));

        // Create members for Photography Club
        memberRepository.save(new Member(10L, "Karim Saeed", "President", 91, club3));
        memberRepository.save(new Member(11L, "Hana Waleed", "Vice President", 89, club3));
        memberRepository.save(new Member(12L, "Rania Hassan", "Member", 86, club3));

        // Create members for Music Club
        memberRepository.save(new Member(13L, "Amira Saleh", "President", 94, club4));
        memberRepository.save(new Member(14L, "Youssef Adel", "Vice President", 91, club4));
        memberRepository.save(new Member(15L, "Dina Mansour", "Member", 82, club4));
        memberRepository.save(new Member(16L, "Tarek Jamal", "Member", 79, club4));

        System.out.println("Sample data loaded successfully!");
    }
}
