package com.ClubsManagementSystem.NewHomePage.Services;

import com.ClubsManagementSystem.NewHomePage.Models.Club;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClubService {
    private final List<Club> clubs = new ArrayList<>();

    public ClubService() {
        // sample data matching the homepage attachment
        clubs.add(new Club(1L, "Eagles Club", "Has successful project", 42));
        clubs.add(new Club(2L, "IEEE-NU", "Organised a coding workshop", 36));
        clubs.add(new Club(3L, "Music Club", "Register a mallionary", 18));
        clubs.add(new Club(4L, "Art Club", "Coordinated the annual fair", 25));
    }

    public List<Club> getTopClubs() {
        // return top 4 (already prepared)
        return new ArrayList<>(clubs);
    }

    public List<Club> getAllClubs() {
        return new ArrayList<>(clubs);
    }

    public Optional<Club> getById(Long id) {
        return clubs.stream().filter(c -> c.getId().equals(id)).findFirst();
    }
}
