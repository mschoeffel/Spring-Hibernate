package spring.MVC;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CustomAnnotationValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotation {

    public String value() default "CUS";

    public String message() default "must start with CUS";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
