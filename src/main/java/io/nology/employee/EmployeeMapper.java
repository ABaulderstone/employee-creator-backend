package io.nology.employee;

import io.nology.shared.mappers.BaseDecorator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = BaseDecorator.class)
public interface EmployeeMapper {
  @Mapping(source = "firstName", target = "firstName", qualifiedByName = "trim")
  @Mapping(
    source = "middleName",
    target = "middleName",
    qualifiedByName = "trim"
  )
  @Mapping(source = "lastName", target = "lastName", qualifiedByName = "trim")
  @Mapping(source = "email", target = "email", qualifiedByName = "trim")
  @Mapping(
    source = "mobileNumber",
    target = "mobileNumber",
    qualifiedByName = { "trim", "convertMobileFormat" }
  )
  Employee createDtoToEmployee(EmployeeCreateDTO dto);

  default String convertMobileFormat(String mobileNumber) {
    if (mobileNumber == null) {
      return null;
    }
    if (!mobileNumber.startsWith("0") && !mobileNumber.startsWith("+61")) {
      mobileNumber = "0" + mobileNumber;
    } else if (mobileNumber.startsWith("+61")) {
      mobileNumber = "0" + mobileNumber.substring(3);
    }

    return mobileNumber;
  }
}
