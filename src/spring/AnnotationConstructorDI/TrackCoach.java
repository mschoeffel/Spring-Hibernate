package spring.AnnotationConstructorDI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myCoachConstructor")
public class TrackCoach implements Coach {

	private FortuneServiceInterface fortuneService;

	@Autowired
	public TrackCoach(FortuneServiceInterface fortuneService){
		this.fortuneService = fortuneService;
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










