package io.nology.employeecreatorbackend.employee;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService {

  @Autowired
  private EmployeeMapper employeeMapper;

  @Autowired
  private EmployeeRepository employeeRepository;

  public Employee create(EmployeeCreateDTO data) {
    Employee newEmployee = this.employeeMapper.createDtoToEmployee(data);
    this.employeeRepository.save(newEmployee);
    return newEmployee;
  }
}
