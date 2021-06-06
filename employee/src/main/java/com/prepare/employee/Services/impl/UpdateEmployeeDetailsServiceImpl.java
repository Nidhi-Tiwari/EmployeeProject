package com.prepare.employee.Services.impl;

import com.prepare.employee.ControllersPackage.Request.UpdateRequest;
import com.prepare.employee.ControllersPackage.Response.EmployeeDetailsResponse;
import com.prepare.employee.DataBaseConnection.EmployeeEntity;
import com.prepare.employee.Exceptions.CustomExceptions;
import com.prepare.employee.Repositories.EmployeeRepository;
import com.prepare.employee.Services.UpdateEmployeeDetailsService;
import com.prepare.employee.util.CustomMapper;
import com.prepare.employee.util.RequestParamValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@Service
public class UpdateEmployeeDetailsServiceImpl implements UpdateEmployeeDetailsService {
    private final RequestParamValidator<UpdateRequest> updateRequestRequestParamValidator;
    private final EmployeeRepository employeeRepository;
    private final CustomMapper customMapper;

    public UpdateEmployeeDetailsServiceImpl(RequestParamValidator<UpdateRequest> updateRequestRequestParamValidator, EmployeeRepository employeeRepository, CustomMapper customMapper) {
        this.updateRequestRequestParamValidator = updateRequestRequestParamValidator;
        this.employeeRepository = employeeRepository;
        this.customMapper = customMapper;
    }

    @Transactional
    @Override
    public EmployeeDetailsResponse updateEmployeeDetails(UpdateRequest updateRequest) {
        updateRequestRequestParamValidator.validate(updateRequest);
        EmployeeEntity emp = this.employeeRepository.findById(updateRequest.getId()).
                orElseThrow(() -> new CustomExceptions("User not found with user id " + updateRequest.getId()));
        customMapper.updateEmployeeFromEmployeeTable(updateRequest, emp);
        EmployeeEntity employeeEntityResponse = this.employeeRepository.save(emp);
        return EmployeeDetailsResponse.builder().address(employeeEntityResponse.getAddress())
                .departmentId(employeeEntityResponse.getDepartmentId()).
                        id(employeeEntityResponse.getId()).
                        managerId(employeeEntityResponse.getManagerId()).
                        name(employeeEntityResponse.getName()).
                        salary(employeeEntityResponse.getSalary()).build();
    }
}
