package org.azamat.spring.annotation;

import org.azamat.spring.validator.EmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidEmail {
    String message() default "enter ur email";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
