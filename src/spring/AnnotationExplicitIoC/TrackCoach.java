package spring.AnnotationExplicitIoC;

import org.springframework.stereotype.Component;

@Component("myCoach")
public class TrackCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}
}