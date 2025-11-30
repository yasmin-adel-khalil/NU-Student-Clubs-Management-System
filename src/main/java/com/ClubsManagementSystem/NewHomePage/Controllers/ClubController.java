package com.ClubsManagementSystem.NewHomePage.Controllers;

import com.ClubsManagementSystem.NewHomePage.Models.Club;
import com.ClubsManagementSystem.NewHomePage.Services.ClubService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// Disabled: moved to backup package. Controller is kept here as a non-annotated class for reference.
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public class ClubController {

    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping
    public List<Club> listClubs() {
        return clubService.getAllClubs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Club> getClub(@PathVariable Long id) {
        return clubService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
