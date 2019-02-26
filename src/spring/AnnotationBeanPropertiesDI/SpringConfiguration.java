package spring.AnnotationBeanPropertiesDI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:coachConfig.properties")
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
