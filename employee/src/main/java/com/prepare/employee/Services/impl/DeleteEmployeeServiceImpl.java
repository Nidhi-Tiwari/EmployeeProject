package com.prepare.employee.Services.impl;

import com.prepare.employee.ControllersPackage.Response.EmployeeDetailsResponse;
import com.prepare.employee.DataBaseConnection.EmployeeEntity;
import com.prepare.employee.Exceptions.CustomExceptions;
import com.prepare.employee.Repositories.EmployeeRepository;
import com.prepare.employee.Services.DeleteEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteEmployeeServiceImpl implements DeleteEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public EmployeeDetailsResponse deleteEmployee(int employeeID) {
        EmployeeEntity emp = this.employeeRepository.findById(employeeID).
                orElseThrow(() -> new CustomExceptions("User not found with user id " + employeeID));
        this.employeeRepository.delete(emp);
        return EmployeeDetailsResponse.builder().id(emp.getId()).name(emp.getName()).build();
    }
}
