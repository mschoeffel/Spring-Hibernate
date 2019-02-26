package spring.AnnotationBeanPropertiesDI;

public interface Coach {

	public String getDailyWorkout();
	public String getDailyFortune();

	public FortuneServiceInterface getFortuneService();

	public String getEmail();
	public String getTeam();
	
}
