package spring.DependencyInjectionAdvancedSetter;

public interface Coach {

	public String getDailyWorkout();
	public String getDailyFortune();

	public void setFortuneService(FortuneServiceInterface fortuneService);
	public void setEmail(String email);
	public void setTeam(String team);
	public String getEmail();
	public String getTeam();
}
