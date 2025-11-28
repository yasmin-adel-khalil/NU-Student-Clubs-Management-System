package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Club;
import com.example.demo.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findTop5ByOrderByScoreDesc();
    
    List<Member> findByClubOrderByScoreDesc(Club club);
    
    List<Member> findTop5ByClubOrderByScoreDesc(Club club);
}
