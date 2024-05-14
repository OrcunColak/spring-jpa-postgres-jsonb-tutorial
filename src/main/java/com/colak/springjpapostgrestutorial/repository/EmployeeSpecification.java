package com.colak.springjpapostgrestutorial.repository;

import com.colak.springjpapostgrestutorial.jpa.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification {

    public static Specification<Employee> hasDepartment(String department) {
        return new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(
                        cb.function("jsonb_extract_path_text", String.class, root.get("data"), cb.literal("department")),
                        department
                );
            }
        };
    }
}
