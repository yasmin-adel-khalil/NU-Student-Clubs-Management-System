package club.packages.controller;

import club.packages.dto.ClubCardDTO;
import club.packages.dto.ClubProfileDTO;
import club.packages.service.ClubService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/clubs")
@Tag(name = "Clubs", description = "APIs for club directory and profiles")
public class ClubController {

    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping
    @Operation(summary = "List clubs", description = "Search and filter clubs. Supports pagination via page & size.")
    public ResponseEntity<List<ClubCardDTO>> listClubs(
            @Parameter(description = "Search term applied to name and mission") @RequestParam(required = false) String search,
            @Parameter(description = "Filter by committee name") @RequestParam(required = false) String committee,
            @Parameter(description = "Filter by event name") @RequestParam(required = false) String event,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {

        List<ClubCardDTO> results = clubService.searchClubs(search, committee, event, page, size);
        return ResponseEntity.ok(results);
    }

    @GetMapping("/{clubId}")
    @Operation(summary = "Get club profile", description = "Returns detailed club profile including mission, history, committees, media and events. Includes whether Apply button should be shown based on authentication.")
    public ResponseEntity<ClubProfileDTO> getClub(
            @Parameter(description = "Club id") @PathVariable Long clubId,
            HttpServletRequest request) {

        boolean authenticated = request.getUserPrincipal() != null;
        ClubProfileDTO dto = clubService.getClubById(clubId, authenticated);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }
}
