package com.example.FirstSpring.repository;

import com.example.FirstSpring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
