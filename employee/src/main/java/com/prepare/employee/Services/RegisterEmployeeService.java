package com.prepare.employee.Services;

import com.prepare.employee.Controllers.Request.RegisterRequest;
import com.prepare.employee.Controllers.Response.RegisterResponse;

public interface RegisterEmployeeService {

    RegisterResponse registerEmployee(RegisterRequest registerRequest);
}
