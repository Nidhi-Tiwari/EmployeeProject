package com.prepare.employee.Controllers.Response;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
public class RegisterResponse {
    private Integer id;
    private String name;
    private int departmentId;
    private int salary;
    private int managerId;
    private String address;

    @Builder
    public RegisterResponse(Integer id, String name, int departmentId, int salary, int managerId, String address) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
        this.salary = salary;
        this.managerId = managerId;
        this.address = address;
    }
}
