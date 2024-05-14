package com.colak.springjpapostgrestutorial.controller;

import com.colak.springjpapostgrestutorial.jpa.Employee;
import com.colak.springjpapostgrestutorial.repository.EmployeeRepository;
import com.colak.springjpapostgrestutorial.repository.EmployeeSpecification;
import com.colak.springjpapostgrestutorial.repository.EmployeeSpecificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    private final EmployeeSpecificationRepository employeeSpecificationRepository;

    // http://localhost:8080/employees/Finance
    @GetMapping("/employees/{department}")
    public List<Employee> getByDepartment(@PathVariable String department) {
        return employeeRepository.findByDepartment(department);
    }

    // http://localhost:8080/employees/Specification/Finance
    @GetMapping("/employees/Specification/{department}")
    public List<Employee> getBySpecificationDepartment(@PathVariable String department) {
        Specification<Employee> spec = EmployeeSpecification.hasDepartment(department);
        return employeeSpecificationRepository.findAll(spec);
    }

    // http://localhost:8080/employees/jsonMap/skills
    @GetMapping("/employees/jsonMap/{name}")
    public List<Employee> getByNameFromJsonMap(@PathVariable String name) {
        return employeeRepository.findByNameInJsonMap(name);
    }

    /*
    @GetMapping("/employees/sumOfCounts")
    public Integer getSumOfCountsInJsonMap() {
        return employeeRepository.findSumOfCountsInJsonMap();
    }

    @GetMapping("/employees/jsonList/{item}")
    public List<Employee> getByJsonList(@PathVariable String item) {
        return employeeRepository.findByitemFromJsonList(item);
    }
*/
    @PostMapping("/employees/add")
    public Employee addEmployee() {
        Employee employee = new Employee();
        employee.setName("NGU");
        employee.setData("{\"name\":\"NGU\",\"department\":\"IT\"}");
        employee.setJsonList(List.of("1", "2", "3"));
        employee.setJsonMap(Map.of("name", "NGU", "department", "IT", "count", 3));
        return employeeRepository.save(employee);
    }
}