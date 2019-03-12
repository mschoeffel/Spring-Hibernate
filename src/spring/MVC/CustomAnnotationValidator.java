package spring.MVC;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomAnnotationValidator implements ConstraintValidator<CustomAnnotation, String> {

    private String prefix;

    @Override
    public void initialize(CustomAnnotation annotation){
        prefix = annotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = false;

        if(s != null){
            result = s.startsWith(prefix);
        } else{
            result = true;
        }
        return result;
    }
}
