package club.packages.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import club.packages.dto.ClubCardDTO;
import club.packages.dto.ClubProfileDTO;
import club.packages.model.Club;
import club.packages.repository.ClubRepository;

class ClubServiceTest {

    private ClubRepository repo;
    private ClubServiceImpl service;

    @BeforeEach
    void setup() {
        repo = Mockito.mock(ClubRepository.class);
        service = new ClubServiceImpl(repo);
    }

    @Test
    void searchClubs_matchesNameAndMission() {
        Club a = new Club("Chess Club", "We play chess", "History");
        a.setId(1L);
        Club b = new Club("Art Society", "Painting and drawing", "History");
        b.setId(2L);
        Mockito.when(repo.findAll()).thenReturn(Arrays.asList(a, b));

        List<ClubCardDTO> res = service.searchClubs("chess", null, null, 0, 10);
        assertThat(res).hasSize(1);
        assertThat(res.get(0).getName()).isEqualTo("Chess Club");
    }

    @Test
    void getClubById_returnsProfileWithAuthFlag() {
        Club c = new Club("Chess Club", "Mission text", "Long history");
        c.setId(5L);
        c.setCommittees(Arrays.asList("Exec", "Events"));
        Mockito.when(repo.findById(5L)).thenReturn(Optional.of(c));

        ClubProfileDTO dto = service.getClubById(5L, true);
        assertThat(dto).isNotNull();
        assertThat(dto.getName()).isEqualTo("Chess Club");
        assertThat(dto.isShowApply()).isTrue();
    }
}
