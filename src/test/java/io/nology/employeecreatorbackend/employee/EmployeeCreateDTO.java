package io.nology.employeecreatorbackend.employee;

import io.nology.shared.constraints.ValidAustralianMobileNumber;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmployeeCreateDTO {

  @NotBlank
  String firstName;

  String middleName;

  @NotBlank
  String lastName;

  @NotBlank
  @ValidAustralianMobileNumber
  String mobileNumber;

  @Email
  String email;
}
