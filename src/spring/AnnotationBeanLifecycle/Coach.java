package spring.AnnotationBeanLifecycle;

public interface Coach {

	public String getDailyWorkout();
	public String getDailyFortune();

	public FortuneServiceInterface getFortuneService();
	
}
