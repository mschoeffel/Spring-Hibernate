package spring.AnnotationBeanDI;

public interface Coach {

	public String getDailyWorkout();
	public String getDailyFortune();

	public FortuneServiceInterface getFortuneService();
	
}
