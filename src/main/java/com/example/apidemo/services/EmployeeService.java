package com.example.apidemo.services;

import com.example.apidemo.data.models.Employee;
import com.example.apidemo.data.payloads.request.EmployeeRequest;
import com.example.apidemo.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface EmployeeService {
  MessageResponse createEmployee(EmployeeRequest employeeRequest);
  Optional<Employee> updateEmployee(Integer employeeId, EmployeeRequest employeeRequest);
  void deleteEmployee(Integer employeeId);
  Employee getSingleEmployee(Integer employeeId);
  List<Employee> getAllEmployee();
}
