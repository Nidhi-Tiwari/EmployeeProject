package com.prepare.employee.Controllers;

import com.prepare.employee.DataBaseConnection.Employee;
import com.prepare.employee.Exceptions.CustomExceptions;
import com.prepare.employee.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(value = {"/register"} , method = RequestMethod.POST,produces = "application/json")
    public Employee registerEmployee(@RequestBody Employee emp){
        return this.employeeRepository.save(emp);
    }

    @RequestMapping(value = {"/deleteUser"},produces = "application/json",method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id){
        Employee emp = this.employeeRepository.findById(id).
                orElseThrow(()-> new CustomExceptions("User not found with user id "+id));
        this.employeeRepository.delete(emp);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = {"/getEmployee"}, produces ="application/json",method = RequestMethod.GET)
    public Employee getEmployeeDetails(@PathVariable Long id){
        Employee emp = this.employeeRepository.findById(id).orElseThrow(()-> new CustomExceptions("User not found with user id "+id));
        return emp;
    }
}
