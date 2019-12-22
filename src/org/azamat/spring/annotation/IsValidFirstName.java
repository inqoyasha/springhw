package org.azamat.spring.annotation;

import org.azamat.spring.validator.FirstNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FirstNameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidFirstName {
    String message() default "enter ur first name";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
