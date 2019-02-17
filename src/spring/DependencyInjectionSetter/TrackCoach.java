package spring.DependencyInjectionSetter;

public class TrackCoach implements Coach {

	private FortuneServiceInterface fortuneService;

	@Override
	public void setFortuneService(FortuneServiceInterface fortuneService){
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










