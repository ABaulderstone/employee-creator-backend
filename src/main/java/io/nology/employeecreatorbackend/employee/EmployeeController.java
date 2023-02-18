package io.nology.employeecreatorbackend.employee;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @PostMapping
  public ResponseEntity<Employee> create(
    @Valid @RequestBody EmployeeCreateDTO data
  ) {
    Employee createdEmployee = this.employeeService.create(data);
    return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Employee>> findAll() {
    List<Employee> allEmployees = this.employeeService.findAll();
    return new ResponseEntity<>(allEmployees, HttpStatus.OK);
  }
}
