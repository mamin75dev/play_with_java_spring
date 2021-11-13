package com.example.apidemo.data.payloads.request;

import com.example.apidemo.data.models.Department;

import javax.persistence.*;
import javax.validation.constraints.*;

public class EmployeeRequest {
  @NotBlank
  @NotNull
  private String firstName;
  @NotBlank
  @NotNull
  private String lastName;
  @NotBlank
  @NotNull
  private String phoneNumber;
  @Email
  private String email;
  @NotBlank
  @NotNull
  private double salary;
  @NotBlank
  @NotNull
  @Enumerated(EnumType.STRING)
  private Department department;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }
}
