package io.nology.employeecreatorbackend.employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column
  String firstName;

  @Column
  String middleName;

  @Column
  String lastName;

  @Column
  String mobileNumber;

  @Column
  String email;
}
