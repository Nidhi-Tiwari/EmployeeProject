package com.prepare.employee.ControllersPackage.Request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class UpdateRequest {
    @NotNull
    private Integer id;
    private String name;
    private Integer departmentId;
    private Integer salary;
    private Integer managerId;
    private String address;

    @Builder
    public UpdateRequest(@NotNull Integer id, String name, Integer departmentId, Integer salary, Integer managerId, String address) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
        this.salary = salary;
        this.managerId = managerId;
        this.address = address;
    }
}
