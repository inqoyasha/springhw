package org.azamat.spring.validator;

import org.azamat.spring.annotation.IsValidEmail;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Size;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EmailValidator implements ConstraintValidator<IsValidEmail, String> {

    @Override
    public void initialize(IsValidEmail constraintAnnotation) {
        constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        String emailRegex="^[a-zA-Z0-9]{1,}"+"((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})*"+"@"
                +"[a-zA-Z0-9]{1,}"+"((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})*"+"\\.[a-zA-Z]{2,}$";
        Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        if (email == null)
            return false;
        Matcher matcher = emailPat.matcher(email);
        return matcher.find();
    }
}
