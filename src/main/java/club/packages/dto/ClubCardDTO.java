package club.packages.dto;

public class ClubCardDTO {
    private Long id;
    private String name;
    private String missionSnippet;

    public ClubCardDTO() {}

    public ClubCardDTO(Long id, String name, String missionSnippet) {
        this.id = id;
        this.name = name;
        this.missionSnippet = missionSnippet;
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

    public String getMissionSnippet() {
        return missionSnippet;
    }

    public void setMissionSnippet(String missionSnippet) {
        this.missionSnippet = missionSnippet;
    }
}
