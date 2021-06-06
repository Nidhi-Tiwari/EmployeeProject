package com.prepare.employee.Services;

import com.prepare.employee.ControllersPackage.Response.EmployeeDetailsResponse;

public interface DeleteEmployeeService {
    EmployeeDetailsResponse deleteEmployee(int employeeID);
}