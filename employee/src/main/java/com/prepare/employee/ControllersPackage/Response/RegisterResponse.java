package com.prepare.employee.ControllersPackage.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL) // to include only the not null values as response when pojo is converted to json.
public class RegisterResponse {
    private Integer id;
    private String name;
    private Integer departmentId;
    private Integer salary;
    private Integer managerId;
    private String address;

    @Builder
    public RegisterResponse(Integer id, String name, Integer departmentId, Integer salary, Integer managerId, String address) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
        this.salary = salary;
        this.managerId = managerId;
        this.address = address;
    }
}
