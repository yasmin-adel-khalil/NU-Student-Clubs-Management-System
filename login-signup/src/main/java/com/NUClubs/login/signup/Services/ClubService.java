package com.NUClubs.login.signup.Services;

import com.NUClubs.login.signup.Models.Club;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClubService {
    private final List<Club> clubs = new ArrayList<>();

    public ClubService() {
        // sample data matching the homepage attachment
        clubs.add(new Club(1L, "ICPC", "Organized a Coding Competition", 60));
        clubs.add(new Club(2L, "IEEE-NU", "Accomplished a Computer Society", 50));
        clubs.add(new Club(3L, "NIMUN", "Coordinated the annual fair", 18));
        clubs.add(new Club(4L, "Book Club", "Coordinated a huge book fair", 25));
        clubs.add(new Club(5L, "Wesal", "Coordinated huge Ramadan Iftar", 25));
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
