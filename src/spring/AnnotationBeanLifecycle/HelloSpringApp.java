package spring.AnnotationBeanScope;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * This class shows the way of doing the stuff in Spring Framework.
 * The plain Java way of doing the same is programmed in the "MyApp" class.
 */
public class HelloSpringApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("annotation-applicationContext.xml");
				
		// retrieve bean from spring container
		Coach theCoach1 = context.getBean("myCoachBeanScope", Coach.class);
		Coach theCoach2 = context.getBean("myCoachBeanScope", Coach.class);
		
		// call methods on the bean
		System.out.println(theCoach1 == theCoach2);
		System.out.println(theCoach1.getFortuneService() == theCoach2.getFortuneService());
		
		// close the context
		context.close();
	}

}







