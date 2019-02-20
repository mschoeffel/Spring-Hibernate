package spring.AnnotationConstructorDI;

public class BaseballCoach implements Coach {

	private FortuneServiceInterface fortuneService;

	public BaseballCoach(FortuneServiceInterface fortuneService){
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








