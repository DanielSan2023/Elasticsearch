package com.elasticsearch.service;

import com.elasticsearch.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Employee updateEmployee(String id, Employee employee);

    boolean deleteEmployee(String id);

    Employee getEmployeeById(String id);

    List<Employee> getEmployeesByName(String name);

    Page<Employee> paginateEmployee(int page, int size);
}
