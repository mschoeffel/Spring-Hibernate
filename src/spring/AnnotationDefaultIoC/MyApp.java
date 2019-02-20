package spring.AnnotationDefaultIoC;

/**
 * This class does the same as the "HelloSpringApp" class, but without the Spring Framework.
 */
public class MyApp {

	public static void main(String[] args) {

		// create the object
		Coach theCoach = new TrackCoach();

		// use the object
		System.out.println(theCoach.getDailyWorkout());
	}

}