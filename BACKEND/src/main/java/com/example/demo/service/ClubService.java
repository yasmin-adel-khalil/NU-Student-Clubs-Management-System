package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Club;
import com.example.demo.repository.ClubRepository;

@Service
public class ClubService {

    private final ClubRepository repo;

    public ClubService(ClubRepository repo) {
        this.repo = repo;
    }

    public List<Club> getAllClubs() {
        return repo.findAll();
    }

    public Club getClubById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Club createClub(Club club) {
        return repo.save(club);
    }

    public Club updateClub(Long id, Club clubDetails) {
        Club club = repo.findById(id).orElse(null);
        if (club != null) {
            club.setName(clubDetails.getName());
            club.setDescription(clubDetails.getDescription());
            return repo.save(club);
        }
        return null;
    }

    public void deleteClub(Long id) {
        repo.deleteById(id);
    }
}
