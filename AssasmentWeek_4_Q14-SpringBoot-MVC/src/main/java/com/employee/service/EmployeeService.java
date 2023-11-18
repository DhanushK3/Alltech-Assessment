package com.employee.service;

import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    void saveEmployee(Employee employee);
    void updateEmployee(Long id, Employee updatedEmployee);
    void deleteEmployee(Long id);
}
