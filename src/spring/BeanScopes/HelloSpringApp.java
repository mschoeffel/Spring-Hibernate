package spring.BeanScopes;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * This class shows the way of doing the stuff in Spring Framework.
 */
public class HelloSpringApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
				
		// retrieve bean from spring container
		Coach firstCoach = context.getBean("myCoachFortuneConstructor", Coach.class);
		Coach secondCoach = context.getBean("myCoachFortuneConstructor", Coach.class);

		boolean isItTheSame = (firstCoach == secondCoach);

		System.out.println("Without scope attribute: ");
		System.out.println("Are the objects the same (Singleton): " + isItTheSame); //true
		System.out.println("Memory Address 1: " + firstCoach); //memaddress 1
		System.out.println("Memory Address 2: " + secondCoach); //same memaddress 1

		// retrieve bean from spring container
		Coach firstOtherCoach = context.getBean("myOtherCoachFortuneConstructor", Coach.class);
		Coach secoundOtherCoach = context.getBean("myOtherCoachFortuneConstructor", Coach.class);

		isItTheSame = (firstOtherCoach == secoundOtherCoach);

		System.out.println("With scope attribute: ");
		System.out.println("Are the objects the same (Singleton): " + isItTheSame); //false
		System.out.println("Memory Address 1: " + firstOtherCoach); //memaddress 1
		System.out.println("Memory Address 2: " + secoundOtherCoach); //different memaddress
		
		// close the context
		context.close();
	}

}







