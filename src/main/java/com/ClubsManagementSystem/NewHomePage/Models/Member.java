package com.ClubsManagementSystem.NewHomePage.Models;

public class Member {
    private Long id;
    private String name;
    private String role;
    private String major;
    private String avatarUrl;

    public Member() {
    }

    public Member(Long id, String name, String role, String major, String avatarUrl) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.major = major;
        this.avatarUrl = avatarUrl;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
