package com.prepare.employee.ControllersPackage.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL) // to include only the not null values as response when pojo is converted to json.
public class EmployeeDetailsResponse {

    private Integer id;
    private String name;
    private int departmentId;
    private int salary;
    private int managerId;
    private String address;

    @Builder
    public EmployeeDetailsResponse(Integer id, String name, int departmentId, int salary, int managerId, String address) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
        this.salary = salary;
        this.managerId = managerId;
        this.address = address;
    }
}
