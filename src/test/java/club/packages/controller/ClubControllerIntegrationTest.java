package club.packages.controller;

import club.packages.dto.ClubCardDTO;
import club.packages.dto.ClubProfileDTO;
import club.packages.service.ClubService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ClubController.class, excludeAutoConfiguration = {org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class, org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class})
class ClubControllerIntegrationTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    ClubService clubService;

    @Test
    void listClubs_returnsJsonArray() throws Exception {
        ClubCardDTO c = new ClubCardDTO(1L, "Chess Club", "We play chess");
        Mockito.when(clubService.searchClubs(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(Arrays.asList(c));

        mvc.perform(get("/clubs").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Chess Club"));
    }

    @Test
    void getClub_returnsProfile() throws Exception {
        ClubProfileDTO dto = new ClubProfileDTO(2L, "Art", "M", "H", Arrays.asList("x"), Arrays.asList("m"), Arrays.asList("e"), false);
    Mockito.when(clubService.getClubById(Mockito.eq(2L), Mockito.anyBoolean())).thenReturn(dto);

        mvc.perform(get("/clubs/2").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Art"));
    }
}
