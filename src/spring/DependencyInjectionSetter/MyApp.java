package spring.DependencyInjectionSetter;

/**
 * This class does the same as the "HelloSpringApp" class, but without the Spring Framework.
 */
public class MyApp {

	public static void main(String[] args) {

		// create the object
		Coach theCoach = new TrackCoach();

		// first create a fortune service
		FortuneServiceInterface fortuneService = new HappyFortuneService();

		// set the dependency of the object
		theCoach.setFortuneService(fortuneService);
		
		// use the object
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
	}

}
