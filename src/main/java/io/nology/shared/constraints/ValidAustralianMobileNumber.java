package io.nology.shared.constraints;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE_USE;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ FIELD, TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AustralianMobileNumberValidator.class)
@Documented
public @interface ValidAustralianMobileNumber {
  String message() default "Invalid Mobile Number";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
