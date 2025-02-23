package com.elasticsearch.service;

import com.elasticsearch.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Employee updateEmployee(String id, Employee employee);

    boolean deleteEmployee(String id);

    Employee getEmployeeById(String id);
}
