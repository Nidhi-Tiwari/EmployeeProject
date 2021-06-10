package com.prepare.employee.domain.request;

import lombok.Builder;
import lombok.Data;

@Data
public class UserRequestBody {
    Integer id;
    String name;
    String departmentName;

    @Builder
    public UserRequestBody(Integer id, String name, String departmentName) {
        this.id = id;
        this.name = name;
        this.departmentName = departmentName;
    }
}
