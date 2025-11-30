package club.packages;

import club.packages.repository.ClubRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DataInitializerTest {

    @Autowired
    private ClubRepository clubRepository;

    @Test
    void seedsDatabaseWhenEmpty() {
        long count = clubRepository.count();
        // Our initializer inserts 3 default clubs when DB is empty
        assertThat(count).isGreaterThanOrEqualTo(3);
        assertThat(clubRepository.findAll()).extracting("name")
                .contains("Tech Club", "Art Club", "Sports Club");
    }
}
