package com.NUClubs.login.signup.Models;

public class Highlight {
    private Long id;
    private String name;
    private String title;
    private String description;
    private String avatarUrl;

    public Highlight() {
    }

    public Highlight(Long id, String name, String title, String description, String avatarUrl) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.description = description;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
