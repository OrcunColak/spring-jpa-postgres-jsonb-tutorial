package com.colak.springtutorial.repository;

import com.colak.springtutorial.jpa.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT * FROM employee WHERE data->>'department' = ?1", nativeQuery = true)
    List<Employee> findByDepartment(String department);


    @Query(value = "SELECT * FROM employee WHERE json_map->>'name' = ?1", nativeQuery = true)
    List<Employee> findByNameInJsonMap(String name);

/*
    //query to find Employee by json_list contains id
    @Query(value = "SELECT * FROM employee WHERE jsonb_contains(json_list, CAST(:item AS jsonb))", nativeQuery = true)
    List<Employee> findByitemFromJsonList(@Param("item") String item);


    //query to find sum of counts in json_map
    @Query(value = "SELECT SUM(CAST(json_map->>'count' AS numeric)) FROM employee", nativeQuery = true)
    Integer findSumOfCountsInJsonMap();
*/
}
