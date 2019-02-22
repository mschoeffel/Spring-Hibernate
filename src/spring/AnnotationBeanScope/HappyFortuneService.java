package spring.AnnotationBeanScope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("FortuneServiceBeanScope")
@Scope("singleton")
public class HappyFortuneService implements FortuneServiceInterface {

    @Override
    public String getFortune() {
        return "Today is a lucky day!";
    }
}
