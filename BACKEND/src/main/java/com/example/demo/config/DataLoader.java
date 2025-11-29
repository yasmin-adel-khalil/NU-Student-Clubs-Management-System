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
        // Create IEEE NU Branch club with committees
        Club ieee = new Club(null, "IEEE NU Branch", "IEEE student branch at NU - multiple committees");
        clubRepository.save(ieee);

        // Create members for IEEE NU Branch - 5 committees: PR, HR, Operations, Marketing, Media
        // For each committee create one mid-season best and one end-season best (10 members)
        memberRepository.save(new Member("Salma Nasser", "Best Mid", "PR", 96, com.example.demo.model.SeasonType.MID, ieee));
        memberRepository.save(new Member("Yara Fathy", "Best End", "PR", 94, com.example.demo.model.SeasonType.END, ieee));

        memberRepository.save(new Member("Mohamed Sami", "Best Mid", "HR", 95, com.example.demo.model.SeasonType.MID, ieee));
        memberRepository.save(new Member("Noha Adel", "Best End", "HR", 93, com.example.demo.model.SeasonType.END, ieee));

        memberRepository.save(new Member("Khaled Omar", "Best Mid", "Operations", 97, com.example.demo.model.SeasonType.MID, ieee));
        memberRepository.save(new Member("Lina Samir", "Best End", "Operations", 92, com.example.demo.model.SeasonType.END, ieee));

        memberRepository.save(new Member("Omar Saad", "Best Mid", "Marketing", 94, com.example.demo.model.SeasonType.MID, ieee));
        memberRepository.save(new Member("Mona Elshamy", "Best End", "Marketing", 90, com.example.demo.model.SeasonType.END, ieee));

        memberRepository.save(new Member("Ibrahim Hany", "Best Mid", "Media", 95, com.example.demo.model.SeasonType.MID, ieee));
        memberRepository.save(new Member("Dalia Mostafa", "Best End", "Media", 91, com.example.demo.model.SeasonType.END, ieee));

        System.out.println("Sample data loaded successfully!");
    }
}
