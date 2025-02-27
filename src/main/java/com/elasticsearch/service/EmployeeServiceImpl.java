package com.elasticsearch.service;

import com.elasticsearch.entity.Employee;
import com.elasticsearch.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll(PageRequest.of(0, 10)).toList();
    }

    @Override
    public Employee updateEmployee(String id, Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee oldEmployee = optionalEmployee.get();
            oldEmployee.setName(employee.getName());
            oldEmployee.setEmail(employee.getEmail());
            return employeeRepository.save(oldEmployee);
        }
        return null;
    }

    @Override
    public boolean deleteEmployee(String id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            employeeRepository.delete(optionalEmployee.get());
            return true;
        }
        return false;
    }

    @Override
    public Employee getEmployeeById(String id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.orElse(null);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public Page<Employee> paginateEmployee(int page, int size) {
        PageRequest peageble = PageRequest.of(page, size);
        return employeeRepository.findAll(peageble);
    }

    @Override
    public List<Employee> filterEmployeesBySalaryRange(double min, double max) {
        return employeeRepository.findBySalaryBetween(min, max);
    }

    @Override
    public List<Employee> searchByNameMatchQuery(String name) {
        return employeeRepository.findByNameMatchQuery(name);
    }

    @Override
    public List<Employee> searchByNameAndSalaryMatchQuery(String name, double minSalary) {
        return employeeRepository.findByNameMatchQueryAndSalary(name,minSalary);
    }

    @Override
    public List<Employee> searchBySalaryRange(double minSalary, double maxSalary) {
        return employeeRepository.findBySalaryRange(minSalary,maxSalary);
    }
}
