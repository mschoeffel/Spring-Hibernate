package spring.DependencyInjectionSetter;

public class BaseballCoach implements Coach {

	private FortuneServiceInterface fortuneService;

	@Override
	public void setFortuneService(FortuneServiceInterface fortuneService){
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}








