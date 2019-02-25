package spring.AnnotationBeanDI;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * This class shows the way of doing the stuff in Spring Framework.
 * The plain Java way of doing the same is programmed in the "MyApp" class.
 */
public class HelloSpringApp {

	public static void main(String[] args) {

		// load the spring configuration file
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SpringConfiguration.class);
				
		// retrieve bean from spring container
		Coach theCoach = context.getBean("trackCoach", Coach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();
	}

}







