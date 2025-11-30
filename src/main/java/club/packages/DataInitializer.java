package club.packages;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import club.packages.model.Club;
import club.packages.repository.ClubRepository;

import java.util.List;

@Component
public class DataInitializer implements ApplicationRunner {

	private final ClubRepository clubRepository;

	public DataInitializer(ClubRepository clubRepository) {
		this.clubRepository = clubRepository;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// Only seed when repository is empty
		if (clubRepository.count() > 0) {
			return;
		}

		Club chess = new Club("Chess Club",
				"Provide opportunities to learn and play chess for all students.",
				"Founded in 2010, the Chess Club meets weekly to play and host tournaments.");
		chess.getCommittees().addAll(List.of("Executive", "Events"));
		chess.getMedia().addAll(List.of("facebook.com/chessclub", "@chessclub"));
		chess.getEvents().addAll(List.of("Weekly Match", "Spring Tournament"));

		Club robotics = new Club("Robotics Club",
				"Build robots and compete in regional competitions.",
				"Started as a student project group and grew into an official society.");
		robotics.getCommittees().addAll(List.of("Core", "Outreach"));
		robotics.getMedia().addAll(List.of("youtube.com/roboticsclub"));
		robotics.getEvents().addAll(List.of("Workshop", "Regional Competition"));

		clubRepository.save(chess);
		clubRepository.save(robotics);
	}
}
