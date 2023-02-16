package io.nology.shared.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AustralianMobileNumberValidator
  implements ConstraintValidator<ValidAustralianMobileNumber, String> {

  public static final String MOBILE_NUMBER_REGEX = "^((\\+61)|(0))4\\d{8}$";

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }
    return value.matches(MOBILE_NUMBER_REGEX);
  }
}
