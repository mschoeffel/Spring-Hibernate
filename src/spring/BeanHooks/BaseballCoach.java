package spring.BeanHooks;

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

	@Override
	public void initMyObject(){
		System.out.println("Object ini successful");
	}

	@Override
	public void closeMyObject(){
		System.out.println("Object is closed successfully");
	}

}








