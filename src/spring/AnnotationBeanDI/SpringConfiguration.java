package spring.AnnotationBeanDI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Bean
    public FortuneServiceInterface happyFortuneService(){
        return new HappyFortuneService();
    }

    @Bean
    public Coach trackCoach(){
        TrackCoach trackCoach = new TrackCoach(happyFortuneService());
        return trackCoach;
    }
}
