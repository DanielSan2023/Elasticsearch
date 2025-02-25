package com.elasticsearch.repository;


import com.elasticsearch.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {

    List<Employee> findByName(String name);

    Page<Employee> findAll(Pageable pageable);
}
