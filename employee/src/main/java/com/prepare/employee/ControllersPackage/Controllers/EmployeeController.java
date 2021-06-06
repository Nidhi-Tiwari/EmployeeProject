package com.prepare.employee.ControllersPackage.Controllers;

import com.prepare.employee.ControllersPackage.Request.RegisterRequest;
import com.prepare.employee.ControllersPackage.Request.UpdateRequest;
import com.prepare.employee.ControllersPackage.Response.EmployeeDetailsResponse;
import com.prepare.employee.ControllersPackage.Response.RegisterResponse;
import com.prepare.employee.DataBaseConnection.EmployeeEntity;
import com.prepare.employee.Exceptions.CustomExceptions;
import com.prepare.employee.Repositories.EmployeeRepository;
import com.prepare.employee.Services.DeleteEmployeeService;
import com.prepare.employee.Services.RegisterEmployeeService;
import com.prepare.employee.Services.UpdateEmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RegisterEmployeeService registerEmployeeService;
    @Autowired
    private DeleteEmployeeService deleteEmployeeService;
    @Autowired
    private UpdateEmployeeDetailsService updateEmployeeDetailsService;

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST, produces = "application/json")
    public RegisterResponse registerEmployee(@RequestBody RegisterRequest requestBody) {
        return registerEmployeeService.registerEmployee(requestBody);
    }

    @RequestMapping(value = {"/deleteUser"}, produces = "application/json", method = RequestMethod.DELETE)
    public EmployeeDetailsResponse deleteEmployee(@RequestParam Integer id) {
        return deleteEmployeeService.deleteEmployee(id);
    }

    @RequestMapping(value = {"/getEmployee"}, produces = "application/json", method = RequestMethod.GET)
    public EmployeeEntity getEmployeeDetails(@RequestParam Integer id) {
        EmployeeEntity emp = this.employeeRepository.findById(id).orElseThrow(() -> new CustomExceptions("User not found with user id " + id));
        return emp;
    }

    @RequestMapping(value = {"/updateEmployee"}, method = RequestMethod.PATCH, produces = "application/json")
    public EmployeeDetailsResponse updateEmployee(@RequestBody UpdateRequest updateRequest) {
        return updateEmployeeDetailsService.updateEmployeeDetails(updateRequest);
    }
}
