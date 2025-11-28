package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Club {
    @Id
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "club")
    @JsonManagedReference
    private List<Member> members;

    public Club() {}

    public Club(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<Member> getMembers() { return members; }
    public void setMembers(List<Member> members) { this.members = members; }
}
