package org.azamat.spring.validator;

import org.azamat.spring.annotation.IsValidFirstName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class FirstNameValidator implements ConstraintValidator<IsValidFirstName, String> {

    @Override
    public void initialize(IsValidFirstName constraintAnnotation) {
        constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String firstName, ConstraintValidatorContext constraintValidatorContext) {
        if (firstName == null)
            return false;
        return Pattern.matches("[a-zA-Z]+", firstName);
    }
}
