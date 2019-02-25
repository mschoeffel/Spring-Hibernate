package spring.SpringConfigurationClass;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("FortuneServiceConfig")
public class HappyFortuneService implements FortuneServiceInterface {

    @Override
    public String getFortune() {
        return "Today is a lucky day!";
    }
}
