package com.ClubsManagementSystem.backup;

// Backup copy of ClubController; moved out of component-scan for safekeeping.
import com.ClubsManagementSystem.NewHomePage.Models.Club;
import com.ClubsManagementSystem.NewHomePage.Services.ClubService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clubs")
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
