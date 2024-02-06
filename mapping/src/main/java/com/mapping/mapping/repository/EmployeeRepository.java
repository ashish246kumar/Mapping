package com.mapping.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapping.mapping.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByFirstNameContaining(String name);

}
