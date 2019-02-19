package spring.DependencyInjectionAdvancedSetter;

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
		theCoach.setEmail("tesmail@testdomain.com");
		theCoach.setTeam("My awesome Team");
		
		// use the object
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getEmail());
		System.out.println(theCoach.getTeam());
	}

}
