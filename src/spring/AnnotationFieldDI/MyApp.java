package spring.AnnotationFieldDI;

/**
 * This class does the same as the "HelloSpringApp" class, but without the Spring Framework.
 */
public class MyApp {

	public static void main(String[] args) {

		// first create a fortune service for the dependency of the coach
		FortuneServiceInterface fortuneService = new HappyFortuneService();

		// create the object with the dependency
		Coach theCoach = new TrackCoach();

		// set the fortune service
		//((TrackCoach) theCoach).setFortuneService(fortuneService);
		
		// use the object
		System.out.println(theCoach.getDailyWorkout());
		//System.out.println(theCoach.getDailyFortune());
	}

}
