package spring.AnnotationFieldDI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myCoachField")
public class TrackCoach implements Coach {

	@Autowired
	private FortuneServiceInterface fortuneService;


	public TrackCoach(){
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}










