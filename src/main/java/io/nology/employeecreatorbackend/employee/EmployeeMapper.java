package io.nology.employeecreatorbackend.employee;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
  @Mapping(
    source = "firstName",
    target = "firstName",
    qualifiedByName = "trimString"
  )
  @Mapping(
    source = "middleName",
    target = "middleName",
    qualifiedByName = "trimString"
  )
  @Mapping(
    source = "lastName",
    target = "lastName",
    qualifiedByName = "trimString"
  )
  @Mapping(source = "email", target = "email", qualifiedByName = "trimString")
  @Mapping(
    source = "mobileNumber",
    target = "mobileNumber",
    qualifiedByName = "trimString"
  )
  @Mapping(
    source = "mobileNumber",
    target = "mobileNumber",
    qualifiedByName = "convertMobileNumber"
  )
  Employee createDtoToEmployee(EmployeeCreateDTO dto);

  @Named("convertMobileFormat")
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

  @Named("trimString")
  default String trimString(String value) {
    return value == null ? null : value.trim();
  }
}
