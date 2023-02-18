package io.nology.employeecreatorbackend.employee;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
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

  public List<Employee> findAll() {
    return this.employeeRepository.findAll();
  }
}
