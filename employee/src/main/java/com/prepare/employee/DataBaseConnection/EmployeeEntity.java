package com.prepare.employee.DataBaseConnection;

import lombok.Builder;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="department_id")
    private int departmentId;
    @Column(name="salary")
    private int salary;
    @Column(name="manager_id")
    private int managerId;
    @Column(name="address")
    private String address;

    @Builder
    public EmployeeEntity(String name, int departmentId, int salary, int managerId, String address) {
        this.name = name;
        this.departmentId = departmentId;
        this.salary = salary;
        this.managerId = managerId;
        this.address = address;
    }

}
