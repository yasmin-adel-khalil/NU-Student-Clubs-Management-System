package club.packages.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 2000)
    private String mission;

    @Column(length = 5000)
    private String history;

    @ElementCollection
    @CollectionTable(name = "club_committees", joinColumns = @JoinColumn(name = "club_id"))
    @Column(name = "committee")
    private List<String> committees = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "club_media", joinColumns = @JoinColumn(name = "club_id"))
    @Column(name = "media")
    private List<String> media = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "club_events", joinColumns = @JoinColumn(name = "club_id"))
    @Column(name = "event")
    private List<String> events = new ArrayList<>();

    public Club() {
    }

    public Club(String name, String mission, String history) {
        this.name = name;
        this.mission = mission;
        this.history = history;
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
}
