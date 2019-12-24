package com.smartosc.ecommerce.clothes.util.name;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = SpecialCharacterValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface NotContainSpecialCharacter {
    String message() default "{Not contain special character}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
