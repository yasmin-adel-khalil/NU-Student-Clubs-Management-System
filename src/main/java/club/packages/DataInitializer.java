package club.packages;

import club.packages.model.Club;
import club.packages.repository.ClubRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ClubRepository clubRepository;

    public DataInitializer(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        long count = clubRepository.count();
        if (count == 0) {
            // Insert a few sensible default clubs
            Club tech = new Club("Tech Club", "Promote technology literacy and projects.", "Founded to bring together students interested in software and hardware.");
            tech.setCommittees(List.of("Core", "Events", "Outreach"));

            Club art = new Club("Art Club", "Support creative expression and exhibitions.", "Created for students who enjoy drawing, painting and multimedia art.");
            art.setCommittees(List.of("Exhibitions", "Workshops"));

            Club sports = new Club("Sports Club", "Organize intramural and fitness activities.", "Runs regular training and inter-university matches.");
            sports.setCommittees(List.of("Training", "Logistics"));

            clubRepository.saveAll(List.of(tech, art, sports));
            System.out.println("Initialized database with default clubs (3 entries).");
        } else {
            System.out.println("Database already contains " + count + " clubs; skipping initialization.");
        }
    }
}
