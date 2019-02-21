package spring.AnnotationQualifierDI;

import org.springframework.stereotype.Component;

@Component("FortuneServiceQualifier2")
public class RandomFortuneService implements FortuneServiceInterface {

    @Override
    public String getFortune() {
        return "Today is a lucky day!";
    }
}
