package com.colak.springjpapostgrestutorial.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "employee")


@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private String data;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "json_list", columnDefinition = "jsonb")
    private List<Object> jsonList;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "json_map", columnDefinition = "jsonb")
    private Map<String, Object> jsonMap;

}