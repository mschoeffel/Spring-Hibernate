package spring.AnnotationBeanPropertiesDI;

import org.springframework.beans.factory.annotation.Value;

public class TrackCoach implements Coach {

	private FortuneServiceInterface fortuneService;

	@Value("${coachProp.email}")
	private String email;
	@Value("${coachProp.team}")
	private String team;


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

	public FortuneServiceInterface getFortuneService(){
		return fortuneService;
	}

	public String getTeam() {
		return team;
	}

	public String getEmail() {
		return email;
	}
}










