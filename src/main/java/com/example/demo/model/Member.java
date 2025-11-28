package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Member {
    @Id
    private Long id;
    private String name;
    private String role;
    private int score; // to rank best members

    @ManyToOne
    @JoinColumn(name = "club_id")
    @JsonBackReference
    private Club club;

    public Member() {}

    public Member(Long id, String name, String role, int score, Club club) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.score = score;
        this.club = club;
    }

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public Club getClub() { return club; }
    public void setClub(Club club) { this.club = club; }
}
