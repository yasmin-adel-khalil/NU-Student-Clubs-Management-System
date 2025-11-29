package club.packages.dto;

import java.util.List;

public class ClubProfileDTO {
    private Long id;
    private String name;
    private String mission;
    private String history;
    private List<String> committees;
    private List<String> media;
    private List<String> events;
    private boolean showApply;

    public ClubProfileDTO() {}

    public ClubProfileDTO(Long id, String name, String mission, String history, List<String> committees, List<String> media, List<String> events, boolean showApply) {
        this.id = id;
        this.name = name;
        this.mission = mission;
        this.history = history;
        this.committees = committees;
        this.media = media;
        this.events = events;
        this.showApply = showApply;
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

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public List<String> getCommittees() {
        return committees;
    }

    public void setCommittees(List<String> committees) {
        this.committees = committees;
    }

    public List<String> getMedia() {
        return media;
    }

    public void setMedia(List<String> media) {
        this.media = media;
    }

    public List<String> getEvents() {
        return events;
    }

    public void setEvents(List<String> events) {
        this.events = events;
    }

    public boolean isShowApply() {
        return showApply;
    }

    public void setShowApply(boolean showApply) {
        this.showApply = showApply;
    }
}
