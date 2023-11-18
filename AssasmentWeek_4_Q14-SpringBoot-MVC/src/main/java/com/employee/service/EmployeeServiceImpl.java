package com.employee.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

 @Autowired
 private EmployeeRepository employeeRepository;

 @Override
 public List<Employee> getAllEmployees() {
     return employeeRepository.findAll();
 }

 @Override
 public Employee getEmployeeById(Long id) {
     Optional<Employee> optionalEmployee = employeeRepository.findById(id);
     return optionalEmployee.orElse(null);
 }

 @Override
 public void saveEmployee(Employee employee) {
     employeeRepository.save(employee);
 }


 public void updateEmployee(Long id, Employee updatedEmployee) {
     Optional<Employee> optionalEmployee = employeeRepository.findById(id);
     if (optionalEmployee.isPresent()) {
         Employee existingEmployee = optionalEmployee.get();
         existingEmployee.setFirstName(updatedEmployee.getFirstName());
         existingEmployee.setLastName(updatedEmployee.getLastName());
         existingEmployee.setEmail(updatedEmployee.getEmail());
         employeeRepository.save(existingEmployee);
     }
 }

 @Override
 public void deleteEmployee(Long id) {
     employeeRepository.deleteById(id);
 }


}