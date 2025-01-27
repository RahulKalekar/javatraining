package com.empapp.basics;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "emp_table")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

@Column(name = "emp_name",nullable = false,length=100)
    private String name;
@Column(name="emp_salary",nullable = false)
    private double salary;
@Column(name="emp_dept",nullable = false)
    private String dept;

    public Employee(String name, double salary, String dept) {
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }


}
