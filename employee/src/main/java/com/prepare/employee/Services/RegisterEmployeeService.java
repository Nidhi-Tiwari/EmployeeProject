package com.prepare.employee.Services;

import com.prepare.employee.ControllersPackage.Request.RegisterRequest;
import com.prepare.employee.ControllersPackage.Response.RegisterResponse;

public interface RegisterEmployeeService {

    RegisterResponse registerEmployee(RegisterRequest registerRequest);
}
