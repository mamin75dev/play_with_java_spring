package com.example.apidemo.services;

import com.example.apidemo.data.models.Employee;
import com.example.apidemo.data.payloads.request.EmployeeRequest;
import com.example.apidemo.data.payloads.response.MessageResponse;
import com.example.apidemo.data.repository.EmployeeRepository;
import com.example.apidemo.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  EmployeeRepository repository;

  @Override
  public MessageResponse createEmployee(EmployeeRequest employeeRequest) {
    Employee newEmployee = new Employee();
    newEmployee.setFirstName(employeeRequest.getFirstName());
    newEmployee.setLastName(employeeRequest.getLastName());
    newEmployee.setPhoneNumber(employeeRequest.getPhoneNumber());
    newEmployee.setEmail(employeeRequest.getEmail());
    newEmployee.setSalary(employeeRequest.getSalary());
    newEmployee.setDepartment(employeeRequest.getDepartment());
    repository.save(newEmployee);
    return new MessageResponse("New Employee created successfully.");
  }

  @Override
  public Optional<Employee> updateEmployee(Integer employeeId, EmployeeRequest employeeRequest) throws ResourceNotFoundException {
    Optional<Employee> employee = repository.findById(employeeId);
    if (employee.isEmpty()) {
      throw new ResourceNotFoundException("Employee", "id", employeeId);
    } else {
      employee.get().setFirstName(employeeRequest.getFirstName());
      employee.get().setLastName(employeeRequest.getLastName());
      employee.get().setPhoneNumber(employeeRequest.getPhoneNumber());
      employee.get().setEmail(employeeRequest.getEmail());
      employee.get().setSalary(employeeRequest.getSalary());
      employee.get().setDepartment(employeeRequest.getDepartment());
      repository.save(employee.get());
    }
    return employee;
  }

  @Override
  public void deleteEmployee(Integer employeeId) throws ResourceNotFoundException {
    if (repository.getById(employeeId).getId().equals(employeeId)) {
      repository.deleteById(employeeId);
    } else {
      throw new ResourceNotFoundException("Employee", "id", employeeId);
    }
  }

  @Override
  public Employee getSingleEmployee(Integer employeeId) throws ResourceNotFoundException {
    return repository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));
  }

  @Override
  public List<Employee> getAllEmployee() {
    return repository.findAll();
  }
}
