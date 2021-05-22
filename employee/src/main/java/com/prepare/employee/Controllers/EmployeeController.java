package com.prepare.employee.Controllers;

import com.prepare.employee.Controllers.Request.RegisterRequest;
import com.prepare.employee.Controllers.Response.RegisterResponse;
import com.prepare.employee.DataBaseConnection.EmployeeEntity;
import com.prepare.employee.Exceptions.CustomExceptions;
import com.prepare.employee.Repositories.EmployeeRepository;
import com.prepare.employee.Services.EmployeeService;
import com.prepare.employee.Services.RegisterEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RegisterEmployeeService registerEmployeeService;

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST, produces = "application/json")
    public RegisterResponse registerEmployee(@RequestBody RegisterRequest requestBody) {
//        if (!requestBody.containsKey("departmentId"))
//            return new ResponseEntity<>("Department id is missing !!", HttpStatus.BAD_REQUEST);
//        if (!requestBody.containsKey("name"))
//            return new ResponseEntity<>("Name is missing !!", HttpStatus.BAD_REQUEST);
//        if (!requestBody.containsKey("salary"))
//            return new ResponseEntity<>("Salary is missing !!", HttpStatus.BAD_REQUEST);
//        int managerId = 0;
//        String address = "default";
//        if (requestBody.containsKey("managerId"))
//            managerId = (int) requestBody.get("managerId");
//        if (requestBody.containsKey("address"))
//            address = requestBody.get("address").toString();
//        int departmentId = (int) requestBody.get("departmentId");
//        int salary = (int) requestBody.get("salary");
//        String name = requestBody.get("name").toString();
        return registerEmployeeService.registerEmployee(requestBody);
//        ResponseEntity<?> responseEntity = EmployeeService.getInstance().registerUser(name, departmentId, salary, managerId, address);
//        return responseEntity;
    }

    @RequestMapping(value = {"/deleteUser"}, produces = "application/json", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEmployee(@RequestParam Integer id) {
        EmployeeEntity emp = this.employeeRepository.findById(id).
                orElseThrow(() -> new CustomExceptions("User not found with user id " + id));
        this.employeeRepository.delete(emp);
        return new ResponseEntity<>("User Deleted Successfully",HttpStatus.OK);
    }

    @RequestMapping(value = {"/getEmployee"}, produces = "application/json", method = RequestMethod.GET)
    public EmployeeEntity getEmployeeDetails(@RequestParam Integer id) {
        EmployeeEntity emp = this.employeeRepository.findById(id).orElseThrow(() -> new CustomExceptions("User not found with user id " + id));
        return emp;
    }
}
