package spring.BeanHooks;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * This class shows the way of doing the stuff in Spring Framework.
 */
public class HelloSpringApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanHooks-applicationContext.xml");
				
		// retrieve bean from spring container
		Coach myCoach = context.getBean("myCoachFortuneConstructor", Coach.class);

		System.out.println(myCoach.getDailyWorkout());
		System.out.println(myCoach.getDailyFortune());
		
		// close the context
		context.close();
	}

}







