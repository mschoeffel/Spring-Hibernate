package spring.AnnotationBeanLifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("myCoachBeanHook")
public class TrackCoach implements Coach {

	@Autowired
	private FortuneServiceInterface fortuneService;


	public TrackCoach(){
	}

	@PostConstruct
	public void initMethod(){
		System.out.println("Bean init");
	}

	@PreDestroy
	public void closeMethod(){
		System.out.println("Bean close");
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public FortuneServiceInterface getFortuneService(){
		return fortuneService;
	}
}










