package club.packages.service;

import club.packages.dto.ClubCardDTO;
import club.packages.dto.ClubProfileDTO;
import club.packages.model.Club;
import club.packages.repository.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubCardDTO> searchClubs(String search, String committee, String event, int page, int size) {
        List<Club> all = clubRepository.findAll();
        return all.stream()
                .filter(c -> {
                    boolean matches = true;
                    if (search != null && !search.isBlank()) {
                        String s = search.toLowerCase();
                        matches = c.getName() != null && c.getName().toLowerCase().contains(s)
                                || c.getMission() != null && c.getMission().toLowerCase().contains(s);
                    }
                    if (matches && committee != null && !committee.isBlank()) {
                        matches = c.getCommittees().stream().anyMatch(x -> x.equalsIgnoreCase(committee));
                    }
                    if (matches && event != null && !event.isBlank()) {
                        matches = c.getEvents().stream().anyMatch(x -> x.equalsIgnoreCase(event));
                    }
                    return matches;
                })
                .skip((long) page * size)
                .limit(size)
                .map(c -> new ClubCardDTO(c.getId(), c.getName(), snippet(c.getMission())))
                .collect(Collectors.toList());
    }

    @Override
    public List<ClubCardDTO> filterClubs(String committee, String event, int page, int size) {
        return searchClubs(null, committee, event, page, size);
    }

    @Override
    public ClubProfileDTO getClubById(Long id, boolean authenticated) {
        Optional<Club> opt = clubRepository.findById(id);
        if (opt.isEmpty()) return null;
        Club c = opt.get();
        return new ClubProfileDTO(c.getId(), c.getName(), c.getMission(), c.getHistory(), c.getCommittees(), c.getMedia(), c.getEvents(), authenticated);
    }

    @Override
    public Club save(Club club) {
        return clubRepository.save(club);
    }

    private String snippet(String s) {
        if (s == null) return "";
        return s.length() <= 140 ? s : s.substring(0, 137) + "...";
    }
}
