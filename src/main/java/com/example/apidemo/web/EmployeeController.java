package com.example.apidemo.web;

import com.example.apidemo.data.models.Employee;
import com.example.apidemo.data.payloads.request.EmployeeRequest;
import com.example.apidemo.data.payloads.response.MessageResponse;
import com.example.apidemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
  @Autowired
  EmployeeService service;

  @GetMapping("/all")
  public ResponseEntity<List<Employee>> getAllEmployee() {
    List<Employee> employees = service.getAllEmployee();
    return new ResponseEntity<>(employees, HttpStatus.OK);
  }

  @GetMapping("/find/{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
    Employee employee = service.getSingleEmployee(id);
    return new ResponseEntity<>(employee, HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<MessageResponse> addEmployee(@RequestBody EmployeeRequest request) {
    MessageResponse newEmployee = service.createEmployee(request);
    return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
  }

  @PutMapping("/update/{id}")
  public Optional<Employee> updateEmployee(@PathVariable Integer id, @RequestBody EmployeeRequest request) {
    return service.updateEmployee(id, request);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id) {
    service.deleteEmployee(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
