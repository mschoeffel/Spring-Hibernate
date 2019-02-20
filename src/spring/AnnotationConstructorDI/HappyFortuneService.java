package spring.AnnotationConstructorDI;

import org.springframework.stereotype.Component;

@Component("FortuneServiceConstructor")
public class HappyFortuneService implements FortuneServiceInterface {

    @Override
    public String getFortune() {
        return "Today is a lucky day!";
    }
}
