package com.task.creditcard.utility;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CreditcardNumberValidation implements ConstraintValidator<CreditcardNumberValidator, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return CreditcardValidation.isValidCreditCardNumber(value);
	}

}
