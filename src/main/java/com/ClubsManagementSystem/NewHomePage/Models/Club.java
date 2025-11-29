package com.ClubsManagementSystem.NewHomePage.Models;

public class Club {
    private Long id;
    private String name;
    private String description;
    private int activeMembers;

    public Club() {
    }

    public Club(Long id, String name, String description, int activeMembers) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.activeMembers = activeMembers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getActiveMembers() {
        return activeMembers;
    }

    public void setActiveMembers(int activeMembers) {
        this.activeMembers = activeMembers;
    }
}
