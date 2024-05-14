package com.colak.springjpapostgrestutorial.repository;

import com.colak.springjpapostgrestutorial.jpa.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeSpecificationRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {

}
