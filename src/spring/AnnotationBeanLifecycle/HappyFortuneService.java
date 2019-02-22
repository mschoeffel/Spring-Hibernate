package spring.AnnotationBeanLifecycle;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("FortuneServiceBeanHook")
public class HappyFortuneService implements FortuneServiceInterface {

    @Override
    public String getFortune() {
        return "Today is a lucky day!";
    }
}
