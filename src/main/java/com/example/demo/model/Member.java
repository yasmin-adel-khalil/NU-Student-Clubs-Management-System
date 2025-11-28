package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String role;
    private String committee; // committee name (e.g., PR, HR...)
    private int score; // to rank best members

    @Enumerated(EnumType.STRING)
    private SeasonType season; // MID or END

    @ManyToOne
    @JoinColumn(name = "club_id")
    @JsonBackReference
    private Club club;

    public Member() {}

    public Member(Long id, String name, String role, String committee, int score, SeasonType season, Club club) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.committee = committee;
        this.score = score;
        this.season = season;
        this.club = club;
    }

    // Convenience constructor without ID (auto-generated)
    public Member(String name, String role, String committee, int score, SeasonType season, Club club) {
        this.name = name;
        this.role = role;
        this.committee = committee;
        this.score = score;
        this.season = season;
        this.club = club;
    }

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getCommittee() { return committee; }
    public void setCommittee(String committee) { this.committee = committee; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public SeasonType getSeason() { return season; }
    public void setSeason(SeasonType season) { this.season = season; }

    public Club getClub() { return club; }
    public void setClub(Club club) { this.club = club; }
}
