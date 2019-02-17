package spring.DependencyInjectionSetter;

public interface Coach {

	public String getDailyWorkout();
	public String getDailyFortune();

	public void setFortuneService(FortuneServiceInterface fortuneService);
	
}
