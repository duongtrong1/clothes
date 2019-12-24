package com.smartosc.ecommerce.clothes.util.name;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpecialCharacterValidator implements ConstraintValidator<NotContainSpecialCharacter, String> {
    @Override
    public void initialize(NotContainSpecialCharacter constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !isSpecialCharacter(value);
    }

    private static boolean isSpecialCharacter(String value) {
        Pattern special = Pattern.compile("[!@#$%&*()+=|<>?{}\\[\\]~-]");
        Matcher hasSpecial = special.matcher(value);
        return hasSpecial.find();
    }
}
