package com.prepare.employee.Services;

import com.prepare.employee.ControllersPackage.Request.UpdateRequest;
import com.prepare.employee.ControllersPackage.Response.EmployeeDetailsResponse;

public interface UpdateEmployeeDetailsService {
    public EmployeeDetailsResponse updateEmployeeDetails(UpdateRequest updateRequest);
}
