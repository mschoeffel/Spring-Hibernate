package spring.AnnotationQualifierDI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myCoachQualifier")
public class TrackCoach implements Coach {

	@Autowired
	@Qualifier("FortuneServiceQualifier1")
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










