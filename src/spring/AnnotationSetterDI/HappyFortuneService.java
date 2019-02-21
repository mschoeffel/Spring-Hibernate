package spring.AnnotationSetterDI;

import org.springframework.stereotype.Component;

@Component("FortuneServiceSetter")
public class HappyFortuneService implements FortuneServiceInterface {

    @Override
    public String getFortune() {
        return "Today is a lucky day!";
    }
}
