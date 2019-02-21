package spring.AnnotationSetterDI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myCoachSetter")
public class TrackCoach implements Coach {

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

	@Autowired
	public void setFortuneService(FortuneServiceInterface fortuneService) {
		this.fortuneService = fortuneService;
	}
}










