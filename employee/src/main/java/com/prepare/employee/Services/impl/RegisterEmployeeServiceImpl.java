package com.prepare.employee.Services.impl;

import com.prepare.employee.ControllersPackage.Request.RegisterRequest;
import com.prepare.employee.ControllersPackage.Response.RegisterResponse;
import com.prepare.employee.DataBaseConnection.EmployeeEntity;
import com.prepare.employee.Repositories.EmployeeRepository;

import com.prepare.employee.Services.RegisterEmployeeService;
import com.prepare.employee.util.RequestParamValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterEmployeeServiceImpl implements RegisterEmployeeService {

    private final RequestParamValidator<RegisterRequest> registerRequestRequestParamValidator;

    private final EmployeeRepository employeeRepository;

    public RegisterEmployeeServiceImpl(RequestParamValidator<RegisterRequest> registerRequestRequestParamValidator, EmployeeRepository employeeRepository) {
        this.registerRequestRequestParamValidator = registerRequestRequestParamValidator;
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public RegisterResponse registerEmployee(RegisterRequest registerRequest) {
        //validation
        registerRequestRequestParamValidator.validate(registerRequest);
        //checks
        //usecase
        EmployeeEntity employeeEntity = EmployeeEntity.builder().
                salary(registerRequest.getSalary()).
                managerId(registerRequest.getManagerId()).
                departmentId(registerRequest.getDepartmentId()).
                address(registerRequest.getAddress()).
                name(registerRequest.getName()).build();
        EmployeeEntity employeeEntityResponse = this.employeeRepository.save(employeeEntity);
        return RegisterResponse.builder().address(employeeEntityResponse.getAddress())
                .departmentId(employeeEntityResponse.getDepartmentId()).
                        id(employeeEntityResponse.getId()).
                        managerId(employeeEntityResponse.getManagerId()).
                        name(employeeEntityResponse.getName()).
                        salary(employeeEntityResponse.getSalary())
                .build();
    }
}
