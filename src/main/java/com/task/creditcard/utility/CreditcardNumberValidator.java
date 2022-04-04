package com.task.creditcard.utility;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CreditcardNumberValidation.class)
public @interface CreditcardNumberValidator {

	String message() default "{validate.creditcardnum}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
