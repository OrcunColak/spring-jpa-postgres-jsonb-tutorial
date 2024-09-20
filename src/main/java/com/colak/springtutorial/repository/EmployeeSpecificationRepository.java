package com.colak.springtutorial.repository;

import com.colak.springtutorial.jpa.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeSpecificationRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {

}
