package com.colak.springtutorial.repository;

import com.colak.springtutorial.jpa.Employee;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification {

    public static Specification<Employee> hasDepartment(String department) {
        return (root, query, cb) -> cb.equal(
                cb.function("jsonb_extract_path_text", String.class, root.get("data"), cb.literal("department")),
                department
        );
    }
}
