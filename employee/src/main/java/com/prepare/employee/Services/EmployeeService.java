package com.prepare.employee.Services;

import com.prepare.employee.DataBaseConnection.EmployeeEntity;
import com.prepare.employee.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private static volatile EmployeeService employeeServiceInstance = null;

    private EmployeeService() {
    }

    public static EmployeeService getInstance() {
        if (employeeServiceInstance == null) {
            synchronized (EmployeeService.class) {
                if (employeeServiceInstance == null) {
                    employeeServiceInstance = new EmployeeService();
                }
            }
        }
        return employeeServiceInstance;
    }

    public ResponseEntity<?> registerUser(String name, int departmentId, int salary, int managerId, String address) {
        EmployeeEntity employeeEntity = EmployeeEntity.builder().
                salary(salary).
                managerId(managerId).
                departmentId(departmentId).
                address(address).name(name).build();
         this.employeeRepository.save(employeeEntity);
         return new ResponseEntity<>("User Registered successFully !!", HttpStatus.OK);
    }
}
