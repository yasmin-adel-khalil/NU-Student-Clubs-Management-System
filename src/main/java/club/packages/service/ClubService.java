package club.packages.service;

import club.packages.dto.ClubCardDTO;
import club.packages.dto.ClubProfileDTO;
import club.packages.model.Club;
import java.util.List;

public interface ClubService {
    List<ClubCardDTO> searchClubs(String search, String committee, String event, int page, int size);

    List<ClubCardDTO> filterClubs(String committee, String event, int page, int size);

    ClubProfileDTO getClubById(Long id, boolean authenticated);

    // For tests and internal usage
    Club save(Club club);
}
