package spring.AnnotationBeanScope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("myCoachBeanScope")
@Scope("prototype")
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

	public FortuneServiceInterface getFortuneService(){
		return fortuneService;
	}
}










