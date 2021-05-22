package com.prepare.employee.Controllers.Request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data //getter setter set ho jaata he
@NoArgsConstructor
public class RegisterRequest {

    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    private Integer departmentId;
    @NotNull
    private Integer salary;
    private Integer managerId = 0;
    private String address = "Default";

    @Builder
    public RegisterRequest(@NotNull @NotEmpty String name, @NotNull Integer departmentId, @NotNull Integer salary,
                           Integer managerId, String address) {
        this.name = name;
        this.departmentId = departmentId;
        this.salary = salary;
        this.managerId = managerId;
        this.address = address;
    }
}
